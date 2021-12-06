package org.team.g2.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.team.g2.fundboard.config.FundServletConfig;

import java.io.IOException;

@EnableWebMvc
@ComponentScan(basePackages = {"org.team.g2.fundboard.controller", "org.team.g2.security.controller","org.team.g2.common.exception"})
@Import(FundServletConfig.class)
public class ServletConfig implements WebMvcConfigurer {

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();

		resolver.setMaxUploadSize(1024 * 1024 * 10); // 10MB
		resolver.setMaxUploadSizePerFile(1024 * 1024 * 2); // 2MB
		resolver.setMaxInMemorySize(1024 * 1024); // 1MB
		resolver.setUploadTempDir(new FileSystemResource("C:\\ftmp")); // temp upload

		resolver.setDefaultEncoding("UTF-8");

		return resolver;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
