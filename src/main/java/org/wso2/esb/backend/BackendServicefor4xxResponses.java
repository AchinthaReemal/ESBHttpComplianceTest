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

@Path("/4xx")
public class BackendServicefor4xxResponses {

	private static final MediaType TEXT_HTML = new MediaType();
	MessagePayload messagePayload = new MessagePayload();

	@GET
	@Path("/get")
	public Response get(@HeaderParam("Get-Type") String getType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (getType.toString().equals("GetFor400")) {
			return Response.status(400)
					.entity(messagePayload.getClientErrorPayload())
					.build();
		} else if (getType.toString().equals("GetFor401")) {
			return Response
					.status(401)
					.type(MediaType.TEXT_HTML)
					.header("WWW-Authenticate", "Basic realm=\"ESBTesting:\"")
					.entity(messagePayload.getAuthenticationPayload()).build();
		} else if (getType.toString().equals("GetFor403")) {
			return Response
					.status(403)
					.entity(messagePayload.getClientErrorPayload())
					.build();
		} else if (getType.toString().equals("GetFor404")) {
			return Response
					.status(404)
					.entity(messagePayload.getClientResourceErrorPayload())
					.build();
		}else if (getType.toString().equals("GetFor405")) {
			return Response
					.status(405)
					.header("Allow","POST, PUT, DELETE")
					.entity(messagePayload.getClientMethodErrorPayload())
					.build();
		}else if (getType.toString().equals("GetFor406")) {
			return Response
					.status(406)
					.header("Content-Type","text/html; charset=utf-8")
					.entity(messagePayload.getClientContentErrorPayload())
					.build();
		} else if (getType.toString().equals("GetFor407")) {
			return Response
					.status(407)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getProxyAuthenticationPayload())
					.build();
		}else if (getType.toString().equals("GetFor408")) {
			return Response
					.status(408)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getRequestTimeoutPayload())
					.build();
		}else if (getType.toString().equals("GetFor409")) {
			return Response
					.status(409)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getResourceStatePayload())
					.build();
		}else if (getType.toString().equals("GetFor410")) {
			return Response
					.status(410)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getNonAvailabilityPayload())
					.build();
		}else if (getType.toString().equals("GetFor412")) {
			return Response
					.status(412)
					.type(MediaType.TEXT_HTML)
					.header("If-Unmodified-Since","Fri, 27 Feb 2015 19:43:31 GMT")
					.entity(messagePayload.getPreconditionErrorPayload())
					.build();
		}else if (getType.toString().equals("GetFor413")) {
			return Response
					.status(413)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getEntityErrorPayload())
					.build();
		}else if (getType.toString().equals("GetFor414")) {
			return Response
					.status(414)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getRequestConflictPayload())
					.build();
		}else if (getType.toString().equals("GetFor415")) {
			return Response
					.status(415)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getFormatMismatchPayload())
					.build();
		}else if (getType.toString().equals("GetFor416")) {
			return Response
					.status(416)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getRangeErrorPayload())
					.build();
		}else if (getType.toString().equals("GetFor417")) {
			return Response
					.status(417)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getExpectedResponseErrorPayload())
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

		if (postType.toString().equals("PostFor417")) {
			return Response
					.status(417)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getExpectedResponseErrorPayload())		
					.build();
		}else if (postType.toString().equals("PostFor416")) {
			return Response
					.status(416)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getRangeErrorPayload())		
					.build();
		}else if (postType.toString().equals("PostFor415")) {
			return Response
					.status(415)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getFormatMismatchPayload())		
					.build();
		}else if (postType.toString().equals("PostFor413")) {
			return Response
					.status(413)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getEntityErrorPayload())		
					.build();
		}else if (postType.toString().equals("PostFor412")) {
			return Response
					.status(412)
					.type(MediaType.TEXT_HTML)
					.header("If-Unmodified-Since","Fri, 27 Feb 2015 19:43:31 GMT")
					.entity(messagePayload.getPreconditionErrorPayload())		
					.build();
		}else if (postType.toString().equals("PostFor411")) {
			return Response
					.status(411)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getContentLengthErrorPayload())		
					.build();
		}else if (postType.toString().equals("PostFor410")) {
			return Response
					.status(410)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getNonAvailabilityPayload())		
					.build();
		}else if (postType.toString().equals("PostFor409")) {
			return Response
					.status(409)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getResourceStatePayload())		
					.build();
		}else if (postType.toString().equals("PostFor408")) {
			return Response
					.status(408)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getRequestTimeoutPayload())		
					.build();
		}else if (postType.toString().equals("PostFor407")) {
			return Response
					.status(407)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getProxyAuthenticationPayload())		
					.build();
		}else if (postType.toString().equals("PostFor406")) {
			return Response
					.status(406)
					.header("Content-Type","text/html; charset=utf-8")
					.entity(messagePayload.getClientContentErrorPayload())
					.build();
		}else if (postType.toString().equals("PostFor405")) {
			return Response
					.status(405)
					.header("Allow","GET, HEAD")
					.entity(messagePayload.getClientMethodErrorPayload())
					.build();
		} else if (postType.toString().equals("PostFor404")) {
			return Response
					.status(404)
					.entity(messagePayload.getClientResourceErrorPayload())
					.build();
		}else if (postType.toString().equals("PostFor403")) {
			return Response
					.status(403)
					.entity(messagePayload.getClientErrorPayload())
					.build();
		} else if (postType.toString().equals("PostFor401")) {
			return Response
					.status(401)
					.type(MediaType.TEXT_HTML)
					.header("WWW-Authenticate", "Basic realm=\"ESBTesting:\"")
					.entity(messagePayload.getAuthenticationPayload()).build();
		} else {
			return Response.status(400)
					.entity(messagePayload.getClientErrorPayload()).build();
		}

	}

	@PUT
	@Path("/put")
	public Response setPutRequest(@HeaderParam("Put-Type") String putType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (putType.toString().equals("PutFor417")) {
			return Response
					.status(417)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getExpectedResponseErrorPayload())		
					.build();
		}else if (putType.toString().equals("PutFor416")) {
			return Response
					.status(416)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getRangeErrorPayload())		
					.build();
		}else if (putType.toString().equals("PutFor415")) {
			return Response
					.status(415)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getFormatMismatchPayload())		
					.build();
		}else if (putType.toString().equals("PutFor413")) {
			return Response
					.status(413)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getEntityErrorPayload())		
					.build();
		}else if (putType.toString().equals("PutFor412")) {
			return Response
					.status(412)
					.type(MediaType.TEXT_HTML)
					.header("If-Unmodified-Since","Fri, 27 Feb 2015 19:43:31 GMT")
					.entity(messagePayload.getPreconditionErrorPayload())		
					.build();
		}else if (putType.toString().equals("PutFor411")) {
			return Response
					.status(411)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getContentLengthErrorPayload())		
					.build();
		}else if (putType.toString().equals("PutFor410")) {
			return Response
					.status(410)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getNonAvailabilityPayload())		
					.build();
		}else if (putType.toString().equals("PutFor409")) {
			return Response
					.status(409)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getResourceStatePayload())		
					.build();
		}else if (putType.toString().equals("PutFor408")) {
			return Response
					.status(408)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getRequestTimeoutPayload())		
					.build();
		}else if (putType.toString().equals("PutFor407")) {
			return Response
					.status(407)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getProxyAuthenticationPayload())		
					.build();
		}else if (putType.toString().equals("PutFor406")) {
			return Response
					.status(406)
					.header("Content-Type","text/html; charset=utf-8")
					.entity(messagePayload.getClientContentErrorPayload())
					.build();
		}else if (putType.toString().equals("PutFor405")) {
			return Response
					.status(405)
					.header("Allow","GET, HEAD")
					.entity(messagePayload.getClientMethodErrorPayload())
					.build();
		}else if (putType.toString().equals("PutFor404")) {
			return Response
					.status(404)
					.entity(messagePayload.getClientResourceErrorPayload())
					.build();
		}else if (putType.toString().equals("PutFor403")) {
			return Response
					.status(403)
					.entity(messagePayload.getClientErrorPayload())
					.build();
		} else if (putType.toString().equals("PutFor401")) {
			return Response
					.status(401)
					.type(MediaType.TEXT_HTML)
					.header("WWW-Authenticate", "Basic realm=\"ESBTesting:\"")
					.entity(messagePayload.getAuthenticationPayload())
					.build();
		} else {
			return Response.status(400)
					.entity(messagePayload.getClientErrorPayload()).build();
		}

	}

	@HEAD
	@Path("/head")
	public Response setHeadRequest(@HeaderParam("Head-Type") String headType) {

		if (headType.toString().equals("HeadFor401")) {
			return Response
					.status(401)
					.header("WWW-Authenticate", "Basic realm=\"ESBTesting:\"")
					.build();
		} else if (headType.toString().equals("HeadFor403")) {
			return Response
					.status(403)
					.build();
		}else if (headType.toString().equals("HeadFor404")) {
			return Response
					.status(404)
					.build();
		}else if (headType.toString().equals("HeadFor405")) {
			return Response
					.status(405)
					.header("Allow","POST, PUT, DELETE")
					.build();
		}else if (headType.toString().equals("HeadFor406")) {
			return Response
					.status(406)
					.header("Content-Type","text/html; charset=utf-8")
					.build();
		}else if (headType.toString().equals("HeadFor407")) {
			return Response
					.status(407)
					.build();
		}else if (headType.toString().equals("HeadFor408")) {
			return Response
					.status(408)
					.build();
		}else if (headType.toString().equals("HeadFor409")) {
			return Response
					.status(409)
					.build();
		}else if (headType.toString().equals("HeadFor410")) {
			return Response
					.status(410)
					.build();
		}else if (headType.toString().equals("HeadFor412")) {
			return Response
					.status(412)
					.header("If-Unmodified-Since","Fri, 27 Feb 2015 19:43:31 GMT")
					.build();
		}else if (headType.toString().equals("HeadFor413")) {
			return Response
					.status(413)
					.build();
		}else if (headType.toString().equals("HeadFor415")) {
			return Response
					.status(415)
					.build();
		}else if (headType.toString().equals("HeadFor416")) {
			return Response
					.status(416)
					.build();
		}else if (headType.toString().equals("HeadFor417")) {
			return Response
					.status(417)
					.build();
		}else {
			return Response.status(400).build();
		}
	}

	@DELETE
	@Path("/delete")
	public Response setDeleteRequest(
			@HeaderParam("Delete-Type") String deleteType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {
		
		if (deleteType.toString().equals("DeleteFor417")) {
			return Response
					.status(417)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getExpectedResponseErrorPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor416")) {
			return Response
					.status(416)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getRangeErrorPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor415")) {
			return Response
					.status(415)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getFormatMismatchPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor413")) {
			return Response
					.status(413)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getEntityErrorPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor412")) {
			return Response
					.status(412)
					.type(MediaType.TEXT_HTML)
					.header("If-Unmodified-Since","Fri, 27 Feb 2015 19:43:31 GMT")
					.entity(messagePayload.getPreconditionErrorPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor411")) {
			return Response
					.status(411)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getContentLengthErrorPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor410")) {
			return Response
					.status(410)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getNonAvailabilityPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor409")) {
			return Response
					.status(409)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getResourceStatePayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor408")) {
			return Response
					.status(408)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getRequestTimeoutPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor407")) {
			return Response
					.status(407)
					.type(MediaType.TEXT_HTML)
					.entity(messagePayload.getProxyAuthenticationPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor406")) {
			return Response
					.status(406)
					.header("Content-Type","text/html; charset=utf-8")
					.entity(messagePayload.getClientContentErrorPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor405")) {
			return Response
					.status(405)
					.header("Allow","GET, HEAD")
					.entity(messagePayload.getClientMethodErrorPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor404")) {
			return Response
					.status(404)
					.entity(messagePayload.getClientResourceErrorPayload())
					.build();
		} else if (deleteType.toString().equals("DeleteFor403")) {
			return Response
					.status(403)
					.entity(messagePayload.getClientErrorPayload())
					.build();
		} else if (deleteType.toString().equals("DeleteFor401")) {
			return Response
					.status(401)
					.type(MediaType.TEXT_HTML)
					.header("WWW-Authenticate", "Basic realm=\"ESBTesting:\"")
					.entity(messagePayload.getAuthenticationPayload())
					.build();
		} else {
			return Response.status(400)
					.entity(messagePayload.getClientErrorPayload())
					.build();
		}
	}
	
}
