package com.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebXmlReplacer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class configClass[] = { com.configuration.Config.class };
		return configClass;
	}

	@Override
	protected String[] getServletMappings() {
		String url[] = { "/app/*" };
		return url;
	}

}
