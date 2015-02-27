package org.wso2.esb.httpcompliancetest.responses.clienterror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http411ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Content-Length Error";
		responseArray = httpRequests.sendPost("PostFor411","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Content-Length Error";
		responseArray = httpRequests.sendPUT("PutFor411","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Content-Length Error";
		responseArray = httpRequests.sendDELETE("DeleteFor411","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

}
