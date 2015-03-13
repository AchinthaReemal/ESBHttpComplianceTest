package org.wso2.esb.httpcompliancetest.responses.clienterror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http417ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;
	
	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Expected Response Error";		
		responseArray = httpRequests.sendGet("GetFor417","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {
		
		int status = 417;
		responseArray = httpRequests.sendHEAD("HeadFor417","","4xxResponse");
		assertEquals(status,Integer.parseInt(responseArray[0]));

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Expected Response Error";
		responseArray = httpRequests.sendPost("PostFor417","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Expected Response Error";
		responseArray = httpRequests.sendPUT("PutFor417","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Expected Response Error";
		responseArray = httpRequests.sendDELETE("DeleteFor417","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

}
