package org.wso2.esb.httpcompliancetest;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.wso2.esb.backend.BackendService;
import org.wso2.esb.httprequests.HttpRequests;

import static org.testng.Assert.assertEquals;

public class Http200ComplianceTest {

	BackendService backendService = new BackendService();
	HttpRequests httpRequests;
	String[] responseArray;

	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {		
		backendService.startUpTestServer();
		httpRequests = new HttpRequests();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		backendService.shutdownTestServer();
	}

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "WSO2";		
		responseArray = httpRequests.sendGet("GetFor200","","");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "WSO2";
		responseArray = httpRequests.sendPost("","","WithPayload");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	
	@Test
	public void testHEADRequest() throws Exception {

		int status = 200;
		assertEquals(httpRequests.sendHEAD("HeadFor200"), status);

	}
	
	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "WSO2";
		responseArray = httpRequests.sendPUT("","","WithPayload");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		int status = 200;
		responseArray = httpRequests.sendDELETE("","","WithoutPayload");
		assertEquals(Integer.parseInt(responseArray[0]),status);

	}
	
	

}
