package org.wso2.esb.backend;

import java.util.Collections;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.wso2.esb.payload.RequestPayload;

@Path("/")
public class BackendService {

	private ResteasyDeployment deployment;
	private static Logger logger = Logger.getAnonymousLogger();;
	private final NettyJaxrsServer server = new NettyJaxrsServer();
	private final int PORT = 3000;

	public void startUpTestServer() {

		deployment = new ResteasyDeployment();
		deployment.setResourceClasses(Collections
				.singletonList(BackendService.class.getName()));

		server.setDeployment(deployment);
		// SSLContext ssl = SSLContext.getInstance("TLS");
		// ssl.init(kms, tms, null);

		server.setPort(PORT);
		server.start();
		logger.info("Server listening on port " + PORT);

	}

	public void shutdownTestServer() {
		server.stop();
		logger.info("Shutting down server listening on port " + PORT);
	}

	@GET
	public Response get() {
		return Response.status(200).entity("200 Compliant for GET").build();
	}

	@GET
	@Path("{any}")
	public Response catchAll() {
		return this.get();
	}

	@POST
	@Path("/post")
	public Response setPostRequest(@HeaderParam("Post-Type") String postType, String requestPayload) {

		String responsePayload = requestPayload;
		
		if (postType.toString().equals("PostFor201")) {
			return Response.status(201)
					.entity("http://localhost:3000/PostFor201").build();
		} else {
			return Response.status(200).entity(responsePayload.toString()).build();
		}

	}

//	@POST
//	@Path("/post")
//	public Response setDefaultPostRequest(String requestPayload) {
//
//		String responsePayload = requestPayload;
//		return Response.status(200).entity(responsePayload.toString()).build();
//	}

	// @POST
	// @Path("/post/{postType}")
	// public Response setCustomPostRequest(@PathParam("postType") String
	// postType) {
	//
	// if(postType.equals("PostFor201")){
	// return
	// Response.status(201).entity("http://localhost:3000/PostFor201").build();
	// }
	// else{
	// return
	// Response.status(200).entity("Response for other scenarios").build();
	// }
	//
	//
	// }

	@PUT
	@Path("/put")
	public Response setPutRequest(String requestPayload) {
		return Response.status(200)
				.entity("200 Compliant for " + requestPayload.toString())
				.build();
	}

	@HEAD
	@Path("/")
	public Response setHeadRequest() {
		return Response.status(200).build();
	}

	@DELETE
	@Path("/delete")
	public Response setDeleteRequest() {
		return Response.status(200).entity("200 Compliant for DELETE by ")
				.build();
	}

}
