package com.pabo.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class MouseEventSample {
	private Shell shell;
	private Button button;
	private Group group;
	private Point startPoint;
	private MoveButtonListener listener;

	public MouseEventSample(Display display) {
		shell = new Shell(display);
		shell.setText("Mouse Event");
		shell.setLayout(new FillLayout());
		button = new Button(shell, SWT.NONE);
		//button.setLayoutData(new FillLayout());
		group=new Group(shell, SWT.BORDER);
		group.setText("Container");
		group.setSize(100, 150);
		//button.pack();
		button.setBounds(5, 5, 50, 25);
		button.setText("move me");
		listener = new MoveButtonListener();
		button.addMouseListener(listener);
		button.addMouseTrackListener(listener);
		shell.setSize(200, 150);
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public MoveButtonListener getListener() {
		return listener;
	}

	public void setListener(MoveButtonListener listener) {
		this.listener = listener;
	}

	public class MoveButtonListener implements MouseListener, MouseMoveListener, MouseTrackListener {
		@Override
		public void mouseEnter(MouseEvent arg0) {
			System.out.println("mouse enter");

		}

		@Override
		public void mouseExit(MouseEvent arg0) {
			System.out.println("mouse exit");

		}

		@Override
		public void mouseHover(MouseEvent arg0) {
			System.out.println("mouse hover");
		}

		@Override
		public void mouseMove(MouseEvent e) {
			Point convertPoint = Display.getCurrent().map(button, shell, e.x, e.y);
			Rectangle current = button.getBounds();
			button.setBounds(convertPoint.x, convertPoint.y, current.width, current.height);

		}

		@Override
		public void mouseDoubleClick(MouseEvent arg0) {
			System.out.println("mouse doubleClick");

		}

		@Override
		public void mouseDown(MouseEvent e) {
			startPoint=Display.getCurrent().map(button, shell, e.x,e.y);
			button.addMouseMoveListener(listener);
			

		}

		@Override
		public void mouseUp(MouseEvent e) {
			Rectangle current=button.getBounds();
			Point convertPoint = Display.getCurrent().map(button, shell, e.x, e.y);
			Point  groupPoint=group.getLocation();
			
			if(convertPoint.x>groupPoint.x&&convertPoint.y>=groupPoint.y) {
				
			}
			button.setBounds(startPoint.x,startPoint.y, current.width, current.height);
			
			button.removeMouseMoveListener(listener);

		}

	}

	public static void main(String[] args) {
		Display display=Display.getDefault();
		MouseEventSample sample=new MouseEventSample(display);
		sample.getShell().open();
		while(!sample.getShell().isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
