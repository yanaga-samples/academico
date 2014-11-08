package br.com.yanaga.samples.academico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.faces.config.AbstractFacesFlowConfiguration;
import org.springframework.faces.mvc.JsfView;
import org.springframework.faces.webflow.FlowFacesContextLifecycleListener;
import org.springframework.faces.webflow.JsfFlowHandlerAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;
import org.springframework.webflow.persistence.JpaFlowExecutionListener;
import org.springframework.webflow.security.SecurityFlowExecutionListener;

import javax.persistence.EntityManagerFactory;

@Configuration
public class WebflowConfig extends AbstractFacesFlowConfiguration {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder(flowBuilderServices())
				.setBasePath("/WEB-INF/flows")
				.addFlowLocationPattern("/**/*-flow.xml")
				.build();
	}

	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(flowRegistry())
				.setMaxFlowExecutions(5)
				.setMaxFlowExecutionSnapshots(10)
				.addFlowExecutionListener(new FlowFacesContextLifecycleListener())
				.addFlowExecutionListener(new JpaFlowExecutionListener(entityManagerFactory, transactionManager))
				.addFlowExecutionListener(new SecurityFlowExecutionListener())
				.build();
	}

	@Bean
	public FlowBuilderServices flowBuilderServices() {
		return getFlowBuilderServicesBuilder().setDevelopmentMode(true).build();
	}

	@Bean
	public ServletRegistrationBean webflowServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean();
		registration.setServlet(new DispatcherServlet(new AnnotationConfigWebApplicationContext()));
		registration.addUrlMappings("/spring/*");
		registration.setLoadOnStartup(1);
		registration.setName("webflowServlet");
		return registration;
	}

	@Bean
	public FlowHandlerMapping flowHandlerMapping() {
		FlowHandlerMapping mapping = new FlowHandlerMapping();
		mapping.setOrder(1);
		mapping.setFlowRegistry(flowRegistry());
		mapping.setDefaultHandler(new UrlFilenameViewController());
		return mapping;
	}

	@Bean
	public FlowHandlerAdapter flowHandlerAdapter() {
		JsfFlowHandlerAdapter adapter = new JsfFlowHandlerAdapter();
		adapter.setFlowExecutor(flowExecutor());
		return adapter;
	}

	@Bean
	public UrlBasedViewResolver faceletsViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(JsfView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".xhtml");
		return resolver;
	}

	@Bean
	public SimpleControllerHandlerAdapter simpleControllerHandlerAdapter() {
		return new SimpleControllerHandlerAdapter();
	}

}
