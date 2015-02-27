package org.wso2.esb.httpcompliancetest.responses.clienterror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http410ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Requested Resource Not Found";		
		responseArray = httpRequests.sendGet("GetFor410","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {
		
		int status = 410;
		responseArray = httpRequests.sendHEAD("HeadFor410","4xxResponse");
		assertEquals(status,Integer.parseInt(responseArray[0]));

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Requested Resource Not Found";
		responseArray = httpRequests.sendPost("PostFor410","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Requested Resource Not Found";
		responseArray = httpRequests.sendPUT("PutFor410","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Requested Resource Not Found";
		responseArray = httpRequests.sendDELETE("DeleteFor410","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

}
