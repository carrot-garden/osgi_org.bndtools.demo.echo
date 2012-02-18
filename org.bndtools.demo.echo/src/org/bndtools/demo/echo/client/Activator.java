package org.bndtools.demo.echo.client;

import org.bndtools.demo.echo.api.Echo;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

	private final EchoClient echoClient = new EchoClient();

	private ServiceTracker echoServiceTracker;

	@Override
	public void start(BundleContext context) throws Exception {
		EchoServiceDecorator echoServiceDecorator = new EchoServiceDecorator(context) {
			
			@Override
			public void addingEchoService(Echo echo) {
				echoClient.setEcho(echo);
				echoClient.start();
			}

			@Override
			public void removedEchoService(Echo echo) {
				echoClient.stop();
				echoClient.unsetEcho(echo);
			}
		};
		echoServiceTracker = new ServiceTracker(context, Echo.class.getName(), echoServiceDecorator);
		echoServiceTracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		echoServiceTracker.close();
	}

}
