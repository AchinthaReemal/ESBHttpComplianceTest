package org.wso2.esb.httpcompliancetest.responsecaching;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class ResponseCachingFor203Test {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;
	
	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "WSO2";		
		responseArray = httpRequests.sendGet("GetFor203","cached","","2xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));
	}
	
	@Test
	public void testGETRequestCached() throws Exception {

		String desiredPayloadPart = "WSO2";		
		responseArray = httpRequests.sendGet("GetFor203","cached","","2xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));
	}
	
	@Test
	public void testHEADRequest() throws Exception {

		int status = 203;
		responseArray = httpRequests.sendHEAD("HeadFor203","cached","2xxResponse");
		assertEquals(Integer.parseInt(responseArray[0]), status);
	}
	
	@Test
	public void testHEADRequestCached() throws Exception {

		int status = 200;
		responseArray = httpRequests.sendHEAD("HeadFor203","cached","2xxResponse");
		assertEquals(Integer.parseInt(responseArray[0]), status);
	}
	
}
