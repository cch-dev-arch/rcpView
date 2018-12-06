package com.pabo.SWT;

import java.awt.Button;

import org.eclipse.swt.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloWorld {

	public static void main(String[] args) {
		//1.初始化窗口
		Display display=new Display();
		Shell shell=new Shell(display);//创建该Display类的Shell实例
		shell.setText("SWT");
		//向Shell中添加Widget控件
		org.eclipse.swt.widgets.Button button=new org.eclipse.swt.widgets.Button(shell, SWT.CENTER);
		button.setText("Welcome to the world 0f SWT");
		button.pack();
		//GUI调用
		shell.pack();//调整布局
		shell.open();//打开窗口
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		//销毁Display实例,释放创建 Display时所获取的内存资源,断开与本地操作系统 的 连接
		display.dispose();

	}

}
