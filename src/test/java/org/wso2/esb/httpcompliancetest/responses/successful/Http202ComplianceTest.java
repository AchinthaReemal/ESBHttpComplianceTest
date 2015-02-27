package org.wso2.esb.httpcompliancetest.responses.successful;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.wso2.esb.httprequests.HttpRequests;

public class Http202ComplianceTest {
	
	HttpRequests httpRequests= new HttpRequests();
	String[] responseArray;
	
//	@Test
//	public void testPOSTRequestWithPayloadWithoutBody() throws Exception {
//
//		responseArray = httpRequests.sendPost("PostFor202","WithOutResponseBody","WithPayload","2xxResponse");
//		assertTrue("".equals(responseArray[1]));
//
//	}
//	
//	@Test
//	public void testPOSTRequestWithPayloadWithBody() throws Exception {
//
//		String desiredPayloadPart = "WSO2";
//		responseArray = httpRequests.sendPost("PostFor202","WithBody","WithPayload","2xxResponse");
//		assertTrue(responseArray[1].contains(desiredPayloadPart));
//
//	}

}
