package org.wso2.esb.httpcompliancetest;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.backend.BackendService;
import org.wso2.esb.httprequests.HttpRequests;

public class Http205ComplianceTest {
	
	BackendService backendService = new BackendService();
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

//	 @Test
//	 public void testPOSTRequestWithoutPayload() throws Exception {
//		 if (httpRequests.sendPost("PostFor205", "", "WithoutPayload") == null) {
//				assertTrue(true);
//		 } else {
//			 	assertTrue(false);
//		 }
//	
//	 }
//	
	 @Test
	 public void testPOSTRequestWithPayload() throws Exception {
	
		 if (httpRequests.sendPost("PostFor205", "", "WithPayload") == null) {
			 	assertTrue(true);
		 } else {
			 	assertTrue(false);
		 }
	
	 }

//	 @Test
//	 public void testPUTrequestWithPayload() throws Exception {
//	
//		 if (httpRequests.sendPUT("PutFor205", "", "WithoutPayload") == null) {
//			 assertTrue(true);
//		 } else {
//			 assertTrue(false);
//		 }
//	
//	 }

	 @Test
	 public void testPUTrequestWithoutPayload() throws Exception {
	
		 if (httpRequests.sendPUT("PutFor205", "", "WithPayload") == null) {
			 assertTrue(true);
		 } else {
			 assertTrue(false);
		 }
	
	 }

	@Test
	public void testDELETErequest() throws Exception {

		if (httpRequests.sendDELETE("DeleteFor205", "","WithoutPayload") == null) {
			 assertTrue(true);
	    } else {
			 assertTrue(false);
	    }
	}

}
