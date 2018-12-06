package com.pabo.action;

import java.lang.Override;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.ApplicationWindow;

public class ExitAction extends Action {
	ApplicationWindow window;
	public ExitAction(ApplicationWindow m) {
		window=m;
		setText("Exit(&W)");
		setToolTipText("Exit the application");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		window.close();
	}
}
