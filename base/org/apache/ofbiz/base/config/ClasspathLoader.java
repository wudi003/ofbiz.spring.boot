package org.apache.ofbiz.base.config;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.ofbiz.base.location.FlexibleLocation;
import org.apache.ofbiz.base.util.UtilURL;

public class ClasspathLoader extends ResourceLoader implements java.io.Serializable {
	private static final long serialVersionUID = 8142636361595455800L;

	@Override
	public InputStream loadResource(String location) throws GenericConfigException{
		URL fileUrl = getURL(location);
        try {
            return fileUrl.openStream();
        } catch (java.io.IOException e) {
            throw new GenericConfigException("Error opening file at location [" + fileUrl.toExternalForm() + "]", e);
        }
	}
	
	public URL resolveLocation(String location, ClassLoader loader) throws MalformedURLException {
        String baseLocation = FlexibleLocation.stripLocationType(location);
        // if there is a leading forward slash, remove it
        if (baseLocation.charAt(0) == '/') {
            baseLocation = baseLocation.substring(1);
        }
        return UtilURL.fromResource(baseLocation, loader);
    }

	@Override
	public URL getURL(String location) throws GenericConfigException{
		String fullLocation = fullLocation(location);
		try {
			return resolveLocation(fullLocation, null);
		} catch (MalformedURLException e) {
			throw new GenericConfigException(e);
		}
	}

}
