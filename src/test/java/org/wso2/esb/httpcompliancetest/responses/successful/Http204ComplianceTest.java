package org.wso2.esb.httpcompliancetest.responses.successful;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http204ComplianceTest {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

 @Test
 public void testPOSTRequestWithoutPayload() throws Exception {
// 		if (httpRequests.sendPost("PostFor204", "", "WithoutPayload","2xxResponse") == null) {
// 			assertTrue(true);
// 		} else {
// 			assertTrue(false);
// 		}
		throw new SkipException("Skip Test : POST Request for 204 Response WITHOUT Payload");
 }

	 @Test
	 public void testPOSTRequestWithPayload() throws Exception {
	
		 if (httpRequests.sendPost("PostFor204", "", "WithPayload","2xxResponse") == null) {
			 assertTrue(true);
		 } else {
			 assertTrue(false);
		 }
	
	 }

 	@Test
 	public void testPUTrequestWithPayload() throws Exception {

// 		if (httpRequests.sendPUT("PutFor204", "", "WithoutPayload","2xxResponse") == null) {
// 			assertTrue(true);
// 		} else {
// 			assertTrue(false);
// 		}
		throw new SkipException("Skip Test : PUT Request for 204 Response WITHOUT Payload");
 }

	 @Test
	 public void testPUTrequestWithoutPayload() throws Exception {
	
		 if (httpRequests.sendPUT("PutFor204", "", "WithPayload","2xxResponse") == null) {
			 assertTrue(true);
		 } else {
			 assertTrue(false);
		 }
	
	 }

	@Test
	public void testDELETErequest() throws Exception {

		if (httpRequests.sendDELETE("DeleteFor204", "","WithoutPayload","2xxResponse") == null) {
			 assertTrue(true);
	    } else {
			 assertTrue(false);
	    }
	}
	
}
