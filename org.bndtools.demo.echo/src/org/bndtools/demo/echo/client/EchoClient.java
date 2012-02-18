package org.bndtools.demo.echo.client;

import org.bndtools.demo.echo.api.Echo;

public class EchoClient {

	private Echo echo;

	public void setEcho(Echo echo) {
		this.echo = echo;
	}
	
	public void unsetEcho(Echo echo) {
		this.echo = null;
	}
	
	public void start() {
		echo.show("Echo Client is started.");
	}
	
	public void stop() {
		echo.show("Stop the Echo Client.");
	}
	
}
