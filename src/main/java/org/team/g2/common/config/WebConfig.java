package org.team.g2.common.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.team.g2.security.config.SecurityConfig;
import org.team.g2.security.config.SecurityServletConfig;


import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

@Log4j2
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("1.........................");
		log.info("1..........................");
		return new Class[]{RootConfig.class , SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{ServletConfig.class , SecurityServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound","true"); //지정한페이지에서 에러페이지나올수있도록 지정
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter uft8Filter = new CharacterEncodingFilter();
		uft8Filter.setEncoding("UTF-8");
		uft8Filter.setForceEncoding(true);

		return new Filter[]{uft8Filter};
	}
}
