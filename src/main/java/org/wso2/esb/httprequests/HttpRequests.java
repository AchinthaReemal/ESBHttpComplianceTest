package org.wso2.esb.httprequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.wso2.esb.payload.RequestPayload;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class HttpRequests {

	private final String USER_AGENT = "Mozilla/5.0";
	private static Logger logger;
	private static String base_url;
	private HttpClient httpclient;
	private Header[] responseHeaders;
	private HttpResponse response;
	private BufferedReader bufferedReader;
	private StringBuffer resultsBuffer;
	private RequestPayload requestPayload;

	public HttpRequests() {
		logger = Logger.getAnonymousLogger();
		base_url = "http://localhost:8280/services/ESBHttpComplianceTest";
		httpclient = new DefaultHttpClient();
	}

	// HTTP GET request
	public int sendGet() throws Exception {

		HttpGet httpget = new HttpGet(base_url);

		// add request header
		httpget.addHeader("User-Agent", USER_AGENT);

		response = httpclient.execute(httpget);

		logger.info("Sending 'GET' request to URL : " + base_url);
		logger.info("Response Code : "
				+ response.getStatusLine().getStatusCode());

		bufferedReader = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		resultsBuffer = new StringBuffer();
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			resultsBuffer.append(line);
		}

		logger.info("Entity content  :" + resultsBuffer.toString());

		return response.getStatusLine().getStatusCode();

	}

	public String sendPostWithPayload(String postType) throws Exception {

		HttpPost httppost = new HttpPost(base_url);
		requestPayload = new RequestPayload();
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		
		if (postType.equals("PostFor201")) {	
			
			httppost.addHeader("User-Agent", USER_AGENT);
			httppost.addHeader("Post-Type", "PostFor201");
			
		}
		else{
			
			httppost.addHeader("User-Agent", USER_AGENT);
			httppost.addHeader("Post-Type", "PostFor200");
			
		}	
			StringEntity entity = new StringEntity(requestPayload.getPayload(),
					"text/xml", "ISO-8859-1");

			httppost.addHeader("Accept", "text/xml");
			httppost.setEntity(entity);

			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String responseBody = httpclient.execute(httppost, responseHandler);

			logger.info("Sending 'POST' request to URL : " + base_url);

			logger.info("responseBody : " + responseBody);
			
			return responseBody;
		

	}

	public int sendHEAD() throws Exception {

		HttpHead httphead = new HttpHead(base_url);

		// add request header
		httphead.addHeader("User-Agent", USER_AGENT);

		response = httpclient.execute(httphead);

		logger.info("Sending 'HEAD' request to URL : " + base_url);
		logger.info("Response Code : "
				+ response.getStatusLine().getStatusCode());

		responseHeaders = response.getAllHeaders();

		logger.info("Response Headers: ");
		for (Header header : responseHeaders) {
			logger.info(header.toString());
		}
		return response.getStatusLine().getStatusCode();
	}

	public String sendPUTWithPayload() throws IOException {

		HttpPut httpput = new HttpPut(base_url);
		requestPayload = new RequestPayload();

		StringEntity entity = new StringEntity(requestPayload.getPayload(),
				"text/xml", "ISO-8859-1");

		httpput.addHeader("User-Agent", USER_AGENT);
		httpput.addHeader("Accept", "text/xml");
		httpput.setEntity(entity);

		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String responseBody = httpclient.execute(httpput, responseHandler);

		logger.info("Sending 'PUT' request to URL : " + base_url);

		logger.info("responseBody : " + responseBody);

		return responseBody;
	}

	// public String sendDELETEWithPayload() throws ClientProtocolException,
	// IOException {
	//
	// HttpDelete httpdelete = new HttpDelete(base_url);
	//
	// requestPayload = new RequestPayload();
	//
	// StringEntity entity = new StringEntity(requestPayload.getPayload(),
	// "text/xml", "ISO-8859-1");
	//
	// httpdelete.addHeader("User-Agent", USER_AGENT);
	// httpdelete.addHeader("Accept", "text/xml");
	// httpdelete.setEntity(entity);
	//
	// ResponseHandler<String> responseHandler = new BasicResponseHandler();
	// String responseBody = httpclient.execute(httpdelete, responseHandler);
	//
	// logger.info("Sending 'PUT' request to URL : " + base_url);
	//
	// logger.info("responseBody : " + responseBody);
	//
	// return responseBody;
	//
	// }

	public int sendDELETEWithoutPayload() throws ClientProtocolException,
			IOException {

		HttpDelete httpdelete = new HttpDelete(base_url);

		httpdelete.addHeader("User-Agent", USER_AGENT);

		response = httpclient.execute(httpdelete);

		logger.info("Sending 'DELETE' request to URL : " + base_url);
		logger.info("Response Code : "
				+ response.getStatusLine().getStatusCode());

		bufferedReader = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		resultsBuffer = new StringBuffer();
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			resultsBuffer.append(line);
		}

		logger.info("Entity content  :" + resultsBuffer.toString());

		responseHeaders = response.getAllHeaders();

		logger.info("Response Headers: ");
		for (Header header : responseHeaders) {
			logger.info(header.toString());
		}

		return response.getStatusLine().getStatusCode();

	}

}
