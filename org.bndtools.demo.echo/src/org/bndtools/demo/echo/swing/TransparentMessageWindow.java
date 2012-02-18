package org.bndtools.demo.echo.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Transparent Window which shows on top of all windows a text message. The
 * window is visible only for a few second.
 */
public class TransparentMessageWindow  {

	private JFrame frame;
	
	private JLabel label;

	/**
	 * Constructor creates the windows the window is not visible to show the
	 * window invoke the display method.
	 */
	public TransparentMessageWindow() {
		createWindow();
	}

	private void createWindow() {
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 0, 0));
		frame.setLocationRelativeTo(null);
		frame.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		@SuppressWarnings("serial")
		final JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				if (g instanceof Graphics2D) {
					final int R = 245;
					final int G = 245;
					final int B = 245;
					Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B,
							100), 0.0f, getHeight(), new Color(R, G, B, 100),
							true);
					Graphics2D g2d = (Graphics2D) g;
					g2d.setPaint(p);
					g2d.fillRect(0, 0, getWidth(), getHeight());
				}
			}
		};
		frame.setContentPane(panel);
		label = new JLabel();
		label.setFont(new Font("Bradley Hand ITC TT", Font.PLAIN, 80));
		label.setForeground(Color.BLACK);
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setVisible(false);
	}

	/**
	 * The text message which should be displayed.
	 * 
	 * @param text
	 *            the text not null.
	 */
	public void setMessage(final String text) {
		createWindow();
		label.setText(text);
	}

	/**
	 * Makes the window visible for a some time.
	 * 
	 * @param millis
	 *            the time how long the window should be visible.
	 */
	public synchronized void display(final long millis) {
		frame.setVisible(true);
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			frame.setVisible(false);
		}
	}

}
