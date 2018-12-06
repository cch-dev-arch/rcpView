package com.pabo.SWT;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class DragDropSample {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		shell.setText("Drag and drop");
		
		GridLayout layout=new GridLayout();
		layout.numColumns=2;
		shell.setLayout(layout);
		
		//create left productTable
		final Table productlist=createProductTable(shell);
		
		//create right shoppingTable
		final Table shoppingCart=createCartTable(shell);
		shell.pack();
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		

	}

	private static Table createCartTable(Composite parent) {
		Table table=new Table(parent, SWT.FULL_SELECTION|SWT.SINGLE);
		String[] heads= {"productName","nums","totalPrice"};
		for (int i = 0; i < heads.length; i++) {
			TableColumn column=new TableColumn(table, SWT.NONE);
			column.setText(heads[i]);
			
		}
		TableItem item=new TableItem(table, SWT.NONE);
		item.setText(new String[] {"","0","0"});
		
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		for (int i = 0; i < heads.length; i++) {
			table.getColumns()[i].pack();
		}
		
		return table;
	}

	private static Table createProductTable(Composite parent) {
		Table table=new Table(parent, SWT.FULL_SELECTION|SWT.SINGLE);
		String[] heads= {"productName","单位","price"};
		for (int i = 0; i < heads.length; i++) {
			TableColumn column=new TableColumn(table, SWT.NONE);
			column.setText(heads[i]);
			
		}
		TableItem item=new TableItem(table, SWT.NONE);
		item.setText(new String[] {"CPU","个","1200.00"});
		item=new TableItem(table, SWT.NONE);
		item.setText(new String[] {"ram","ge","255.00"});
		item=new TableItem(table, SWT.NONE);
		item.setText(new String[] {"computer","tai","9800.00"});
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		for (int i = 0; i < heads.length; i++) {
			table.getColumns()[i].pack();
		}
		
		return table;
	}

}
