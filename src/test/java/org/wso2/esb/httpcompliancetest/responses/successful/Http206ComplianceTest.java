package org.wso2.esb.httpcompliancetest.responses.successful;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http206ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "WSO2";		
		responseArray = httpRequests.sendGet("GetFor206","","","2xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));
	}

}
