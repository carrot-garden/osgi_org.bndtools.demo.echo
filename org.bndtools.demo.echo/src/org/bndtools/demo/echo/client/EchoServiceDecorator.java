package org.bndtools.demo.echo.client;

import org.bndtools.demo.echo.api.Echo;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class EchoServiceDecorator implements ServiceTrackerCustomizer {

	private BundleContext context;

	public EchoServiceDecorator(BundleContext context) {
		this.context = context;
	}
	
	@Override
	public Object addingService(ServiceReference reference) {
		EchoServiceProxy echoServiceProxy = new EchoServiceProxy(context, reference);
		addingEchoService(echoServiceProxy);
		return echoServiceProxy;
	}

	@Override
	public void modifiedService(ServiceReference reference, Object service) {
	}

	@Override
	public void removedService(ServiceReference reference, Object service) {
		removedEchoService((Echo) service);
		((EchoServiceProxy) service).dispose();
	}
	
	public abstract void addingEchoService(Echo echo);
	
	public abstract void removedEchoService(Echo echo);

}
