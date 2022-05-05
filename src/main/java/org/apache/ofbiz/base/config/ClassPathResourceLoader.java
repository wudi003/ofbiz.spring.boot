package org.apache.ofbiz.base.config;

import java.io.InputStream;
import java.net.URL;

import org.springframework.core.io.ClassPathResource;

public class ClassPathResourceLoader extends ResourceLoader implements java.io.Serializable {
	private static final long serialVersionUID = 4660146472687963757L;

	@Override
	public InputStream loadResource(String location) throws GenericConfigException {
		 String fullLocation = fullLocation(location);
	        try {
	            return new ClassPathResource(fullLocation).getInputStream();
	        } catch (java.io.IOException e) {
	            throw new GenericConfigException("Error opening file at location [" + fullLocation + "]", e);
	        }
	}

	@Override
	public URL getURL(String location) throws GenericConfigException {
		
		 String fullLocation = fullLocation(location);
		 throw new GenericConfigException("File Resource not found: " + fullLocation);
	}

}
