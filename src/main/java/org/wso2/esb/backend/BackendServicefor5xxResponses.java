/**
 *  Copyright (c) 2009, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.esb.backend;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.wso2.esb.payload.MessagePayload;

@Path("/5xx")
public class BackendServicefor5xxResponses {
	
	MessagePayload messagePayload = new MessagePayload();

	@GET
	@Path("/get")
	public Response get(@HeaderParam("Get-Type") String getType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (getType.toString().equals("GetFor500")) {
			return Response.status(500)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUnexpectedServerErrorPayload())
					.build();
		} else if (getType.toString().equals("GetFor501")) {
			return Response
					.status(501)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUnexpectedServerErrorPayload())
					.build();
		}else if (getType.toString().equals("GetFor502")) {
			return Response
					.status(502)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUpstreamServerErrorPayload())
					.build();
		} else if (getType.toString().equals("GetFor503")) {
			return Response
					.status(503)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getTemporalServerErrorPayload())
					.build();
		} else if (getType.toString().equals("GetFor504")) {
			return Response
					.status(504)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getGatewayTimeoutPayload())
					.build();
		}else if (getType.toString().equals("GetFor505")) {
			return Response
					.status(505)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getProtocolMismatchPayload())
					.build();
		}else {
			return null;
		}

	}

	@POST
	@Path("/post")
	public Response setPostRequest(@HeaderParam("Post-Type") String postType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (postType.toString().equals("PostFor505")) {
			return Response
					.status(505)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getProtocolMismatchPayload())
					.build();
		} else if (postType.toString().equals("PostFor504")) {
			return Response
					.status(504)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getGatewayTimeoutPayload())
					.build();
		}else if (postType.toString().equals("PostFor503")) {
			return Response
					.status(503)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getTemporalServerErrorPayload())
					.build();
		}else if (postType.toString().equals("PostFor502")) {
			return Response
					.status(502)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUpstreamServerErrorPayload())
					.build();
		} else if (postType.toString().equals("PostFor501")) {
			return Response
					.status(501)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUnexpectedServerErrorPayload())
					.build();
		} else {
			return Response
					.status(500)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUnexpectedServerErrorPayload())
					.build();
		}

	}

	@PUT
	@Path("/put")
	public Response setPutRequest(@HeaderParam("Put-Type") String putType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (putType.toString().equals("PutFor505")) {
			return Response
					.status(505)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getProtocolMismatchPayload())
					.build();
		}else if (putType.toString().equals("PutFor504")) {
			return Response
					.status(504)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getGatewayTimeoutPayload())
					.build();
		}else if (putType.toString().equals("PutFor503")) {
			return Response
					.status(503)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getTemporalServerErrorPayload())
					.build();
		} else if (putType.toString().equals("PutFor502")) {
			return Response
					.status(502)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUpstreamServerErrorPayload())
					.build();
		}else if (putType.toString().equals("PutFor501")) {
			return Response
					.status(501)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUnexpectedServerErrorPayload())
					.build();
		} else {
			return Response
					.status(500)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUnexpectedServerErrorPayload())
					.build();
		}

	}

	@HEAD
	@Path("/head")
	public Response setHeadRequest(@HeaderParam("Head-Type") String headType) {

		if (headType.toString().equals("HeadFor501")) {
			return Response
					.status(501)
					.build();
		}else if (headType.toString().equals("HeadFor502")) {
			return Response
					.status(502)
					.build();
		}else if (headType.toString().equals("HeadFor503")) {
			return Response
					.status(503)
					.build();
		}else if (headType.toString().equals("HeadFor504")) {
			return Response
					.status(504)
					.build();
		}else if (headType.toString().equals("HeadFor505")) {
			return Response
					.status(505)
					.build();
		}else {
			return Response.status(500).build();
		}
	}

	@DELETE
	@Path("/delete")
	public Response setDeleteRequest(
			@HeaderParam("Delete-Type") String deleteType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {
		
		if (deleteType.toString().equals("DeleteFor505")) {
			return Response
					.status(505)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getProtocolMismatchPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor504")) {
			return Response
					.status(504)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getGatewayTimeoutPayload())
					.build();
		} else if (deleteType.toString().equals("DeleteFor503")) {
			return Response
					.status(503)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getTemporalServerErrorPayload())
					.build();
		} else if (deleteType.toString().equals("DeleteFor502")) {
			return Response
					.status(502)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUpstreamServerErrorPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor501")) {
			return Response
					.status(501)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUnexpectedServerErrorPayload())
					.build();
		} else {
			return Response.status(500)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getUnexpectedServerErrorPayload())
					.build();
		}
	}

}
