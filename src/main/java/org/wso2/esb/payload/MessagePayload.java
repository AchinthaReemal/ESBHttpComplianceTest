package org.wso2.esb.payload;

public class MessagePayload {

	private final String MEDIUM_PAYLOAD = "<WSO2_Product_Test>"
										+ "<Product>WSO2 ESB</Product>"
										+ "<Version>4.8.1</Version>"
										+ "</WSO2_Product_Test>";
	
	private final String MULTI_OPTION = "<WSO2_Product_Test>"
										+ "<Product>WSO2 ESB</Product>"
										+ "<Redirect_options>"
										+ "<Option>http://localhost:3000/3xx/option_1</Option>"
										+ "<Option>http://localhost:3000/3xx/option_2</Option>"
										+ "<Option>http://localhost:3000/3xx/option_3</Option>"
										+ "</Redirect_options>"
										+ "<Version>4.8.1</Version>"
										+ "</WSO2_Product_Test>";
	
	private final String HTML_PAYLOAD_PERMANENT = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Resource Moved Permenently</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Location : <a href=\"http://localhost:3000/3xx/option\">click here</a></p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String HTML_PAYLOAD_TEMPORAL = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Resource Moved Temporally</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Location : <a href=\"http://localhost:3000/3xx/option\">click here</a></p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String HTML_PAYLOAD_OTHER = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>See Other Resource For Response</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Location : <a href=\"http://localhost:3000/3xx/option\">click here</a></p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String HTML_PAYLOAD_PROXY = "<!DOCTYPE html>"
											+ "<html>"
											+ "<body>"
											+ "<div>"
											+ "<h1>WSO2 ESB</h1>"
											+ "<h2>Resource To Be Accessed Through A Proxy</h2>"
											+ "<h3>Version 4.8.1</h3>"
											+ "<p>Location : <a href=\"http://localhost:3000/3xx/option\">click here</a></p>"
											+ "</div>"
											+ "</body>"
											+ "</html>";

	private final String CLIENT_ERROR = "<WSO2_Product_Test>"
										+ "<Product>WSO2 ESB</Product>"
										+ "<Error_Messages>"
										+ "<Message>Request Cannot Be Resolved. Malformed Syntax Error</Message>"
										+ "</Error_Messages>"
										+ "<Version>4.8.1</Version>"
										+ "</WSO2_Product_Test>";

	private final String CLIENT_RESOURCE_ERROR = "<WSO2_Product_Test>"
												+ "<Product>WSO2 ESB</Product>"
												+ "<Error_Messages>"
												+ "<Message>Request Cannot Be Resolved. Resource Not Found</Message>"
												+ "</Error_Messages>"
												+ "<Version>4.8.1</Version>"
												+ "</WSO2_Product_Test>";
	
	private final String CLIENT_METHOD_ERROR = "<WSO2_Product_Test>"
												+ "<Product>WSO2 ESB</Product>"
												+ "<Error_Messages>"
												+ "<Message>Request Method Not Allowed</Message>"
												+ "</Error_Messages>"
												+ "<Version>4.8.1</Version>"
												+ "</WSO2_Product_Test>";
	
	private final String USER_AUTHENTICATION = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>User Authentication Required</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Please Enter Relevent Username and Passwrod to Proceed</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String CLIENT_CONTENT_ERROR = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Content Characteristics Not Acceptable</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Content Available : <a href=\"http://localhost:3000/3xx/content\">Content Type_1</a></p>"
												+ "<p>Content Available : <a href=\"http://localhost:3000/3xx/content\">Content Type_2</a></p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String USER_PROXY_AUTHENTICATION = "<!DOCTYPE html>"
													+ "<html>"
													+ "<body>"
													+ "<div>"
													+ "<h1>WSO2 ESB</h1>"
													+ "<h2>User Authentication For Proxy Required</h2>"
													+ "<h3>Version 4.8.1</h3>"
													+ "<p>Please Enter Relevent Username and Passwrod to Proceed</p>"
													+ "</div>"
													+ "</body>"
													+ "</html>";
	
	private final String USER_REQUEST_TIMEOUT = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>User Request Time out</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Please Repeat the Request at a Later Time</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String RESOURCE_STATE_ERROR = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Resource State Conflict</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Please Fix the conflicts and re-attemp</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String NON_AVAILABLE_RESOURCE = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Requested Resource Not Found</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Location/Relocated Location Not Available</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String CONTENT_LENGTH_ERROR = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Content-Length Error</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Please Specify the Content Length and Re-try</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String PRECONDITION_ERROR = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Stated Prconditions Failed</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Please Check the Pre conditions and Re-try</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String CONTENT_SIZE_ERROR = "<!DOCTYPE html>"
											+ "<html>"
											+ "<body>"
											+ "<div>"
											+ "<h1>WSO2 ESB</h1>"
											+ "<h2>Request Entity Could Not Be Processed</h2>"
											+ "<h3>Version 4.8.1</h3>"
											+ "<p>Content is too large to be processed. Server Connection will be closed</p>"
											+ "</div>"
											+ "</body>"
											+ "</html>";
	
