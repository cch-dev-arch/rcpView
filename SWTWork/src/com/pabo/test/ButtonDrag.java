package com.pabo.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.pabo.uitl.DragAndDrop;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;

public class ButtonDrag {

	public static void main(String[] args) {
		Shell shell = new Shell();
		shell.setSize(366, 291);
		shell.setBackground(new Color(null, 200, 200, 200));
		shell.setLayout(new GridLayout(2, false));

		// Create the tree and some tree items
//		final Tree tree = new Tree(shell, SWT.NONE);
//		TreeItem item1 = new TreeItem(tree, SWT.NONE);
//		item1.setText("Item 1");
//		TreeItem item2 = new TreeItem(tree, SWT.NONE);
//		item2.setText("Item 2");
		final Button button=new Button(shell, SWT.NONE);
		button.setText("Hello");
		
		//Create the drag source on the tree
		DragSource dSource=new DragSource(button, DND.DROP_MOVE);
		dSource.setTransfer(new Transfer[] {TextTransfer.getInstance()});
		dSource.addDragListener(new DragSourceAdapter() {
			@Override
			public void dragSetData(DragSourceEvent event) {
				//Set the data to be the first selected item's text
				event.data=button.getText();
			}
		});
		//Create the text field
		Composite composite=new Composite(shell, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		composite.setLayout(null);
		final Text text=new Text(composite,SWT.NONE);
		text.setBounds(0, 0, 67, 17);
		
		//Create the drop target on the text field
		DropTarget dropTarget=new DropTarget(composite, DND.DROP_MOVE);
		dropTarget.setTransfer(new Transfer[] {TextTransfer.getInstance()});
		dropTarget.addDropListener(new DropTargetAdapter() {
			@Override
			public void drop(DropTargetEvent event) {
				//Set the text field's text to the text being dropped
				text.setText((String)event.data);
				Button button=new Button(composite, SWT.NONE);
				button.setText("test");
				composite.layout();
				for(Control control:composite.getChildren()) {
					System.out.println(control.getClass().toString());
				}
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
