package org.wso2.esb.httpcompliancetest;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http201ComplianceTest {
	
	
	HttpRequests httpRequests= new HttpRequests();
	String[] responseArray;
	
	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "PostFor201";
		responseArray = httpRequests.sendPost("PostFor201","","WithPayload");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

}
