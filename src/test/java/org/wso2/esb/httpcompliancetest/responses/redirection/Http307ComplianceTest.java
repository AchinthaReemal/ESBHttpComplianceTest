package org.wso2.esb.httpcompliancetest.responses.redirection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http307ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Redirection Successful";		
		responseArray = httpRequests.sendGet("GetFor307","","WithoutPayload","3xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {

		String desiredPayload = "http://127.0.0.1:8280/3xxx/redirection";
		responseArray = httpRequests.sendHEAD("HeadFor307","3xxResponse");
		assertEquals(desiredPayload, responseArray[1]);

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Resource Moved Temporally";
		responseArray = httpRequests.sendPost("PostFor307","","WithPayload","3xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Resource Moved Temporally";
		responseArray = httpRequests.sendPUT("PutFor307","","WithPayload","3xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Resource Moved Temporally";
		responseArray = httpRequests.sendDELETE("DeleteFor307","","WithoutPayload","3xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
}
