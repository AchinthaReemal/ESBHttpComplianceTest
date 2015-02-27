package org.wso2.esb.httpcompliancetest.responses.clienterror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http401ComplianceTest {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "User Authentication Required";		
		responseArray = httpRequests.sendGet("GetFor401","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {
		
		String desiredHeader = "Basic realm=\"ESBTesting:\"";
		responseArray = httpRequests.sendHEAD("HeadFor401","4xxResponse");
		assertEquals(desiredHeader,responseArray[1]);

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "User Authentication Required";
		responseArray = httpRequests.sendPost("PostFor401","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "User Authentication Required";
		responseArray = httpRequests.sendPUT("PutFor401","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "User Authentication Required";
		responseArray = httpRequests.sendDELETE("DeleteFor401","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
}
