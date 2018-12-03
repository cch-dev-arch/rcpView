package org.pabo.smartboxplugin;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.pabo.smartboxplugin.ui.SmartBoxUI;
import org.pabo.smartboxplugin.ui.SmartBoxView;

public class Perspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.setFixed(true);
		String editorArea=layout.getEditorArea();
		layout.addView(SmartBoxView.ID, IPageLayout.LEFT,1.0f,editorArea);
	}

}
