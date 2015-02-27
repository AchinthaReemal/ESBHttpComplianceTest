package org.wso2.esb.httpcompliancetest.responses.clienterror;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http400ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

//	@Test
//	public void testGETRequest() throws Exception {
//
//		String desiredPayloadPart = "Request Cannot Be Resolved. Malformed Syntax Error";		
//		responseArray = httpRequests.sendGet("GetFor400","","WithoutPayload","4xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
//	
//	@Test
//	public void testHEADRequest() throws Exception {
//		
//		int status = 400;
//		responseArray = httpRequests.sendHEAD("HeadFor400","4xxResponse");
//		assertEquals(Integer.parseInt(responseArray[0]), status);
//
//	}
//
//	@Test
//	public void testPOSTRequestWithPayload() throws Exception {
//
//		String desiredPayloadPart = "Request Cannot Be Resolved. Malformed Syntax Error";
//		responseArray = httpRequests.sendPost("PostFor400","","WithoutPayload","4xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}	
//
//	@Test
//	public void testPUTrequest() throws Exception {
//
//		String desiredPayloadPart = "Request Cannot Be Resolved. Malformed Syntax Error";
//		responseArray = httpRequests.sendPUT("PutFor400","","WithPayload","4xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
//	
//	@Test
//	public void testDELETErequest() throws Exception {
//
//		String desiredPayloadPart = "Request Cannot Be Resolved. Malformed Syntax Error";
//		responseArray = httpRequests.sendDELETE("DeleteFor400","","WithoutPayload","4xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}

}
