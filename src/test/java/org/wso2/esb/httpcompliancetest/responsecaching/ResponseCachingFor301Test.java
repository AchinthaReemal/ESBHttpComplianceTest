package org.wso2.esb.httpcompliancetest.responsecaching;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class ResponseCachingFor301Test {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Redirection Successful";		
		responseArray = httpRequests.sendGet("GetFor301","cached","WithoutPayload","3xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testGETRequestCached() throws Exception {

		String desiredPayloadPart = "Redirection Successful";		
		responseArray = httpRequests.sendGet("GetFor301","cached","WithoutPayload","3xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
//	
//	@Test
//	public void testHEADRequest() throws Exception {
//
//		String desiredPayload = "http://127.0.0.1:8280/3xxx/redirection";
//		responseArray = httpRequests.sendHEAD("HeadFor301","cached","3xxResponse");
//		assertEquals(desiredPayload, responseArray[1]);
//
//	}
//	
//	@Test
//	public void testHEADRequestCached() throws Exception {
//
//		String desiredPayload = "http://127.0.0.1:8280/3xxx/redirection";
//		responseArray = httpRequests.sendHEAD("HeadFor301","cached","3xxResponse");
//		assertEquals(desiredPayload, responseArray[1]);
//
//	}


}
