package org.pabo.smartboxplugin.component;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class RightComposite extends Composite{

	public RightComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.VERTICAL));
		Composite containerComposite=new ContainerComposite(this,SWT.BORDER);
		Composite componentComposite=new componentComposite(this, SWT.BORDER);
	}
	
}
