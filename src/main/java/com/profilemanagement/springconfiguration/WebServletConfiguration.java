package com.profilemanagement.springconfiguration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration {/*implements WebApplicationInitializer {

	@Override
	public void onStartup(final ServletContext servletContext) throws ServletException {
		System.out.println("\n\n\n\nUsing ServletRegistration.Dynamic #####\n\n\n\n");
		final AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebMvcConfiguration.class);
		webContext.refresh();
		
		//webContext.setServletContext(servletContext);
		final DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
		final ServletRegistration.Dynamic registration = servletContext.addServlet("DispatcherServlet", dispatcherServlet);
		registration.setLoadOnStartup(0);
		registration.addMapping("/profilemanagement/*");
	}*/
}
