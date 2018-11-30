package org.pabo.hellorcp;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	@Override	
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.setFixed(false);
		layout.addView(LeftView.ID, layout.LEFT, 0.4f, layout.getEditorArea());
		layout.addView(NameTable.ID, layout.LEFT, 0.2f, layout.getEditorArea());
		layout.addView(RightView.ID,layout.RIGHT,0.5f,layout.getEditorArea());
		layout.getViewLayout(LeftView.ID).setCloseable(false);
		layout.getViewLayout(RightView.ID).setCloseable(false);
		layout.getViewLayout(NameTable.ID).setCloseable(false);
	}
}
