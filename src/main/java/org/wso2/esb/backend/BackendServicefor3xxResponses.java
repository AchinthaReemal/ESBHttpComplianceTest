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

@Path("/3xx")
public class BackendServicefor3xxResponses {

	private static final MediaType TEXT_HTML = new MediaType();
	MessagePayload messagePayload = new MessagePayload();

	@GET
	@Path("/get")
	public Response get(@HeaderParam("Get-Type") String getType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (getType.toString().equals("GetFor300")) {
			return Response.status(300)
					.entity(messagePayload.getMultioptionPayload()).build();
		} else if (getType.toString().equals("GetFor301")) {
			return Response
					.status(301)
					.type(TEXT_HTML)
					.header("Location", "http://localhost:3000/3xx/redirection")
					.entity(messagePayload.getHTMLPermenentPayload()).build();
		} else if (getType.toString().equals("GetFor302")) {
			return Response
					.status(302)
					.type(TEXT_HTML)
					.header("Location", "http://localhost:3000/3xx/redirection")
					.entity(messagePayload.getHTMLTemporalPayload()).build();
		} else if (getType.toString().equals("GetFor303")) {
			return Response
					.status(303)
					.type(TEXT_HTML)
					.header("Location",
							"http://127.0.0.1:3000/services/HttpRedirect")
					.entity(messagePayload.getHTMLOtherPayload()).build();
		} else if (getType.toString().equals("GetFor304")) {
			return Response
					.status(304)
					.type(TEXT_HTML)
					.header("Location",
							"http://127.0.0.1:3000/services/HttpRedirect")
					.build();
		}else if (getType.toString().equals("GetFor305")) {
			return Response
					.status(305)
					.type(TEXT_HTML)
					.header("Location",
							"http://127.0.0.1:3000/services/HttpRedirect")
					.entity(messagePayload.getHTMLProxyrPayload())
					.build();
		} else if (getType.toString().equals("GetFor307")) {
			return Response
					.status(307)
					.type(TEXT_HTML)
					.header("Location",
							"http://127.0.0.1:3000/services/HttpRedirect")
					.entity(messagePayload.getHTMLTemporalPayload())
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
		}else if (postType.toString().equals("PostFor307")) {
			return Response
					.status(307)
					.type(TEXT_HTML)
					.header("Location",
							"http://127.0.0.1:3000/services/HttpRedirect")
					.entity(messagePayload.getHTMLTemporalPayload())		
					.build();
		}else if (postType.toString().equals("PostFor305")) {
			return Response
					.status(305)
					.type(TEXT_HTML)
					.header("Location",
							"http://127.0.0.1:3000/services/HttpRedirect")
					.build();
		}  else if (postType.toString().equals("PostFor303")) {
			return Response
					.status(303)
					.type(TEXT_HTML)
					.header("Location",
							"http://127.0.0.1:3000/services/HttpRedirect")
					.entity(messagePayload.getHTMLOtherPayload())
					.build();
		} else if (postType.toString().equals("PostFor302")) {
			return Response
					.status(302)
					.type(TEXT_HTML)
					.header("Location", "http://localhost:3000/3xx/redirection")
					.entity(messagePayload.getHTMLTemporalPayload()).build();
		} else if (postType.toString().equals("PostFor301")) {
			return Response
					.status(301)
					.type(TEXT_HTML)
					.header("Location", "http://localhost:3000/3xx/redirection")
					.entity(messagePayload.getHTMLPermenentPayload()).build();
		} else {
			return Response.status(300)
					.entity(messagePayload.getMultioptionPayload()).build();
		}

	}

	@PUT
	@Path("/put")
	public Response setPutRequest(@HeaderParam("Put-Type") String putType,
			@HeaderParam("Response-Type") String responseType,
			String requestPayload) {

		if (putType.toString().equals("PutFor205")) {
			return Response.status(205).build();
		}else if (putType.toString().equals("PutFor307")) {
			return Response
					.status(307)
					.type(TEXT_HTML)
					.header("Location",
							"http://localhost:3000/services/HttpRedirect")
					.entity(messagePayload.getHTMLTemporalPayload())		
					.build();
		} else if (putType.toString().equals("PutFor305")) {
			return Response
					.status(305)
					.type(TEXT_HTML)
					.header("Location",
							"http://localhost:3000/services/HttpRedirect")
					.build();
		}else if (putType.toString().equals("PutFor303")) {
			return Response
					.status(303)
					.type(TEXT_HTML)
					.header("Location",
							"http://localhost:3000/services/HttpRedirect")
					.entity(messagePayload.getHTMLTemporalPayload()).build();
		} else if (putType.toString().equals("PutFor302")) {
			return Response
					.status(302)
					.type(TEXT_HTML)
					.header("Location", "http://localhost:3000/3xx/redirection")
					.entity(messagePayload.getHTMLTemporalPayload()).build();
		} else if (putType.toString().equals("PutFor301")) {
			return Response
					.status(301)
					.type(TEXT_HTML)
					.header("Location", "http://localhost:3000/3xx/redirection")
					.entity(messagePayload.getHTMLPermenentPayload()).build();
		} else {
			return Response.status(300)
					.entity(messagePayload.getMultioptionPayload()).build();
		}

	}

