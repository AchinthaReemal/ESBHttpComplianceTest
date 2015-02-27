package org.wso2.esb.httpcompliancetest.responses.redirection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http301ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

//	@Test
//	public void testGETRequest() throws Exception {
//
//		String desiredPayloadPart = "Redirection Successful";		
//		responseArray = httpRequests.sendGet("GetFor301","","WithoutPayload","3xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
//	
//	@Test
//	public void testHEADRequest() throws Exception {
//
//		String desiredPayload = "http://localhost:3000/3xx/redirection";
//		responseArray = httpRequests.sendHEAD("HeadFor301","3xxResponse");
//		assertEquals(desiredPayload, responseArray[1]);
//
//	}

//	@Test
//	public void testPOSTRequestWithPayload() throws Exception {
//
//		String desiredPayloadPart = "Resource Moved";
//		responseArray = httpRequests.sendPost("PostFor301","","WithPayload","3xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}	
//
//	@Test
//	public void testPUTrequest() throws Exception {
//
//		String desiredPayloadPart = "Resource Moved";
//		responseArray = httpRequests.sendPUT("PutFor301","","WithPayload","3xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
//	
//	@Test
//	public void testDELETErequest() throws Exception {
//
//		String desiredPayloadPart = "Resource Moved";
//		responseArray = httpRequests.sendDELETE("DeleteFor301","","WithoutPayload","3xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
	
}
