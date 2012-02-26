package org.bndtools.demo.echo.client

import org.bndtools.demo.echo.api.Echo

import aQute.bnd.annotation.component.*

@Component(provide=[])
class EchoClient {

	private Echo echo

	@Reference
	void setEcho(Echo echo) {
		this.echo = echo
	}
	
	void unsetEcho(Echo echo) {
		this.echo = null
	}
	
	@Activate
	void start() {
		echo.show "Echo Client is started."
	}
	
	@Deactivate
	void stop() {
		echo.show "Stop the Echo Client."
	}
	
}
