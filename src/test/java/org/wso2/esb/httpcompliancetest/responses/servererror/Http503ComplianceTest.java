package org.wso2.esb.httpcompliancetest.responses.servererror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http503ComplianceTest {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;
	
	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Temporal Server Error";		
		responseArray = httpRequests.sendGet("GetFor503","","WithoutPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {
		
		int status = 503;
		responseArray = httpRequests.sendHEAD("HeadFor503","5xxResponse");
		assertEquals(status,Integer.parseInt(responseArray[0]));

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Temporal Server Error";
		responseArray = httpRequests.sendPost("PostFor503","","WithPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Temporal Server Error";
		responseArray = httpRequests.sendPUT("PutFor503","","WithPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Temporal Server Error";
		responseArray = httpRequests.sendDELETE("DeleteFor503","","WithoutPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
}
