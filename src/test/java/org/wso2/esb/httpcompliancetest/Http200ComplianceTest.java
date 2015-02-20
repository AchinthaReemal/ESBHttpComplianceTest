package org.wso2.esb.httpcompliancetest;

import static org.testng.AssertJUnit.assertTrue;

import javax.validation.constraints.AssertTrue;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.wso2.esb.backend.BackendService;
import org.wso2.esb.httprequests.HttpRequests;

import static org.testng.Assert.assertEquals;

public class Http200ComplianceTest {

	BackendService backendService = new BackendService();
	HttpRequests httpRequests;

	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {		
		backendService.startUpTestServer();
		httpRequests = new HttpRequests();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		backendService.shutdownTestServer();
	}

	@Test
	public void testGETRequest() throws Exception {

		int status = 200;		
		assertEquals(httpRequests.sendGet(), status);

	}

	@Test
	public void testPOSTRequestWithPayload() throws Exception {

		String desiredPayloadPart = "WSO2";
		assertTrue(httpRequests.sendPostWithPayload("").contains(desiredPayloadPart));

	}
	
	
	@Test
	public void testHEADRequest() throws Exception {

		int status = 200;
		assertEquals(httpRequests.sendHEAD(), status);

	}
	
	@Test
	public void testPUTrequest() throws Exception {

		String desiredPayloadPart = "WSO2";
		assertTrue(httpRequests.sendPUTWithPayload().contains(desiredPayloadPart));

	}
	
	@Test
	public void testDELETErequest() throws Exception {

		int status = 200;
		assertEquals(httpRequests.sendDELETEWithoutPayload(),status);

	}
	
	

}
