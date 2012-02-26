package org.bndtools.demo.echo.swing

import org.bndtools.demo.echo.api.Echo

import aQute.bnd.annotation.component.*

@Component
class EchoSwingImpl implements Echo {
	
	private TransparentMessageWindow messageWindow = new TransparentMessageWindow()

	void show(String message) {
		messageWindow.setMessage(message)
		messageWindow.display(1500)
	}

	void setMessageWindow(TransparentMessageWindow messageWindow) {
		this.messageWindow = messageWindow
	}

}
