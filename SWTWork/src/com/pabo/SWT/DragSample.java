package com.pabo.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

public class DragSample {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		shell.setText("Drag and drop");
		
		GridLayout layout=new GridLayout();
		layout.numColumns=2;
		shell.setLayout(layout);
		
		//create left productTable
		final Button button=new Button(shell, SWT.BORDER);
		//button.setText("new Button");
		final Group group=new Group(shell, SWT.BORDER);
		Text text1=new Text(group, SWT.BORDER);
		text1.setText("Hello");
		DragSource dragSource=new DragSource(text1, DND.DROP_COPY|DND.DROP_MOVE);
		dragSource.setTransfer(new Transfer[] {TextTransfer.getInstance()});
		dragSource.addDragListener(new DragSourceListener() {
			
			@Override
			public void dragStart(DragSourceEvent arg0) {
				
				
			}
			
			@Override
			public void dragSetData(DragSourceEvent event) {
				if(TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data=text1.getText();
				}
				
			}
			
			@Override
			public void dragFinished(DragSourceEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		//create right shoppingTable
		final Text text=new Text(shell, SWT.BORDER);
		DropTarget dropTarget=new DropTarget(text, DND.DROP_DEFAULT|DND.DROP_COPY|DND.DROP_MOVE);
		dropTarget.addDropListener(new DropTargetListener() {
			
			@Override
			public void dropAccept(DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drop(DropTargetEvent arg0) {
				if(TextTransfer.getInstance().isSupportedType(arg0.currentDataType)) {
					text.setText((String)arg0.data);
				}
				
			}
			
			@Override
			public void dragOver(DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dragOperationChanged(DropTargetEvent arg0) {
				if(arg0.detail==DND.DROP_DEFAULT)
					arg0.detail=DND.DROP_COPY;
				
			}
			
			@Override
			public void dragLeave(DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dragEnter(DropTargetEvent arg0) {
				if(arg0.detail==DND.DROP_DEFAULT)
					arg0.detail=DND.DROP_COPY;
				
			}
		});
		shell.setSize(300,150);
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
