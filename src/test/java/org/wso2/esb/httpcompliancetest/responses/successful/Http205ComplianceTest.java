package org.wso2.esb.httpcompliancetest.responses.successful;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http205ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	 @Test
	 public void testPOSTRequestWithoutPayload() throws Exception {
//		 if (httpRequests.sendPost("PostFor205", "", "WithoutPayload","2xxResponse") == null) {
//				assertTrue(true);
//		 } else {
//			 	assertTrue(false);
//		 }
	throw new SkipException("Skip Test : POST Request for 205 Response WITHOUT Payload");	
	
	 }
	
	 @Test
	 public void testPOSTRequestWithPayload() throws Exception {
	
		 if (httpRequests.sendPost("PostFor205", "", "WithPayload","2xxResponse") == null) {
			 	assertTrue(true);
		 } else {
			 	assertTrue(false);
		 }
	
	 }

	 @Test
	 public void testPUTrequestWithPayload() throws Exception {
	
//		 if (httpRequests.sendPUT("PutFor205", "", "WithoutPayload","2xxResponse") == null) {
//			 assertTrue(true);
//		 } else {
//			 assertTrue(false);
//		 }
	
		throw new SkipException("Skip Test : PUT Request for 205 Response WITHOUT Payload");
	 }

	 @Test
	 public void testPUTrequestWithoutPayload() throws Exception {
	
		 if (httpRequests.sendPUT("PutFor205", "", "WithPayload","2xxResponse") == null) {
			 assertTrue(true);
		 } else {
			 assertTrue(false);
		 }
	
	 }

	@Test
	public void testDELETErequest() throws Exception {

		if (httpRequests.sendDELETE("DeleteFor205", "","WithoutPayload","2xxResponse") == null) {
			 assertTrue(true);
	    } else {
			 assertTrue(false);
	    }
	}

}
