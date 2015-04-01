package org.wso2.esb.httpcompliancetest.responses.informational;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http101ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

//	@Test
//	public void testGETRequest() throws Exception {
//
//		String status = "101";		
//		responseArray = httpRequests.sendGet("GetFor101","","","1xxResponse");
//		assertEquals(status,responseArray[0]);
//
//	}
//
//	@Test
//	public void testPOSTRequestWithPayload() throws Exception {
//
//		String status = "101";
//		responseArray = httpRequests.sendPost("PostFor101","","WithPayload","1xxResponse");
//		assertEquals(status,responseArray[0]);
//
//	}
//	
//	
//	@Test
//	public void testHEADRequest() throws Exception {
//
//		String status = "101";
//		responseArray = httpRequests.sendHEAD("HeadFor101","","1xxResponse");
//		assertEquals(status,responseArray[0]);
//
//	}
//	
//	@Test
//	public void testPUTrequest() throws Exception {
//
//		String status = "101";
//		responseArray = httpRequests.sendPUT("PutFor101","","WithPayload","1xxResponse");
//		assertEquals(status,responseArray[0]);
//
//	}
//	
//	@Test
//	public void testDELETErequest() throws Exception {
//
//		String status = "101";
//		responseArray = httpRequests.sendDELETE("DeleteFor101","","WithoutPayload","1xxResponse");
//		assertEquals(status,responseArray[0]);
//
//	}

}
