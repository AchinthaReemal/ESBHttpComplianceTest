package org.wso2.esb.httpcompliancetest.responses.informational;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http100ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

//	@Test
//	public void testGETRequest() throws Exception {
//
//		String status = "100";		
//		responseArray = httpRequests.sendGet("GetFor100","","","1xxResponse");
//		assertEquals(status,responseArray[0]);
//
//	}
//
//	@Test
//	public void testPOSTRequestWithPayload() throws Exception {
//
//		String status = "100";
//		responseArray = httpRequests.sendPost("PostFor100","","WithPayload","1xxResponse");
//		assertEquals(status,responseArray[0]);
//
//	}
//	
//	
//	@Test
//	public void testHEADRequest() throws Exception {
//
//		String status = "100";
//		responseArray = httpRequests.sendHEAD("HeadFor100","","1xxResponse");
//		assertEquals(status,responseArray[0]);
//
//	}
//	
//	@Test
//	public void testPUTrequest() throws Exception {
//
//		String status = "100";
//		responseArray = httpRequests.sendPUT("PutFor100","","WithPayload","1xxResponse");
//		assertEquals(status,responseArray[0]);
//
//	}
//	
//	@Test
//	public void testDELETErequest() throws Exception {
//
//		String status = "100";
//		responseArray = httpRequests.sendDELETE("DeleteFor100","","WithoutPayload","1xxResponse");
//		assertEquals(status,responseArray[0]);
//
//	}

}
