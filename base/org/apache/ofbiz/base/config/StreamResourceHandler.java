package org.apache.ofbiz.base.config;

import java.io.InputStream;
import java.net.URL;

import org.apache.ofbiz.base.util.UtilXml;
import org.w3c.dom.Document;

public final class StreamResourceHandler implements ResourceHandler {
	private static final long serialVersionUID = 3077829916291738328L;
	private final String type;
	private final String readerName;
	private final String loader;
	private final String location;
	private final InputStream stream;
	private final URL url;
	
	public StreamResourceHandler(String type, String location,InputStream stream, URL url) {
		super();
		this.type=type;
		this.readerName="main";
		this.loader = "main";
		this.location=location;
		this.stream = stream;
		this.url = url;
	}

	public StreamResourceHandler(String type,String readerName,String loader, String location,InputStream stream, URL url) {
		super();
		this.type=type;
		this.readerName=readerName;
		this.loader = loader;
		this.location=location;
		this.stream = stream;
		this.url = url;
	}

	@Override
	public String getLoaderName() {
		return loader;
	}

	@Override
	public String getLocation() {
		return loader;
	}

	@Override
	public Document getDocument() throws GenericConfigException {
		try {
			return UtilXml.readXmlDocument(this.getStream(), this.location, true);
		} catch (org.xml.sax.SAXException | javax.xml.parsers.ParserConfigurationException | java.io.IOException e) {
			throw new GenericConfigException("Error reading " + this.toString(), e);
		}
	}

	@Override
	public InputStream getStream() throws GenericConfigException {
		return this.stream;
	}

	@Override
	public URL getURL() throws GenericConfigException {
		return url;
	}

	@Override
	public boolean isFileResource() throws GenericConfigException {
		return false;
	}

	@Override
	public String getFullLocation() throws GenericConfigException {
		return location;
	}

	public String getType() {
		return this.type;
	}

	public String getReaderName() {
		return this.readerName;
	}
}
