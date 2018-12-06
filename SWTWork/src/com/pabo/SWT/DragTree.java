package com.pabo.SWT;

import java.io.File;

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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class DragTree {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		
		shell.setLayout(new FillLayout());
		//Create a Tree Object
		final Tree tree=createFolderTree(shell);
		DragSource dragSource=new DragSource(tree, DND.DROP_MOVE|DND.DROP_COPY);
		//设置传输的数据为文本型String
		dragSource.setTransfer(new Transfer[] {TextTransfer.getInstance()});
		
		//注册拖放源事件处理
		dragSource.addDragListener(new DragSourceListener() {
			
			@Override
			public void dragStart(DragSourceEvent arg0) {
				if (tree.getSelectionCount()==0) {
					arg0.doit=false;
				}
				
			}
			
			@Override
			public void dragSetData(DragSourceEvent arg0) {
				if (TextTransfer.getInstance().isSupportedType(arg0.dataType)) {
					arg0.data=tree.getSelection()[0].getText();
				}
				
			}
			
			@Override
			public void dragFinished(DragSourceEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//定义拖放目标对象
		DropTarget dropTarget=new DropTarget(tree, DND.DROP_MOVE|DND.DROP_DEFAULT|DND.DROP_COPY);
		dropTarget.setTransfer(new Transfer[] {TextTransfer.getInstance()});
		//注册目标对象的 事件
		dropTarget.addDropListener(new DropTargetListener() {
			
			@Override
			public void dropAccept(DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drop(DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.item==null) {
					return;
				}
				TreeItem eventItem=(TreeItem) arg0.item;
				if(TextTransfer.getInstance().isSupportedType(arg0.currentDataType)) {
					//获得数据源设置的字符串
					String string=(String) arg0.data;
					//在当前位置插入一个节点
					TreeItem newItem=null;
					if(eventItem.getParentItem()==null) {
						newItem=new TreeItem(eventItem.getParent(), SWT.NONE);
					}else {
						newItem=new TreeItem(eventItem.getParentItem(), SWT.NONE);
					}
					newItem.setText(string);
				}
			}
			
			@Override
			public void dragOver(DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				arg0.feedback=DND.FEEDBACK_EXPAND|DND.FEEDBACK_SELECT;
			}
			
			@Override
			public void dragOperationChanged(DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.detail==DND.DROP_DEFAULT) {
					arg0.detail=DND.DROP_COPY;
				}
			}
			
			@Override
			public void dragLeave(DropTargetEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dragEnter(DropTargetEvent arg0) {
				if(arg0.detail==DND.DROP_DEFAULT) {
					arg0.detail=DND.DROP_COPY;
				}
				
			}
		});
		shell.setSize(300, 150);
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private static Tree createFolderTree(Composite parent) {
		Tree tree=new Tree(parent, SWT.BORDER|SWT.SINGLE);
		File root=new File("E:\\杂物");
		File[] files=root.listFiles();
		for (int i = 0; i < files.length; i++) {
			TreeItem item=new TreeItem(tree, SWT.NONE);
			item.setText(files[i].getName());
			if(files[i].isDirectory()) {
				setDirectory(files[i],item);
			}
		}
		
		return tree;
	}

	private static void setDirectory(File file,TreeItem parent) {
		File[] files=file.listFiles();
		for (int i = 0; i < files.length; i++) {
			TreeItem item=new TreeItem(parent, SWT.NONE);
			item.setText(files[i].getName());
			if(files[i].isDirectory()) {
				setDirectory(files[i], item);
			}
		}
		
	}

}
