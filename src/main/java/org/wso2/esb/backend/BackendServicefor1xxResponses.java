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

import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.wso2.esb.payload.MessagePayload;

@Path("/1xx")
public class BackendServicefor1xxResponses {
	
	private static Logger logger = Logger.getAnonymousLogger();
	MessagePayload messagePayload = new MessagePayload();


	@GET
	@Path("/get")
	public Response get(@HeaderParam("Get-Type") String getType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {
		
		if (getType.toString().equals("GetFor101")) {
			return Response.status(101).build();
		} else {
			return Response.status(100).build();
		}

	}

	@POST
	@Path("/post")
	public Response setPostRequest(@HeaderParam("Post-Type") String postType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (postType.toString().equals("PostFor101")) {
			return Response.status(101).build();
		}else {
			return Response.status(100).build();
		}

	}

	@PUT
	@Path("/put")
	public Response setPutRequest(@HeaderParam("Put-Type") String putType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (putType.toString().equals("PutFor101")) {
			return Response.status(101).build();
		} else {
			return Response.status(100).build();
		}

	}

	@HEAD
	@Path("/head")
	public Response setHeadRequest(@HeaderParam("Head-Type") String headType) {

		if (headType.toString().equals("HeadFor101")) {
			return Response.status(101).build();
		} else {
			return Response.status(100).build();
		}
	}

	@DELETE
	@Path("/delete")
	public Response setDeleteRequest(
			@HeaderParam("Delete-Type") String deleteType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {
		
		if (deleteType.toString().equals("DeleteFor101")) {
			return Response.status(101).build();
		} else {
			return Response.status(100).build();
		}
	}

}
