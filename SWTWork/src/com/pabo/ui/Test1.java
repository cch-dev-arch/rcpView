package com.pabo.ui;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class Test1 extends AbstractUI {
	private Table table;
	private Tree tree;

	@Override
	public void todo(Shell shell) {
		TabFolder tabFolder=new TabFolder(shell, SWT.BORDER);
		
		TabItem tabItem=new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("第一页");
		
		Composite composite=new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(composite);
		
		GridLayout layout=new GridLayout();
		layout.numColumns=1;
		composite.setLayout(layout);
		Group treeGroup=new Group(composite, SWT.NONE);
		treeGroup.setText("Tree");
		
		GridData gridData=new GridData(GridData.FILL_BOTH);
		gridData.heightHint=50;
		treeGroup.setLayoutData(gridData);
		treeGroup.setLayout(new GridLayout(1, false));
		
		{
			tree=new Tree(treeGroup, SWT.SINGLE);
			tree.setLayoutData(new GridData(GridData.FILL_BOTH));
			
			TreeItem stu=new TreeItem(tree, SWT.NONE); 
			stu.setText("pabo");
			{
				TreeItem info=new TreeItem(stu, SWT.NONE);
				info.setText("age:25");
				
				new TreeItem(stu, SWT.NONE).setText("name:pabo");
			}
			
			stu=new TreeItem(tree, SWT.NONE);
			stu.setText("hello");
			{
				new TreeItem(stu, SWT.NONE).setText("age:24");
				new TreeItem(stu, SWT.NONE).setText("tel:678175");
			}
			tree.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					new TableItem(table, SWT.NONE).setText(new String[] {tree.getSelection()[0].toString(),tree.getSelection()[0].getText()});
				}
			});
		}
		
		Group tableGroup=new Group(composite, SWT.NONE);
		tableGroup.setText("table");
		GridData gd=new GridData(GridData.FILL_BOTH);
		gd.heightHint=20;
		tableGroup.setLayoutData(gd);
		tableGroup.setLayout(new GridLayout(1, false));
		{
			//创建一个单选的，有边界的，一行全选的表格
			table =new Table(tableGroup, SWT.SINGLE|SWT.BORDER|SWT.FULL_SELECTION);
			table.setHeaderVisible(true);//设置表头可见
			table.setLinesVisible(true);//设置线条可见
			table.setLayoutData(new GridData(GridData.FILL_BOTH));
			
			TableColumn tableColumn=new TableColumn(table, SWT.NULL);
			tableColumn.setText("Tree Item");
			tableColumn.pack();
			tableColumn.setWidth(150);
			
			tableColumn=new TableColumn(table, SWT.NULL);
			tableColumn.setText("Parent");
			tableColumn.pack();
			tableColumn.setWidth(150);
		}

	}

	public static void main(String[] args) {
		new Test1().run();

	}

}
