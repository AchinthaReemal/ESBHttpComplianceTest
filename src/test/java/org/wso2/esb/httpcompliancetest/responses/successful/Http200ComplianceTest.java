package org.wso2.esb.httpcompliancetest.responses.successful;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.wso2.esb.backend.BackendServicefor2xxResponses;
import org.wso2.esb.httprequests.HttpRequests;

import static org.testng.Assert.assertEquals;

public class Http200ComplianceTest {

	BackendServicefor2xxResponses backendService = new BackendServicefor2xxResponses();
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

//	@Test
//	public void testGETRequest() throws Exception {
//
//		String desiredPayloadPart = "WSO2";		
//		responseArray = httpRequests.sendGet("GetFor200","","","2xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
//
//	@Test
//	public void testPOSTRequestWithPayload() throws Exception {
//
//		String desiredPayloadPart = "WSO2";
//		responseArray = httpRequests.sendPost("","","WithPayload","2xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
//	
//	
//	@Test
//	public void testHEADRequest() throws Exception {
//
//		int status = 200;
//		responseArray = httpRequests.sendHEAD("HeadFor200","2xxResponse");
//		assertEquals(Integer.parseInt(responseArray[0]), status);
//
//	}
//	
//	@Test
//	public void testPUTrequest() throws Exception {
//
//		String desiredPayloadPart = "WSO2";
//		responseArray = httpRequests.sendPUT("","","WithPayload","2xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
//	
//	@Test
//	public void testDELETErequest() throws Exception {
//
//		int status = 200;
//		responseArray = httpRequests.sendDELETE("","","WithoutPayload","2xxResponse");
//		assertEquals(Integer.parseInt(responseArray[0]),status);
//
//	}
	
	

}
