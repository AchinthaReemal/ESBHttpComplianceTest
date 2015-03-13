package org.wso2.esb.httpmethodrevision;

import java.net.URI;

import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

@NotThreadSafe
public class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
	public static final String METHOD_NAME = "DELETE";

	public String getMethod() {
		return METHOD_NAME;
	}

	public HttpDeleteWithBody(final String uri) {
		super();
		setURI(URI.create(uri));
	}

	public HttpDeleteWithBody(final URI uri) {
		super();
		setURI(uri);
	}

	public HttpDeleteWithBody() {
		super();
	}
	
}