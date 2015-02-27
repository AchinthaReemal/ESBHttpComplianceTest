package org.wso2.esb.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.wso2.esb.payload.MessagePayload;

@Path("/")
public class BackendServicefor2xxResponses {

	private ResteasyDeployment resteasyDeployment;
	private static Logger logger = Logger.getAnonymousLogger();;
	private final NettyJaxrsServer server = new NettyJaxrsServer();
	private final int PORT = 3000;
	public final List<String> classList = new ArrayList<String>();
	MessagePayload messagePayload = new MessagePayload();

	public void startUpTestServer() {
		
		resteasyDeployment = new ResteasyDeployment();
		
		resteasyDeployment.setResourceClasses(addDeploymentClasses());
		
		server.setDeployment(resteasyDeployment);
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
	
	public List<String> addDeploymentClasses(){		
		classList.add(BackendServicefor2xxResponses.class.getName());
		classList.add(BackendServicefor3xxResponses.class.getName());
		classList.add(BackendServicefor4xxResponses.class.getName());
		return classList;		
	}

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

	public static void main(String args[]) {
		BackendServicefor2xxResponses backendService = new BackendServicefor2xxResponses();
		backendService.startUpTestServer();
	}

}
