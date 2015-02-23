package org.wso2.esb.httpcompliancetest;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.backend.BackendService;
import org.wso2.esb.httprequests.HttpRequests;

public class Http206ComplianceTest {
	
	BackendService backendService = new BackendService();
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "WSO2";		
		responseArray = httpRequests.sendGet("GetFor206","","");
		assertTrue(responseArray[1].contains(desiredPayloadPart));
	}

}
