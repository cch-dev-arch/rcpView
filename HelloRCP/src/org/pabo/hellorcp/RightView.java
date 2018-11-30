package org.pabo.hellorcp;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.RowLayout;

public class RightView extends ViewPart {

	public static final String ID = "org.pabo.hellorcp.RightView"; //$NON-NLS-1$

	public RightView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.VERTICAL));
		Composite containerView=new Composite(container, SWT.BORDER);
		containerView.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Group grpHello = new Group(containerView, SWT.NONE);
		grpHello.setText("Hello");
		Composite widgetView=new Composite(container, SWT.BORDER);
		widgetView.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Button btnButton = new Button(widgetView, SWT.NONE);
		btnButton.setText("Button");

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
