package org.wso2.esb.httpcompliancetest.responses.successful;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.wso2.esb.backend.BackendServicefor2xxResponses;

public class HttPComplianceTestSuiteSetup {
	
	BackendServicefor2xxResponses backendService = new BackendServicefor2xxResponses();

	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		backendService.startUpTestServer();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		backendService.shutdownTestServer();
	}
}
