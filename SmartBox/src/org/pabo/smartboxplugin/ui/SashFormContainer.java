package org.pabo.smartboxplugin.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.pabo.smartboxplugin.component.EditComponent;
import org.pabo.smartboxplugin.component.NameTableComponent;
import org.pabo.smartboxplugin.component.RightComposite;

public class SashFormContainer extends SashForm {

	public SashFormContainer(Composite parent, int style) {
		super(parent, style);
		Composite leftView=new EditComponent(this, SWT.NONE);
		Composite nameTable=new NameTableComponent(this, SWT.NONE);
		Composite rightComposite=new RightComposite(this, SWT.NONE);
		this.setWeights(new int[] {2,1,2});
		// TODO Auto-generated constructor stub
	}

}
