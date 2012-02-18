package org.bndtools.demo.echo.tests;

import org.bndtools.demo.echo.api.Echo;
import org.osgi.framework.Bundle;
import org.osgi.service.packageadmin.PackageAdmin;

import aQute.junit.runtime.OSGiTestCase;
import aQute.junit.runtime.Operation;

public class EchoTest extends OSGiTestCase {

	public void testEchoApiBundleIsActive() throws Exception {
		assertEquals("Bundle state must be active.", 
				Bundle.ACTIVE, 
				getBundle("org.bndtools.demo.echo.api").getState());
	}

	public void testEchoSwingBundleIsActive() throws Exception {
		assertEquals("Bundle state must be active.", 
				Bundle.ACTIVE, 
				getBundle("org.bndtools.demo.echo.swing").getState());
	}
	
	public void testEchoServiceAvailable() throws Exception {
		assertSvcAvail(Echo.class, null);
	}
	
	Bundle getBundle(final String symbolicName) throws Exception {
		return withService(PackageAdmin.class, null, new Operation<PackageAdmin, Bundle>() {
			@Override
			public Bundle perform(PackageAdmin service) throws Exception {
				Bundle[] bundles = service.getBundles(symbolicName, null);
				assertNotNull("The array of bundles must not be null.", bundles);
				assertEquals("The array must contain one bundle.", 1, bundles.length);
				return bundles[0];
			}
		});
	}
	
}
