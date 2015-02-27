package org.wso2.esb.httpcompliancetest.responses.clienterror;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http414ComplianceTest {
	
	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {

		String desiredPayloadPart = "Possible Request Method Conflict Detected";		
		responseArray = httpRequests.sendGet("GetFor414","","WithoutPayload","4xxResponse");
		assertTrue(responseArray[1].contains(desiredPayloadPart));

	}

}
