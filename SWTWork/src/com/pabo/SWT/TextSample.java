package com.pabo.SWT;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextSample {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);//创建该Display类的Shell实例
		shell.setText("SWT");
		final Text content=new Text(shell, SWT.WRAP|SWT.V_SCROLL);
		content.setBounds(5,5,325,200);
		
		Button selectAll=new Button(shell, SWT.NONE);
		selectAll.setText("全选");
		selectAll.setBounds(5,255,75,25);
		selectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				content.selectAll();
			}
		});
		
		Button cancel=new Button(shell, SWT.NONE);
		cancel.setText("取消全选");
		cancel.setBounds(90,225,75,25);
		cancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if(content.getSelectionCount()>0) {
					content.clearSelection();
				}
				
			}
		});
		
		Button copy=new Button(shell, SWT.NONE);
		copy.setText("复制");
		copy.setBounds(175,225,75,25);
		copy.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				content.copy();
				
			}
		});
		
		Button paste=new Button(shell, SWT.NONE);
		paste.setText("粘贴");
		paste.setBounds(260,225,75,25);
		paste.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				content.paste();
				
			}
		});
		
		Button deleteAll=new Button(shell, SWT.NONE);
		deleteAll.setText("清除全部");
		deleteAll.setBounds(175,260,75,25);
		deleteAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				content.selectAll();
				content.cut();
				
			}
		});
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
