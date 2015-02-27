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
					.type(TEXT_HTML)
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
					.type(TEXT_HTML)
					.entity(messagePayload.getProxyAuthenticationPayload())
					.build();
		}else if (getType.toString().equals("GetFor408")) {
			return Response
					.status(408)
					.type(TEXT_HTML)
					.entity(messagePayload.getRequestTimeoutPayload())
					.build();
		}else if (getType.toString().equals("GetFor409")) {
			return Response
					.status(409)
					.type(TEXT_HTML)
					.entity(messagePayload.getResourceStatePayload())
					.build();
		}else if (getType.toString().equals("GetFor410")) {
			return Response
					.status(410)
					.type(TEXT_HTML)
					.entity(messagePayload.getNonAvailabilityPayload())
					.build();
		}else {
			return Response.status(200).entity("Proxy update successful")
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
				return Response.status(202)
						.entity(messagePayload.getMediumPayload()).build();
			}
		}else if (postType.toString().equals("PostFor411")) {
			return Response
					.status(411)
					.type(TEXT_HTML)
					.entity(messagePayload.getContentLengthErrorPayload())		
					.build();
		}else if (postType.toString().equals("PostFor410")) {
			return Response
					.status(410)
					.type(TEXT_HTML)
					.entity(messagePayload.getNonAvailabilityPayload())		
					.build();
		}else if (postType.toString().equals("PostFor409")) {
			return Response
					.status(409)
					.type(TEXT_HTML)
					.entity(messagePayload.getResourceStatePayload())		
					.build();
		}else if (postType.toString().equals("PostFor408")) {
			return Response
					.status(408)
					.type(TEXT_HTML)
					.entity(messagePayload.getRequestTimeoutPayload())		
					.build();
		}else if (postType.toString().equals("PostFor407")) {
			return Response
					.status(407)
					.type(TEXT_HTML)
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
					.type(TEXT_HTML)
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

		if (putType.toString().equals("PutFor205")) {
			return Response.status(205).build();
		}else if (putType.toString().equals("PutFor411")) {
			return Response
					.status(411)
					.type(TEXT_HTML)
					.entity(messagePayload.getContentLengthErrorPayload())		
					.build();
		}else if (putType.toString().equals("PutFor410")) {
			return Response
					.status(410)
					.type(TEXT_HTML)
					.entity(messagePayload.getNonAvailabilityPayload())		
					.build();
		}else if (putType.toString().equals("PutFor409")) {
			return Response
					.status(409)
					.type(TEXT_HTML)
					.entity(messagePayload.getResourceStatePayload())		
					.build();
		}else if (putType.toString().equals("PutFor408")) {
			return Response
					.status(408)
					.type(TEXT_HTML)
					.entity(messagePayload.getRequestTimeoutPayload())		
					.build();
		}else if (putType.toString().equals("PutFor407")) {
			return Response
					.status(407)
					.type(TEXT_HTML)
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
					.type(TEXT_HTML)
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
		if (deleteType.toString().equals("DeleteFor205")) {
			return Response.status(205).build();
		}else if (deleteType.toString().equals("DeleteFor411")) {
			return Response
					.status(411)
					.type(TEXT_HTML)
					.entity(messagePayload.getContentLengthErrorPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor410")) {
			return Response
					.status(410)
					.type(TEXT_HTML)
					.entity(messagePayload.getNonAvailabilityPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor409")) {
			return Response
					.status(409)
					.type(TEXT_HTML)
					.entity(messagePayload.getResourceStatePayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor408")) {
			return Response
					.status(408)
					.type(TEXT_HTML)
					.entity(messagePayload.getRequestTimeoutPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor407")) {
			return Response
					.status(407)
					.type(TEXT_HTML)
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
					.type(TEXT_HTML)
					.header("WWW-Authenticate", "Basic realm=\"ESBTesting:\"")
					.entity(messagePayload.getAuthenticationPayload())
					.build();
		} else {
			return Response.status(400)
					.entity(messagePayload.getClientErrorPayload())
					.build();
		}
	}

	// public static void main(String args[]) {
	// BackendServicefor3xxResponses backendService = new
	// BackendServicefor3xxResponses();
	// backendService.startUpTestServer();
	// }

	
}
