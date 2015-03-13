package org.wso2.esb.httpcompliancetest.responses.servererror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http500ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;
	
	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Unexpected Server Error";		
		responseArray = httpRequests.sendGet("GetFor500","","WithoutPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {
		
		int status = 500;
		responseArray = httpRequests.sendHEAD("HeadFor500","","5xxResponse");
		assertEquals(status,Integer.parseInt(responseArray[0]));
		
	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Unexpected Server Error";
		responseArray = httpRequests.sendPost("PostFor500","","WithPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Unexpected Server Error";
		responseArray = httpRequests.sendPUT("PutFor500","","WithPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Unexpected Server Error";
		responseArray = httpRequests.sendDELETE("DeleteFor500","","WithoutPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

}