	private final String REQUEST_METHOD_CONFLICT = "<!DOCTYPE html>"
													+ "<html>"
													+ "<body>"
													+ "<div>"
													+ "<h1>WSO2 ESB</h1>"
													+ "<h2>Possible Request Method Conflict Detected</h2>"
													+ "<h3>Version 4.8.1</h3>"
													+ "<p>Quey Information Found in the Request URI</p>"
													+ "</div>"
													+ "</body>"
													+ "</html>";
	
	private final String FORMAT_NOT_SUPPORTED = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Requested Format Not Supported</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Request Refused Due to Entity Format Mismatch</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String REQUEST_RANGE_ERROR = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Invalid Request Range</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>No Request Range or Range Overlap</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String EXPECTED_RESPONSE_ERROR = "<!DOCTYPE html>"
													+ "<html>"
													+ "<body>"
													+ "<div>"
													+ "<h1>WSO2 ESB</h1>"
													+ "<h2>Expected Response Error</h2>"
													+ "<h3>Version 4.8.1</h3>"
													+ "<p>Expected Response Could Not Be Met By The Server</p>"
													+ "</div>"
													+ "</body>"
													+ "</html>";
	
	private final String UNEXPECTED_SERVER_ERROR = "<!DOCTYPE html>"
													+ "<html>"
													+ "<body>"
													+ "<div>"
													+ "<h1>WSO2 ESB</h1>"
													+ "<h2>Unexpected Server Error</h2>"
													+ "<h3>Version 4.8.1</h3>"
													+ "<p>Server Encountered an Unexpected Condition</p>"
													+ "</div>"
													+ "</body>"
													+ "</html>";
	
	private final String UPSTREAM_SERVER_ERROR = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Upstream Server Error</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Invalid Response Received From Upstream Server</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String TEMPORAL_SERVER_ERROR = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Temporal Server Error</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Server Currently Unavailable Due To Temporal Issue</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String GATEWAY_TIMEOUT_ERROR = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Gateway/Proxy Time out</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Upstream Server Failed To Respond Within The Period.Session Expired</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	private final String PROTOCOL_VERSION_MISMATCH = "<!DOCTYPE html>"
												+ "<html>"
												+ "<body>"
												+ "<div>"
												+ "<h1>WSO2 ESB</h1>"
												+ "<h2>Protocol Version Mismatch</h2>"
												+ "<h3>Version 4.8.1</h3>"
												+ "<p>Protocol Version Used in Request Is Not Supported by the Server</p>"
												+ "</div>"
												+ "</body>"
												+ "</html>";
	
	 
		
	public String getMediumPayload() {
		return MEDIUM_PAYLOAD;
	}
	
	public String getMultioptionPayload(){		
		return MULTI_OPTION;
	}
	
	public String getHTMLPermenentPayload(){		
		return HTML_PAYLOAD_PERMANENT;
	}
	
	public String getHTMLTemporalPayload(){		
		return HTML_PAYLOAD_TEMPORAL;
	}
	
	public String getHTMLOtherPayload(){		
		return HTML_PAYLOAD_OTHER;
	}
	
	public String getHTMLProxyrPayload(){		
		return HTML_PAYLOAD_PROXY;
	}
	
	public String getClientErrorPayload(){		
		return CLIENT_ERROR;
	}
	
	public String getAuthenticationPayload(){		
		return USER_AUTHENTICATION;
	}
	
	public String getClientResourceErrorPayload(){		
		return CLIENT_RESOURCE_ERROR;
	}
	
	public String getClientMethodErrorPayload(){		
		return CLIENT_METHOD_ERROR;
	}
	
	public String getClientContentErrorPayload(){		
		return CLIENT_CONTENT_ERROR;
	}
	
	public String getProxyAuthenticationPayload(){		
		return USER_PROXY_AUTHENTICATION;
	}
	
	public String getRequestTimeoutPayload(){		
		return USER_REQUEST_TIMEOUT;
	}
	
	public String getResourceStatePayload(){		
		return RESOURCE_STATE_ERROR;
	}
	
	public String getNonAvailabilityPayload(){		
		return NON_AVAILABLE_RESOURCE;
	}
	
	public String getContentLengthErrorPayload(){		
		return CONTENT_LENGTH_ERROR;
	}
	
	public String getPreconditionErrorPayload(){		
		return PRECONDITION_ERROR;
	}
	
	public String getEntityErrorPayload(){		
		return CONTENT_SIZE_ERROR;
	}
	
	public String getRequestConflictPayload(){		
		return REQUEST_METHOD_CONFLICT;
	}
	
	public String getFormatMismatchPayload(){		
		return FORMAT_NOT_SUPPORTED;
	}
	
	public String getRangeErrorPayload(){		
		return REQUEST_RANGE_ERROR;
	}
	
	public String getExpectedResponseErrorPayload(){		
		return EXPECTED_RESPONSE_ERROR;
	}
	
	public String getUnexpectedServerErrorPayload(){		
		return UNEXPECTED_SERVER_ERROR;
	}
	
	public String getUpstreamServerErrorPayload(){		
		return UPSTREAM_SERVER_ERROR;
	}
	
	public String getTemporalServerErrorPayload(){		
		return TEMPORAL_SERVER_ERROR;
	}
	
	public String getGatewayTimeoutPayload(){		
		return GATEWAY_TIMEOUT_ERROR;
	}
	
	public String getProtocolMismatchPayload(){		
		return PROTOCOL_VERSION_MISMATCH;
	}


}
