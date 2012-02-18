package org.bndtools.demo.echo.swing;

import org.bndtools.demo.echo.api.Echo;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration echoService;
	
	@Override
	public void start(BundleContext context) throws Exception {
		// register the service of type Echo
		echoService = context.registerService(Echo.class.getName(), new EchoSwingImpl(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// unregister the service of type Echo
		echoService.unregister();
	}

}