	@HEAD
	@Path("/head")
	public Response setHeadRequest(@HeaderParam("Head-Type") String headType) {

		if (headType.toString().equals("HeadFor301")) {
			return Response
					.status(301)
					.header("Location", "http://localhost:8280/services/HttpRedirect")
					.build();
		} else if (headType.toString().equals("HeadFor302")) {
			return Response
					.status(302)
					.header("Location", "http://localhost:8280/services/HttpRedirect")
					.build();
		} else if (headType.toString().equals("HeadFor303")) {
			return Response
					.status(303)
					.header("Location",
							"http://127.0.0.1:3000/services/HttpRedirect")
					.build();
		}else if (headType.toString().equals("HeadFor305")) {
			return Response
					.status(305)
					.header("Location",
							"http://127.0.0.1:8280/services/HttpRedirect")
					.build();
		}else if (headType.toString().equals("HeadFor307")) {
			return Response
					.status(307)
					.header("Location",
							"http://127.0.0.1:8280/services/HttpRedirect")
					.build();
		} else {
			return Response.status(300)
					.header("Location", "http://localhost:3000/3xx/options")
					.build();
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
		}else if (deleteType.toString().equals("DeleteFor307")) {
			return Response
					.status(307)
					.type(TEXT_HTML)
					.header("Location",
							"http://localhost:3000/services/HttpRedirect")
					.entity(messagePayload.getHTMLTemporalPayload())
					.build();
		}else if (deleteType.toString().equals("DeleteFor305")) {
			return Response
					.status(305)
					.type(TEXT_HTML)
					.header("Location",
							"http://localhost:3000/services/HttpRedirect")
					.entity(messagePayload.getHTMLProxyrPayload())
					.build();
		} else if (deleteType.toString().equals("DeleteFor303")) {
			return Response
					.status(303)
					.type(TEXT_HTML)
					.header("Location",
							"http://localhost:3000/services/HttpRedirect")
					.entity(messagePayload.getHTMLTemporalPayload())
					.build();
		} else if (deleteType.toString().equals("DeleteFor302")) {
			return Response
					.status(302)
					.type(TEXT_HTML)
					.header("Location", "http://localhost:3000/3xx/redirection")
					.entity(messagePayload.getHTMLTemporalPayload())
					.build();
		} else if (deleteType.toString().equals("DeleteFor301")) {
			return Response
					.status(301)
					.type(TEXT_HTML)
					.header("Location", "http://localhost:3000/3xx/redirection")
					.entity(messagePayload.getHTMLPermenentPayload())
					.build();
		} else {
			return Response.status(300)
					.entity(messagePayload.getMultioptionPayload())
					.build();
		}
	}

	@GET
	@Path("/redirection")
	public Response getRedirect(@HeaderParam("Get-Type") String getType) {

		// if (getType.toString().equals("GetFor303")) {
		// return Response.status(200).entity("Redirection Successful")
		// .build();
		// }
		// else {
		return Response.status(200).entity("Redirection Successful").build();
		// }

	}

	@HEAD
	@Path("/redirection")
	public Response headRedirect(@HeaderParam("Head-Type") String headType) {

//		if (headType.toString().equals("HeadFor303")) {
//			return Response
//					.status(200)
//					.header("Location",
//							"http://localhost:3000/3xxx/redirection").build();
//		} else {
			return Response
					.status(200)
					.header("Location",
							"http://localhost:8280/3xxx/redirection").build();
//		}
	}
	
	@POST
	@Path("/redirection")
	public Response postRedirect(@HeaderParam("Post-Type") String headType) {

//		if (headType.toString().equals("HeadFor303")) {
//			return Response
//					.status(200)
//					.header("Location",
//							"http://localhost:3000/3xxx/redirection").build();
//		} else {
			return Response
					.status(200)
					.header("Location",
							"http://localhost:8280/3xxx/redirection")
					.entity("Redirection Successful")
					.build();
//		}
	}

	// public static void main(String args[]) {
	// BackendServicefor3xxResponses backendService = new
	// BackendServicefor3xxResponses();
	// backendService.startUpTestServer();
	// }

}
