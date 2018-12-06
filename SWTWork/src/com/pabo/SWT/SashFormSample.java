package com.pabo.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SashFormSample {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		shell.setText("SashForm");
		
		//创建窗框对象,水平 排列 
		SashForm form=new SashForm(shell, SWT.HORIZONTAL|SWT.BORDER);
		form.setLayout(new FillLayout());
		//创建窗口1的面板
		Composite child1=new Composite(form, SWT.NONE);
		child1.setLayout(new FillLayout());
		new Text(child1, SWT.MULTI).setText("Windows Form 1");
		//创建窗口2
		Composite child2=new Composite(form, SWT.NONE);
		child2.setLayout(new FillLayout());
		new Text(child2, SWT.MULTI).setText("Windows Form 2");
		
		//初始状态两个面板所占的比例
		form.setWeights(new int[] {30,70});
		//form.pack();
		form.setSize(300, 200);
		//shell.setSize(300,200);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		
		
	}

}
