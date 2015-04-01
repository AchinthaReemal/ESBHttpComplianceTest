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
import javax.ws.rs.core.Response;

import org.wso2.esb.payload.MessagePayload;

@Path("/2xx")
public class BackendServicefor2xxResponses {

	MessagePayload messagePayload = new MessagePayload();


	@GET
	@Path("/get")
	public Response get(@HeaderParam("Get-Type") String getType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (getType.toString().equals("GetFor203")) {
			return Response.status(203).entity(messagePayload.getMediumPayload())
					.build();
		} else if (getType.toString().equals("GetFor206")) {
			return Response.status(206).entity(messagePayload.getMediumPayload())
					.build();
		} else {
			return Response.status(200).entity(messagePayload.getMediumPayload())
					.build();
		}

	}

	@POST
	@Path("/post")
	public Response setPostRequest(@HeaderParam("Post-Type") String postType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (postType.toString().equals("PostFor201")) {
			return Response.status(201)
					.entity("http://localhost:3000/PostFor201").build();
		} else if (postType.toString().equals("PostFor202")) {
			if (responseType.toString().equals("WithOutBody")) {
				return Response.status(202).build();
			} else {
				return Response.status(202).entity(messagePayload.getMediumPayload())
						.build();
			}
		} else if (postType.toString().equals("PostFor203")) {
			return Response.status(203).entity(messagePayload.getMediumPayload())
					.build();
		} else if (postType.toString().equals("PostFor204")) {
			return Response.status(204).build();
		} else if (postType.toString().equals("PostFor205")) {
			return Response.status(205).build();
		} else {
			return Response.status(200).entity(messagePayload.getMediumPayload())
					.build();
		}

	}

	@PUT
	@Path("/put")
	public Response setPutRequest(@HeaderParam("Put-Type") String putType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (putType.toString().equals("PutFor205")) {
			return Response.status(205).build();
		} else if (putType.toString().equals("PutFor204")) {
			return Response.status(204).build();
		} else if (putType.toString().equals("PutFor203")) {
			return Response.status(203).build();
		} else {
			return Response.status(200).entity(messagePayload.getMediumPayload())
					.build();
		}

	}

	@HEAD
	@Path("/head")
	public Response setHeadRequest(@HeaderParam("Head-Type") String headType) {

		if (headType.toString().equals("HeadFor203")) {
			return Response.status(203).build();
		} else {
			return Response.status(200).build();
		}
	}

	@DELETE
	@Path("/delete")
	public Response setDeleteRequest(
			@HeaderParam("Delete-Type") String deleteType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {
		if (deleteType.toString().equals("DeleteFor205")) {
			return Response.status(205).build();
		} else if (deleteType.toString().equals("DeleteFor204")) {
			return Response.status(204).build();
		} else if (deleteType.toString().equals("DeleteFor203")) {
			return Response.status(203).build();
		} else {
			return Response.status(200).build();
		}
	}
	
}
