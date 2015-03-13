package org.wso2.esb.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

public class BackendServerManager {
	
	private ResteasyDeployment resteasyDeployment;
	private static Logger logger = Logger.getAnonymousLogger();;
	private final NettyJaxrsServer server = new NettyJaxrsServer();
	private final int PORT = 3000;
	public final List<String> classList = new ArrayList<String>();

	//Deploying the resources and starting the Netty server
	public void startUpTestServer() {
		
		resteasyDeployment = new ResteasyDeployment();		
		resteasyDeployment.setResourceClasses(addDeploymentClasses());
		
		server.setDeployment(resteasyDeployment);
		server.setPort(PORT);
		server.start();
		
		logger.info("Server listening on port " + PORT);
	}

	//Shutting down the back-end server
	public void shutdownTestServer() {
		server.stop();
		logger.info("Shutting down server listening on port " + PORT);
	}
	
	//inclusion of REST Implementation classes to the Back-end
	public List<String> addDeploymentClasses(){		
		classList.add(BackendServicefor1xxResponses.class.getName());
		classList.add(BackendServicefor2xxResponses.class.getName());
		classList.add(BackendServicefor3xxResponses.class.getName());
		classList.add(BackendServicefor4xxResponses.class.getName());
		classList.add(BackendServicefor5xxResponses.class.getName());
		return classList;		
	}

}
