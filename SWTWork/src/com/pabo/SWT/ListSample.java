package com.pabo.SWT;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;


public class ListSample {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);
		shell.setText("List Example");
		
		String[] itemLeft=new String[20];//定义保存左侧列表框中的数据
		String[] itemRight=new String[0];//定义保存右侧列表框中的数据
		//初始化左侧字符串数组
		for (int i = 0; i < itemLeft.length; i++) {
			itemLeft[i]="item"+i;
			
		}
		
		//定义左侧列表框,可选择多个并且带有垂直滚动条
		final List left=new List(shell, SWT.MULTI|SWT.V_SCROLL);
		left.setBounds(10,10,100,180);//设置位置和大小
		left.setItems(itemLeft);//设置选项数据
		left.setToolTipText("please select items");
		
		//定义右侧列表框，可选择多个并且带有垂直滚动条
		final List right=new List(shell, SWT.MULTI|SWT.V_SCROLL);
		right.setBounds(170,10,100,180);//设置位置和大小
		right.setItems(itemRight);//设置选项数据
		right.setToolTipText("Items selected");
		
		//创建事件监听类，为内部类
		SelectionAdapter listener=new SelectionAdapter() {
			//按钮单击事件的处理方法
			public void widgetSelected(SelectionEvent e) {
				//取得触发事件的控件对象
				Button button=(Button)e.widget;
				if(button.getText().equals(">")) {
					verifyValue(left.getSelection(), left, right);
				}else if (button.getText().equals(">>")) {
					verifyValue(left.getItems(), left, right);
				}else if (button.getText().equals("<")) {
					verifyValue(right.getSelection(), right, left);
				}else if (button.getText().equals("<<")) {
					verifyValue(right.getItems(), right, left);
				}else if (button.getText().equals("上")) {
					//获得当前选中选项的 索引值
					int index=right.getSelectionIndex();
					if(index<=0) {
						return;
					}
					String currentValue=right.getItem(index);
					right.setItem(index, right.getItem(index-1));
					right.setItem(index-1, currentValue);
					
					right.setSelection(index-1);
				}else if (button.getText().equals("下")) {
					int index=right.getSelectionIndex();
					//System.out.println(index);
					if(index<0||index>=right.getItemCount()-1) {
						return;
					}
					String currentValue=right.getItem(index);
					right.setItem(index, right.getItem(index+1));
					right.setItem(index+1, currentValue);
					
					right.setSelection(index+1);
				}
			}
		//改变左右列表值
			public void verifyValue(String[] select,List from,List to) {
				//循环所有选中的值
				for (int i = 0; i < select.length; i++) {
					//从一个列表 中移出该选项值
					from.remove(select[i]);
					//添加到另一个列表 
					to.add(select[i]);
				}
			}
		};
		
		Button  bt1=new Button(shell, SWT.NONE);
		bt1.setText(">");
		bt1.setBounds(130, 20, 25, 20);
		//为按钮注册事件
		bt1.addSelectionListener(listener);
		
		Button  bt2=new Button(shell, SWT.NONE);
		bt2.setText(">>");
		bt2.setBounds(130, 55, 25, 20);
		//为按钮注册事件
		bt2.addSelectionListener(listener);
		
		Button  bt3=new Button(shell, SWT.NONE);
		bt3.setText("<");
		bt3.setBounds(130, 90, 25, 20);
		//为按钮注册事件
		bt3.addSelectionListener(listener);
		
		Button  bt4=new Button(shell, SWT.NONE);
		bt4.setText("<<");
		bt4.setBounds(130, 125, 25, 20);
		//为按钮注册事件
		bt4.addSelectionListener(listener);
		
		Button  bt5=new Button(shell, SWT.NONE);
		bt5.setText("上");
		bt5.setBounds(300, 70, 25, 20);
		//为按钮注册事件
		bt5.addSelectionListener(listener);
		
		Button  bt6=new Button(shell, SWT.NONE);
		bt6.setText("下");
		bt6.setBounds(300, 105, 25, 20);
		//为按钮注册事件
		bt6.addSelectionListener(listener);
		
		shell.setSize(350,250);
		//shell.pack();//调整布局
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
