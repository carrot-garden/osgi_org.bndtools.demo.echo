package org.bndtools.demo.echo.client

import groovyx.osgi.OsgiCategory;

import org.bndtools.demo.echo.api.Echo
import org.osgi.framework.BundleContext;

import aQute.bnd.annotation.component.*


@Component(provide=[])
class EchoClient {

	@Reference
	void setEcho(Echo echo) {}
		
	@Activate
	void start(BundleContext context) {
		use(OsgiCategory) {
			context.findServices(Echo).withEachService() { echo ->
				echo.show('Start client get echo with groovyx-osgi')
			}
		}
	}
	
	@Deactivate
	void stop(BundleContext context) {
		use(OsgiCategory) {
			context.findServices(Echo).withEachService() { echo ->
				echo.show('Stop client get echo with groovyx-osgi')
			}
		}
	}
	
}
