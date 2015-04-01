package org.wso2.esb.httpcompliancetest.responses.successful;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http200ComplianceTest {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "WSO2";		
		responseArray = httpRequests.sendGet("GetFor200","","","2xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

//	@Test
//	public void testPOSTRequestWithPayload() throws Exception {
//
//		String desiredPayloadPart = "WSO2";
//		responseArray = httpRequests.sendPost("PostFor200","","WithPayload","2xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
//	
//	
//	@Test
//	public void testHEADRequest() throws Exception {
//
//		int status = 200;
//		responseArray = httpRequests.sendHEAD("HeadFor200","","2xxResponse");
//		assertEquals(Integer.parseInt(responseArray[0]), status);
//
//	}
//	
//	@Test
//	public void testPUTrequest() throws Exception {
//
//		String desiredPayloadPart = "WSO2";
//		responseArray = httpRequests.sendPUT("PutFor200","","WithPayload","2xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
//	
//	@Test
//	public void testDELETErequest() throws Exception {
//
//		int status = 200;
//		responseArray = httpRequests.sendDELETE("DeleteFor200","","WithoutPayload","2xxResponse");
//		assertEquals(Integer.parseInt(responseArray[0]),status);
//
//	}
	
//	@Test
//	public void testDELETErequestWithPayload() throws Exception {
//
//		int status = 200;
//		responseArray = httpRequests.sendDELETE("DeleteFor200","","WithPayload","2xxResponse");
//		assertEquals(Integer.parseInt(responseArray[0]),status);
//
//	}
	
	

}
