package org.wso2.esb.httpcompliancetest.responsecaching;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class ResponseCachingFor300Test {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "http://localhost:3000/3xx/option_1";		
		responseArray = httpRequests.sendGet("GetFor300","cached","WithoutPayload","3xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testGETRequestCached() throws Exception {

		String desiredPayloadPart = "http://localhost:3000/3xx/option_1";		
		responseArray = httpRequests.sendGet("GetFor300","cached","WithoutPayload","3xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}
	
	@Test
	public void testHEADRequest() throws Exception {

		String desiredPayload = "http://127.0.0.1:8280/3xx/options";
		responseArray = httpRequests.sendHEAD("HeadFor300","cached","3xxResponse");
		assertEquals(responseArray[1], desiredPayload);

	}
	
	@Test
	public void testHEADRequestCached() throws Exception {

		String desiredPayload = "http://127.0.0.1:8280/3xx/options";
		responseArray = httpRequests.sendHEAD("HeadFor300","cached","3xxResponse");
		assertEquals(responseArray[1], desiredPayload);

	}
	
}
