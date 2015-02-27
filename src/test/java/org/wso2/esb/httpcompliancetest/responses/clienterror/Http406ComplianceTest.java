package org.wso2.esb.httpcompliancetest.responses.clienterror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http406ComplianceTest {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Content Characteristics Not Acceptable";		
		responseArray = httpRequests.sendGet("GetFor406","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {
		
		int status = 406;
		responseArray = httpRequests.sendHEAD("HeadFor406","4xxResponse");
		assertEquals(status,Integer.parseInt(responseArray[0]));

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "Content Characteristics Not Acceptable";
		responseArray = httpRequests.sendPost("PostFor406","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}	

	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "Content Characteristics Not Acceptable";
		responseArray = httpRequests.sendPUT("PutFor406","","WithPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		String desiredPayloadPart = "Content Characteristics Not Acceptable";
		responseArray = httpRequests.sendDELETE("DeleteFor406","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
}
