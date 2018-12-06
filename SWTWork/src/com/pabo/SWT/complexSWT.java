package com.pabo.SWT;

import java.awt.Button;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class complexSWT {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		shell.setSize(200, 200);
		shell.setText("Shell");
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		Group group=new Group(shell, SWT.SHADOW_ETCHED_OUT);
		group.setText("This is group");
		group.setLayout(new FillLayout(SWT.VERTICAL));
		
		org.eclipse.swt.widgets.Button radio1=new org.eclipse.swt.widgets.Button(group, SWT.RADIO);
		radio1.setText("First Radio");
		
		org.eclipse.swt.widgets.Button radio2=new org.eclipse.swt.widgets.Button(group, SWT.RADIO);
		radio2.setText("Second Radio");
		
//		Group group1=new Group(shell, SWT.SHADOW_ETCHED_OUT);
//		group1.setText("This is group");
//		group1.setLayout(new FillLayout(SWT.RIGHT));
//		
//		org.eclipse.swt.widgets.Button radio3=new org.eclipse.swt.widgets.Button(group1, SWT.RADIO);
//		radio1.setText("First Radio");
//		
//		org.eclipse.swt.widgets.Button radio4=new org.eclipse.swt.widgets.Button(group1, SWT.RADIO);
//		radio2.setText("Second Radio");
		
		org.eclipse.swt.widgets.Button button=new org.eclipse.swt.widgets.Button(shell, SWT.PUSH);
		button.setText("Button");
		group.layout();
		shell.layout();
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		display.dispose();
		

	}

}
