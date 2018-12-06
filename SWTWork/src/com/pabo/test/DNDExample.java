package com.pabo.test;



import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class DNDExample {

	public static void main(String[] args) {
		Shell shell = new Shell();
		shell.setBackground(new Color(null, 200, 200, 200));
		shell.setLayout(new GridLayout(2, false));

		// Create the tree and some tree items
		final Tree tree = new Tree(shell, SWT.NONE);
		TreeItem item1 = new TreeItem(tree, SWT.NONE);
		item1.setText("Item 1");
		TreeItem item2 = new TreeItem(tree, SWT.NONE);
		item2.setText("Item 2");
		
		//Create the drag source on the tree
		DragSource dSource=new DragSource(tree, DND.DROP_MOVE);
		dSource.setTransfer(new Transfer[] {TextTransfer.getInstance()});
		dSource.addDragListener(new DragSourceAdapter() {
			@Override
			public void dragSetData(DragSourceEvent event) {
				//Set the data to be the first selected item's text
				event.data=tree.getSelection()[0].getText();
			}
		});
		//Create the text field
		final Text text=new Text(shell,SWT.NONE);
		
		//Create the drop target on the text field
		DropTarget dropTarget=new DropTarget(text, DND.DROP_MOVE);
		dropTarget.setTransfer(new Transfer[] {TextTransfer.getInstance()});
		dropTarget.addDropListener(new DropTargetAdapter() {
			@Override
			public void drop(DropTargetEvent event) {
				//Set the text field's text to the text being dropped
				text.setText((String)event.data);
			}
		});
		shell.pack();
		shell.open();
		Display display=Display.getDefault();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
