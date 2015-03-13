package org.wso2.esb.httpcompliancetest.responses.servererror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http505ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;
	
	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Protocol Version Mismatch";		
		responseArray = httpRequests.sendGet("GetFor505","","WithoutPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));
	}
	
	@Test
	public void testHEADRequest() throws Exception {
		
		int status = 505;
		responseArray = httpRequests.sendHEAD("HeadFor505","","5xxResponse");
		assertEquals(status,Integer.parseInt(responseArray[0]));

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Protocol Version Mismatch";
		responseArray = httpRequests.sendPost("PostFor505","","WithPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Protocol Version Mismatch";
		responseArray = httpRequests.sendPUT("PutFor505","","WithPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Protocol Version Mismatch";
		responseArray = httpRequests.sendDELETE("DeleteFor505","","WithoutPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

}
