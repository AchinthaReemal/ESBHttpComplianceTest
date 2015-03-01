package org.wso2.esb.httpcompliancetest.responses.redirection;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http304ComplianceTest {

	HttpRequests httpRequests = new HttpRequests();
	String[] responseArray;

	@Test
	public void testGETRequest() throws Exception {
		
		responseArray = httpRequests.sendGet("GetFor304","","WithoutPayload","3xxResponse");
		assertTrue(responseArray == null);

	}
	
	
}
