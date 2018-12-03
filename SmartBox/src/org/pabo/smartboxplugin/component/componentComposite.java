package org.pabo.smartboxplugin.component;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class componentComposite extends Composite {

	public componentComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		Composite composite=new Composite(this, style);
	}

}
