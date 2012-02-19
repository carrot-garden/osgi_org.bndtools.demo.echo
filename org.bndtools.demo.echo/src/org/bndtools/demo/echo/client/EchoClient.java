package org.bndtools.demo.echo.client;

import org.bndtools.demo.echo.api.Echo;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import aQute.bnd.annotation.component.Reference;

@Component
public class EchoClient {

	private Echo echo;

	@Reference
	public void setEcho(Echo echo) {
		this.echo = echo;
	}
	
	public void unsetEcho(Echo echo) {
		this.echo = null;
	}
	
	@Activate
	public void start() {
		echo.show("Echo Client is started.");
	}
	
	@Deactivate
	public void stop() {
		echo.show("Stop the Echo Client.");
	}
	
}
