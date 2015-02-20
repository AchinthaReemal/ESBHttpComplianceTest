package org.wso2.esb.httpcompliancetest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.wso2.esb.backend.BackendService;

public class HttPComplianceTestSuiteSetup {
	
	BackendService backendService = new BackendService();

	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		backendService.startUpTestServer();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		backendService.shutdownTestServer();
	}
}
