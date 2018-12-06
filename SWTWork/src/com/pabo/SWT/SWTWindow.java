package com.pabo.SWT;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;

public class SWTWindow {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlSwt = new Shell();
		shlSwt.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
			}
		});
		shlSwt.setSize(558, 517);
		shlSwt.setText("SWT");
		
		Button btnNewButton = new Button(shlSwt, SWT.NONE);
		btnNewButton.setBounds(124, 108, 80, 27);
		btnNewButton.setText("move me");

		shlSwt.open();
		shlSwt.layout();
		while (!shlSwt.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
