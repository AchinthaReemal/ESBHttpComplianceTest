package org.wso2.esb.httpcompliancetest.responses.clienterror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http413ComplianceTest {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Request Entity Could Not Be Processed";		
		responseArray = httpRequests.sendGet("GetFor413","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {
		
		String connection = "Close";
		responseArray = httpRequests.sendHEAD("HeadFor413","","4xxResponse");
		assertEquals(connection,responseArray[2]);

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Request Entity Could Not Be Processed";
		responseArray = httpRequests.sendPost("PostFor413","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Request Entity Could Not Be Processed";
		responseArray = httpRequests.sendPUT("PutFor413","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Request Entity Could Not Be Processed";
		responseArray = httpRequests.sendDELETE("DeleteFor413","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

	
}
