package com.pabo.SWT;



import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class TabFolderSample {

	public static void main(String[] args) {
		Display display=new Display();
		Shell shell=new Shell(display);//创建该Display类的Shell实例
		shell.setText("TabFolderSample");
		
		final TabFolder tabFolder=new TabFolder(shell, SWT.TOP);
		//tabFolder.setLayout(new FillLayout());
		tabFolder.setLayout(new FillLayout());
		for (int i = 0; i < 4; i++) {
			TabItem item=new TabItem(tabFolder, SWT.NONE);
			item.setText("选项卡"+i);
			Text text=new Text(tabFolder, SWT.MULTI);
			text.setText("This is the page of"+i);
			item.setControl(text);
		}
		tabFolder.pack();
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
