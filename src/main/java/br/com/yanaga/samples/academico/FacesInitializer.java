package br.com.yanaga.samples.academico;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Component
public class FacesInitializer implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", "true");
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		servletContext.setInitParameter("javax.faces.FACELETS_LIBRARIES", "/WEB-INF/taglib/produtec.taglib.xml;/WEB-INF/taglib/springsecurity.taglib.xml");
	}

}
