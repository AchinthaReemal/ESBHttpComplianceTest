package org.wso2.esb.httpcompliancetest;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.backend.BackendService;
import org.wso2.esb.httprequests.HttpRequests;

import static org.testng.Assert.assertEquals;

public class Http203ComplianceTest {
	
	BackendService backendService = new BackendService();
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;
	
	@Test
	public void testGETRequest() throws Exception {

		int status = 203;		
		responseArray = httpRequests.sendGet("GetFor203","","");
		assertEquals(Integer.parseInt(responseArray[0]), status);
	}

//	@Test
//	public void testPOSTRequestWithoutPayload() throws Exception {
//
//		String desiredPayloadPart = "WSO2";
//		responseArray = httpRequests.sendPost("PostFor203","","WithoutPayload");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}
	
	
	@Test
	public void testHEADRequest() throws Exception {

		int status = 203;
		assertEquals(httpRequests.sendHEAD("HeadFor203"), status);

	}
	
	
//	@Test
//	public void testPUTrequest() throws Exception {
//
//		int status = 203;
//		responseArray = httpRequests.sendPUT("PutFor203","","WithoutPayload");
//		assertEquals(Integer.parseInt(responseArray[0]),status);
//
//	}
	
	@Test
	public void testDELETErequest() throws Exception {

		int status = 203;
		responseArray = httpRequests.sendDELETE("DeleteFor203","","WithoutPayload");
		assertEquals(Integer.parseInt(responseArray[0]),status);

	}

}
