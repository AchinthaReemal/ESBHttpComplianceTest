package org.wso2.esb.httpcompliancetest.suitesetup;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.wso2.esb.backend.BackendServerManager;

public class HttPComplianceTestSuiteSetup {
	
	BackendServerManager backendServerManager = new BackendServerManager();

	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		backendServerManager.startUpTestServer();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		backendServerManager.shutdownTestServer();
	}
}
