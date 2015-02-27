package org.wso2.esb.httprequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.wso2.esb.payload.MessagePayload;

public class HttpRequests {

	private final String USER_AGENT = "Mozilla/5.0";
	private static Logger logger;
	private static String base_url;
	private HttpClient httpclient;
	private Header[] responseHeaders;
	private HttpResponse response;
	private BufferedReader bufferedReader;
	private StringBuffer resultsBuffer;
	private MessagePayload requestPayload;
	private String[] responseArray;
	private String[] responseArrayForHead;

	public HttpRequests() {
		logger = Logger.getAnonymousLogger();
		base_url = "http://localhost:8280/services/ESBHttpComplianceTest";
		httpclient = new DefaultHttpClient();
		responseArray = new String[2];
		responseArrayForHead = new String[3];
	}

	// Set request type header for different request methods
	public String setRequestTypeHeader(String method) {
		String requestTypeHeader = method + "-Type";
		return requestTypeHeader;
	}

	// Set request type header for different request methods
	public String setResponseServerHeader(String method) {
		String requestTypeHeader = method + "-Type";
		return requestTypeHeader;
	}

	// Obtain returned responses of the relevant requests and set responseArray
	public void getResponseDetails(HttpResponse httpResponse)
			throws IllegalStateException, IOException {
		bufferedReader = new BufferedReader(new InputStreamReader(httpResponse
				.getEntity().getContent()));

		resultsBuffer = new StringBuffer();
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			resultsBuffer.append(line);
			responseArray[1] = resultsBuffer.toString();
		}

		responseArray[0] = Integer.toString(response.getStatusLine()
				.getStatusCode());

	}

	// Generate Logs to indicate requested method and its responses
	public void generateLogs(String method) {
		logger.info("Sending " + method + " request to URL : " + base_url);
		logger.info("Response Code : "
				+ response.getStatusLine().getStatusCode());
		if (resultsBuffer != null) {
			logger.info("Entity content  :" + resultsBuffer.toString());
		}
		resultsBuffer = null;

		if (responseHeaders != null) {
			logger.info("Response Headers: ");
			for (Header header : responseHeaders) {
				logger.info(header.toString());
			}
			responseHeaders = null;

		}
		logger.info("-----------------------------------------------------------------------");
	}

	// HTTP GET request
	public String[] sendGet(String getType, String additional,
			String payloadInclusion, String serverType) throws Exception {

		HttpGet httpget = new HttpGet(base_url);
		httpget.addHeader("User-Agent", USER_AGENT);
		httpget.addHeader("Response-Server", serverType);
		httpget.addHeader(setRequestTypeHeader("GET"), getType);
		
		if(getType.equals("GetFor416")){
			httpget.addHeader("Range","bytes=199-399");
		}
		if(getType.equals("GetFor417")){
			httpget.addHeader("Expect","100-continue");
		}

		response = httpclient.execute(httpget);

		try {
			getResponseDetails(response);
			generateLogs("GET");
		} catch (NullPointerException nullPointerException) {
			return null;
		}
		return responseArray;
	}

	// HTTP POST request
	public String[] sendPost(String postType, String additional,
			String payloadInclusion, String serverType) throws Exception {

		HttpPost httppost = new HttpPost(base_url);
		requestPayload = new MessagePayload();
		httppost.addHeader("User-Agent", USER_AGENT);
		httppost.addHeader("Response-Server", serverType);
		
		if(postType.equals("PostFor416")){
			httppost.addHeader("Range","bytes=199-399");
		}
		if(postType.equals("PostFor417")){
			httppost.addHeader("Expect","100-continue");
		}
		
		
		httppost.addHeader(setRequestTypeHeader("POST"), postType);

		if (additional.equals("WithOutResponseBody")) {
			httppost.addHeader("Response-Type", "WithOutBody");
		} else {
			httppost.addHeader("Response-Type", "WithBody");
		}

		if (payloadInclusion.equals("WithPayload")) {
			StringEntity entity = new StringEntity(
					requestPayload.getMediumPayload(), "text/xml", "ISO-8859-1");
			httppost.addHeader("Accept", "text/xml");
			httppost.setEntity(entity);
		}
		response = httpclient.execute(httppost);

		try {
			getResponseDetails(response);
			generateLogs("POST");

			return responseArray;
		} catch (NullPointerException nullPointerException) {
			return null;
		}
	}

	// HTTP HEAD request
	public String[] sendHEAD(String headType, String serverType)
			throws Exception {

		HttpHead httphead = new HttpHead(base_url);
		httphead.addHeader("User-Agent", USER_AGENT);
		httphead.addHeader("Response-Server", serverType);		
		httphead.addHeader(setRequestTypeHeader("HEAD"), headType);
		
		if(headType.equals("HeadFor416")){
			httphead.addHeader("Range","bytes=199-399");
		}
		if(headType.equals("HeadFor417")){
			httphead.addHeader("Expect","100-continue");
		}

		response = httpclient.execute(httphead);
		responseHeaders = response.getAllHeaders();

		responseArrayForHead[0] = Integer.toString(response.getStatusLine()
				.getStatusCode());
		for (Header header : responseHeaders) {
			if (header.getName().equals("Location")) {
				responseArrayForHead[1] = header.getValue();
			}
			if (header.getName().equals("WWW-Authenticate")) {
				responseArrayForHead[1] = header.getValue();
			}
			if (header.getName().equals("Connection")) {
				responseArrayForHead[2] = header.getValue();
			}
		}

		generateLogs("HEAD");
		return responseArrayForHead;
	}

	// HTTP PUT request
	public String[] sendPUT(String putType, String additional,
			String payloadInclusion, String serverType) throws IOException {

		HttpPut httpput = new HttpPut(base_url);
		requestPayload = new MessagePayload();
		httpput.addHeader("User-Agent", USER_AGENT);
		httpput.addHeader("Response-Server", serverType);
		httpput.addHeader(setRequestTypeHeader("PUT"), putType);
		
		if(putType.equals("PutFor416")){
			httpput.addHeader("Range","bytes=199-399");
		}
		if(putType.equals("PutFor417")){
			httpput.addHeader("Expect","100-continue");
		}
		

		if (payloadInclusion.equals("WithPayload")) {
			StringEntity entity = new StringEntity(
					requestPayload.getMediumPayload(), "text/xml", "ISO-8859-1");
			httpput.addHeader("Accept", "text/xml");
			httpput.setEntity(entity);
		}

		response = httpclient.execute(httpput);

		try {
			getResponseDetails(response);
			generateLogs("PUT");

			return responseArray;
		} catch (NullPointerException nullPointerException) {
			return null;
		}
	}

	// HTTP DELETE request
	public String[] sendDELETE(String deleteType, String additional,
			String payloadInclusion, String serverType)
			throws ClientProtocolException, IOException {

		HttpDelete httpdelete = new HttpDelete(base_url);
		httpdelete.addHeader("User-Agent", USER_AGENT);
		httpdelete.addHeader("Response-Server", serverType);
		httpdelete.addHeader(setRequestTypeHeader("DELETE"), deleteType);
		
		if(deleteType.equals("DeleteFor416")){
			httpdelete.addHeader("Range","bytes=199-399");
		}
		if(deleteType.equals("DeleteFor417")){
			httpdelete.addHeader("Expect","100-continue");
		}

		response = httpclient.execute(httpdelete);

		try {
			getResponseDetails(response);
			generateLogs("DELETE");

			return responseArray;
		} catch (NullPointerException nullPointerException) {
			return null;
		}
	}
}
