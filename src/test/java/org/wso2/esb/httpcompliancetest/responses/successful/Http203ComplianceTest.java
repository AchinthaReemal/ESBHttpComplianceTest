package org.wso2.esb.httpcompliancetest.responses.successful;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.wso2.esb.backend.BackendServicefor2xxResponses;
import org.wso2.esb.httprequests.HttpRequests;

public class Http203ComplianceTest {
	
	BackendServicefor2xxResponses backendService = new BackendServicefor2xxResponses();
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;
	
//	@Test
//	public void testGETRequest() throws Exception {
//
//		int status = 203;		
//		responseArray = httpRequests.sendGet("GetFor203","","","2xxResponse");
//		assertEquals(Integer.parseInt(responseArray[0]), status);
//	}
//
////	@Test
////	public void testPOSTRequestWithoutPayload() throws Exception {
////
////		String desiredPayloadPart = "WSO2";
////		responseArray = httpRequests.sendPost("PostFor203","","WithoutPayload","2xxResponse");
////		assertTrue(responseArray[1].contains(desiredPayloadPart));
////
////	}
//	
//	
//	@Test
//	public void testHEADRequest() throws Exception {
//
//		int status = 203;
//		responseArray = httpRequests.sendHEAD("HeadFor203","2xxResponse");
//		assertEquals(Integer.parseInt(responseArray[0]), status);
//	}
//	
//	
////	@Test
////	public void testPUTrequest() throws Exception {
////
////		int status = 203;
////		responseArray = httpRequests.sendPUT("PutFor203","","WithoutPayload","2xxResponse");
////		assertEquals(Integer.parseInt(responseArray[0]),status);
////
////	}
//	
//	@Test
//	public void testDELETErequest() throws Exception {
//
//		int status = 203;
//		responseArray = httpRequests.sendDELETE("DeleteFor203","","WithoutPayload","2xxResponse");
//		assertEquals(Integer.parseInt(responseArray[0]),status);
//
//	}

}
