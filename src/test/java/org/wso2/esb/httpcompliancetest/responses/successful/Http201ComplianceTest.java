package org.wso2.esb.httpcompliancetest.responses.successful;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http201ComplianceTest {	
	
	HttpRequests httpRequests= new HttpRequests();
	String[] responseArray;
	
	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "PostFor201";
		responseArray = httpRequests.sendPost("PostFor201","","WithPayload","2xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

}
