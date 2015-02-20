package org.wso2.esb.payload;

public class RequestPayload {

	private final String PAYLOAD = "<WSO2_Product_Test><Product>WSO2 ESB</Product>"
									+ "<Version>4.8.1</Version></WSO2_Product_Test>";

	public String getPayload() {
		return PAYLOAD;
	}

}
