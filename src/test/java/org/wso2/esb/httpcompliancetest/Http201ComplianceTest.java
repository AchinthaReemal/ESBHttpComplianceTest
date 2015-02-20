package org.wso2.esb.httpcompliancetest;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.wso2.esb.backend.BackendService;
import org.wso2.esb.httprequests.HttpRequests;

public class Http201ComplianceTest {
	
	
	HttpRequests httpRequests= new HttpRequests();
	
	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "PostFor201";
		assertTrue(httpRequests.sendPostWithPayload("PostFor201").contains(desiredPayloadPart));

	}

}
