package com.pabo.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class EventDemo {

	private Shell _shell;
	public EventDemo() {
		Display display=new Display();
		Shell shell=new Shell(display,SWT.SHELL_TRIM);
		setShell(shell);
		RowLayout layout=new RowLayout();
		shell.setLayout(layout);
		shell.setText("Event demo");
		
		Button button=new Button(shell, SWT.PUSH|SWT.CENTER);
		button.setText("Click me!!!");
		
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				handleselectionEvent();
			}
			
			private void handleselectionEvent() {
				MessageBox dialog=new MessageBox(getShell(),SWT.OK|SWT.ICON_INFORMATION);
				
				dialog.setText("Hello");
				dialog.setMessage("Hello,world1");
				dialog.open();
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		shell.setBounds(200,300,100,100);
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public static void main(String[] args) {
		EventDemo eventDemo=new EventDemo();
		
	}
	public Shell getShell() {
		return _shell;
	}
	public void setShell(Shell _shell) {
		this._shell = _shell;
	}
	

}
