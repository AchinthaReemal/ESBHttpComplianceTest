package org.wso2.esb.httpcompliancetest.responsecaching;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class ResponseCachingFor206Test {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "WSO2";		
		responseArray = httpRequests.sendGet("GetFor206","cached","","2xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));
	}
	
	@Test
	public void testGETRequestCached() throws Exception {

		String desiredPayloadPart = "WSO2";		
		responseArray = httpRequests.sendGet("GetFor206","cached","","2xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));
	}

}
