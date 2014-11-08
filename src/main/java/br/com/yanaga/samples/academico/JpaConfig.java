package br.com.yanaga.samples.academico;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.URI;

@Configuration
@EnableTransactionManagement
public class JpaConfig {

	@Autowired
	private URI databaseUri;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPersistenceUnitName("academico");
		return factoryBean;
	}

	@Bean
	public DataSource dataSource() {
		String[] userInfo = databaseUri.getUserInfo().split(":");

		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(String.format("jdbc:postgresql://%s%s", databaseUri.getHost(), databaseUri.getPath()));
		dataSource.setUsername(userInfo[0]);
		dataSource.setPassword(userInfo[1]);
		dataSource.setMinIdle(10);
		dataSource.setMaxActive(200);
		dataSource.setTestOnBorrow(true);
		dataSource.setTestOnReturn(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setRemoveAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(300);
		dataSource.setMaxWait(5000);
		dataSource.setValidationQuery("SELECT 1 FROM DUAL");
		dataSource.setTimeBetweenEvictionRunsMillis(1800000);
		dataSource.setNumTestsPerEvictionRun(3);
		dataSource.setMinEvictableIdleTimeMillis(1800000);
		return dataSource;
	}

}
