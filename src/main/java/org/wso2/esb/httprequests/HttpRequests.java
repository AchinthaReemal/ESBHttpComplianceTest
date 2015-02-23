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

	public HttpRequests() {
		logger = Logger.getAnonymousLogger();
		base_url = "http://localhost:8280/services/ESBHttpComplianceTest";
		httpclient = new DefaultHttpClient();
		responseArray = new String[2];
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
		}
		responseArray[0] = Integer.toString(response.getStatusLine()
				.getStatusCode());
		responseArray[1] = resultsBuffer.toString();
	}

	// Generate Logs to indicate requested method and its responses
	public void generateLogs(String method) {
		logger.info("Sending " + method + " request to URL : " + base_url);
		logger.info("Response Code : "
				+ response.getStatusLine().getStatusCode());
		logger.info("Entity content  :" + resultsBuffer.toString());

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
			String payloadInclusion) throws Exception {

		HttpGet httpget = new HttpGet(base_url);
		httpget.addHeader("User-Agent", USER_AGENT);

		if (getType.equals("GetFor206")) {
			httpget.addHeader("Get-Type", "GetFor206");
		} else if (getType.equals("GetFor203")) {
			httpget.addHeader("Get-Type", "GetFor203");
		} else if (getType.equals("GetFor200")) {
			httpget.addHeader("Get-Type", "GetFor200");
		}

		response = httpclient.execute(httpget);

		getResponseDetails(response);
		generateLogs("GET");

		return responseArray;
	}

	// HTTP POST request
	public String[] sendPost(String postType, String additional,
			String payloadInclusion) throws Exception {

		HttpPost httppost = new HttpPost(base_url);
		requestPayload = new MessagePayload();
		httppost.addHeader("User-Agent", USER_AGENT);

		if (postType.equals("PostFor205")) {
			httppost.addHeader("Post-Type", "PostFor205");
		} else if (postType.equals("PostFor204")) {
			httppost.addHeader("Post-Type", "PostFor204");
		} else if (postType.equals("PostFor203")) {
			httppost.addHeader("Post-Type", "PostFor203");
		} else if (postType.equals("PostFor201")) {
			httppost.addHeader("Post-Type", "PostFor201");
		} else if (postType.equals("PostFor202")) {
			httppost.addHeader("Post-Type", "PostFor202");

			if (additional.equals("WithOutResponseBody")) {
				httppost.addHeader("Response-Type", "WithOutBody");
			} else {
				httppost.addHeader("Response-Type", "WithBody");
			}
		} else {
			httppost.addHeader("Post-Type", "PostFor200");
		}
		if (payloadInclusion.equals("WithPayload")) {
			StringEntity entity = new StringEntity(requestPayload.getPayload(),
					"text/xml", "ISO-8859-1");
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
	public int sendHEAD(String headType) throws Exception {

		HttpHead httphead = new HttpHead(base_url);
		httphead.addHeader("User-Agent", USER_AGENT);

		if (headType.equals("HeadFor203")) {
			httphead.addHeader("Head-Type", "HeadFor203");
		} else {
			httphead.addHeader("Head-Type", "HeadFor200");
		}
		response = httpclient.execute(httphead);
		responseHeaders = response.getAllHeaders();

		generateLogs("HEAD");

		return response.getStatusLine().getStatusCode();
	}

	// HTTP PUT request
	public String[] sendPUT(String putType, String additional,
			String payloadInclusion) throws IOException {

		HttpPut httpput = new HttpPut(base_url);
		requestPayload = new MessagePayload();
		httpput.addHeader("User-Agent", USER_AGENT);

		if (putType.equals("PutFor205")) {
			httpput.addHeader("Put-Type", "PutFor205");
		} else if (putType.equals("PutFor204")) {
			httpput.addHeader("Put-Type", "PutFor204");
		} else if (putType.equals("PutFor203")) {
			httpput.addHeader("Put-Type", "PutFor203");
		} else {
			httpput.addHeader("Put-Type", "PutFor200");
		}
		if (payloadInclusion.equals("WithPayload")) {
			StringEntity entity = new StringEntity(requestPayload.getPayload(),
					"text/xml", "ISO-8859-1");
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
			String payloadInclusion) throws ClientProtocolException,
			IOException {

		HttpDelete httpdelete = new HttpDelete(base_url);
		httpdelete.addHeader("User-Agent", USER_AGENT);

		if (deleteType.equals("DeleteFor205")) {
			httpdelete.addHeader("Delete-Type", "DeleteFor205");
		} else if (deleteType.equals("DeleteFor204")) {
			httpdelete.addHeader("Delete-Type", "DeleteFor204");
		} else if (deleteType.equals("DeleteFor203")) {
			httpdelete.addHeader("Delete-Type", "DeleteFor203");
		} else {
			httpdelete.addHeader("Delete-Type", "DeleteFor200");
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
