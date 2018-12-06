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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.pabo.uitl.DragAndDrop;

public class DragDropExample {
	// static Button button1=null;
	public static void main(String[] args) {
		Shell shell = new Shell();
		shell.setSize(500, 500);
		shell.setBackground(new Color(null, 200, 200, 200));
		shell.setLayout(new GridLayout(2, false));
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout());

		final Button button = new Button(composite, SWT.NONE);
		final Button tnbutton = new Button(composite, SWT.NONE);
		final Label	 label=new Label(composite, SWT.NONE);
		label.setText("label");
		button.setText("Hello");
		tnbutton.setText("Button");
		for (Control control : composite.getChildren()) {
			control.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					if (DragAndDrop.dragSource != null) {
						if (!DragAndDrop.dragSource.isDisposed()) {
							DragAndDrop.dragSource.dispose();
						}
					}
					DragAndDrop.dragSource = new DragSource(control, DND.DROP_MOVE | DND.DROP_COPY);
					DragAndDrop.Drag(control);
				}
				@Override
				public void mouseDown(MouseEvent e) {
					if (DragAndDrop.dragSource != null) {
						if (!DragAndDrop.dragSource.isDisposed()) {
							DragAndDrop.dragSource.dispose();
						}
					}
					DragAndDrop.dragSource = new DragSource(control, DND.DROP_MOVE | DND.DROP_COPY);
					DragAndDrop.Drag(control);
				}
			});
		}
		// Create the drag source on the tree
		final Composite composite1 = new Composite(shell, SWT.BORDER);
		composite1.setLayout(null);
		composite1.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Create the drop Source on the composite
		DragAndDrop.dropTarget = new DropTarget(composite1, DND.DROP_MOVE);
		DragAndDrop.dropTarget.setTransfer(new Transfer[] { TextTransfer.getInstance() });
		DragAndDrop.dropTarget.addDropListener(new DropTargetAdapter() {
			@Override
			public void drop(DropTargetEvent event) {

				try {
					// Button button1 = new Button(composite1, SWT.PUSH);
					// button1.setText("Hello");
					// button1.setBounds(event.x,event.y,50,40);

					//System.out.println(event.x + "," + event.y);
					Class<?> controlClass = Class.forName((String) event.data);
					
					Method method=controlClass.getMethod("setText", String.class);
					Object object =controlClass.getConstructor(Composite.class, int.class).newInstance(composite1,
							SWT.PUSH);
					composite1.layout();
					method.invoke(object, "Text");
					method=controlClass.getMethod("setBounds", int.class,int.class,int.class,int.class);
					method.invoke(object, event.x,event.y,60,60);
					//System.out.println(object.getClass());
					
					for(Control composite2:composite1.getChildren()) {
						System.out.println(composite2.getLocation().x+","+composite2.getLocation().y);
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		shell.pack();
		shell.open();
		Display display = Display.getDefault();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
