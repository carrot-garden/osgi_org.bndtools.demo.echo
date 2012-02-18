package org.bndtools.demo.echo.client;

import org.bndtools.demo.echo.api.Echo;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class EchoServiceProxy implements Echo {

	private BundleContext context;
	private ServiceReference ref;
	
	private Echo targetService;

	public EchoServiceProxy(BundleContext context, ServiceReference ref) {
		this.context = context;
		this.ref = ref;
		targetService = (Echo) context.getService(ref);
	}

	@Override
	public void show(String message) {
		targetService.show(message);
	}
	
	public void dispose(){
		if(targetService != null){
			context.ungetService(ref);
			context = null;
			ref = null;
			targetService = null;
		}
	}
	
}
