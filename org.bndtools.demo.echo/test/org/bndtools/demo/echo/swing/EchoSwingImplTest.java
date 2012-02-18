package org.bndtools.demo.echo.swing;

import junit.framework.TestCase;

public class EchoSwingImplTest extends TestCase {

	EchoSwingImpl echoSwing;

	long displayMillis;

	String setMessageText;

	TransparentMessageWindow mockMessageWindow = new TransparentMessageWindow(){
		public void setMessage(String message) {
			setMessageText = message;
		};
		public synchronized void display(long millis) {
			displayMillis = millis;
		};
	};
	
	@Override
	protected void setUp() throws Exception {
		echoSwing = new EchoSwingImpl();
		echoSwing.setMessageWindow(mockMessageWindow);
	}
	
	public void testShow() throws Exception {
		final String text = "Hello Bnd World";
		echoSwing.show(text);
		assertEquals(text, setMessageText);
		assertEquals(1500, displayMillis);
	}
	
}
