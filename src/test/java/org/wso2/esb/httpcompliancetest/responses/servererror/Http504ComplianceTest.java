package org.wso2.esb.httpcompliancetest.responses.servererror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http504ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;
	
	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Gateway/Proxy Time out";		
		responseArray = httpRequests.sendGet("GetFor504","","WithoutPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {
		
		int status = 504;
		responseArray = httpRequests.sendHEAD("HeadFor504","","5xxResponse");
		assertEquals(status,Integer.parseInt(responseArray[0]));

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Gateway/Proxy Time out";
		responseArray = httpRequests.sendPost("PostFor504","","WithPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Gateway/Proxy Time out";
		responseArray = httpRequests.sendPUT("PutFor504","","WithPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Gateway/Proxy Time out";
		responseArray = httpRequests.sendDELETE("DeleteFor504","","WithoutPayload","5xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

}
