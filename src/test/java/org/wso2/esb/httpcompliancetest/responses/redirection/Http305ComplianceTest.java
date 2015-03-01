package org.wso2.esb.httpcompliancetest.responses.redirection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http305ComplianceTest {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Resource To Be Accessed Through A Proxy";		
		responseArray = httpRequests.sendGet("GetFor305","","WithoutPayload","3xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {

		String desiredPayload = "http://127.0.0.1:8280/services/HttpRedirect";
		responseArray = httpRequests.sendHEAD("HeadFor305","3xxResponse");
		assertEquals(desiredPayload, responseArray[1]);

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		responseArray = httpRequests.sendPost("PostFor305","","WithPayload","3xxResponse");
		assertTrue(responseArray[1] == "");

	}	

	@Test
	public void testPUTrequest() throws Exception {

		responseArray = httpRequests.sendPUT("PutFor305","","WithPayload","3xxResponse");
		assertTrue(responseArray[1] == "");

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Resource To Be Accessed Through A Proxy";
		responseArray = httpRequests.sendDELETE("DeleteFor305","","WithoutPayload","3xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
}
