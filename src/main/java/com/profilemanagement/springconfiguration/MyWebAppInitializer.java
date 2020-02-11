package com.profilemanagement.springconfiguration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Using 2nd method");
		return new Class<?>[] { WebMvcConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		 return new String[] { "/profilemanagement/*" };
	}

}
