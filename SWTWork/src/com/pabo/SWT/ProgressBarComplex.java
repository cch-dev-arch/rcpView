package com.pabo.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class ProgressBarComplex {
	static boolean bCancel=false;
	public static void main(String[] args) {
		Display display=new Display();
		final Shell shell=new Shell(display);
		shell.setText("ProgressBar");
		shell.setLayout(new GridLayout(2, false));
		//StartButton and CancelButton
		final Button start=new Button(shell, SWT.NONE);
		start.setText("START");
		Button cancel=new Button(shell, SWT.NONE);
		cancel.setText("CANCEL");
		//Create progressBar example
		final ProgressBar progressBar=new ProgressBar(shell, SWT.HORIZONTAL);
		GridData data=new GridData();
		data.horizontalSpan=2;
		data.grabExcessVerticalSpace=true;
		progressBar.setLayoutData(data);
		progressBar.setMaximum(100);
		progressBar.setMinimum(0);
		final int maximum=progressBar.getMaximum();
		final int minimus=progressBar.getMinimum();
		//startButton register listener
		start.addSelectionListener(new SelectionAdapter() {
			//click on startButton
			@Override
			public void widgetSelected(SelectionEvent e) {
				//set startButton unable
				start.setEnabled(false);
				//create thread that update progressBar
				Runnable runnable=new Runnable() {
					
					@Override
					public void run() {
						for (int i = minimus; i < maximum; i++) {
							try {
								Thread.sleep(100);
							} catch (Exception e2) {
								// TODO: handle exception
							}
							shell.getDisplay().asyncExec(new Runnable() {
								
								@Override
								public void run() {
									if(progressBar.isDisposed()) {
										return;
									}
									if(bCancel) {
										progressBar.setSelection(0);
									}
									progressBar.setSelection(progressBar.getSelection()+1);
								}
							});
							//if cancel thread,finish this loop
							if(bCancel) {
								bCancel=false;
								break;
							}
						}
					}
				};
				//start this thread
				new Thread(runnable).start();
				
				
			}
			
		
		});
		//cancelButton register listener
		cancel.addSelectionListener(new SelectionAdapter() {
			//click on cancel
			@Override
			public void widgetSelected(SelectionEvent e) {
				//if the thread is running,cancel it and enable startButton
				if(!bCancel) {
					bCancel=true;
					start.setEnabled(true);
					
				}
			}
		});
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
