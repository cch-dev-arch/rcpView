package com.pabo.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class TabExample extends Composite {

	public TabExample(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		
		TabItem tbtmTbtmtabitem = new TabItem(tabFolder, SWT.NONE);
		tbtmTbtmtabitem.setText("tbtmTabitem");
	}

}
