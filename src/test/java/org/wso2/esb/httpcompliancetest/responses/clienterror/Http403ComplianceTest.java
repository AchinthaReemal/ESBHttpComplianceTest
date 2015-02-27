package org.wso2.esb.httpcompliancetest.responses.clienterror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http403ComplianceTest {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Request Cannot Be Resolved. Malformed Syntax Error";		
		responseArray = httpRequests.sendGet("GetFor403","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {
		
		int status = 403;
		responseArray = httpRequests.sendHEAD("HeadFor403","4xxResponse");
		assertEquals(status,Integer.parseInt(responseArray[0]));

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Request Cannot Be Resolved. Malformed Syntax Error";
		responseArray = httpRequests.sendPost("PostFor403","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Request Cannot Be Resolved. Malformed Syntax Error";
		responseArray = httpRequests.sendPUT("PutFor403","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Request Cannot Be Resolved. Malformed Syntax Error";
		responseArray = httpRequests.sendDELETE("DeleteFor403","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
}
