package view;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import com.view.action.Action;

/**
 * 界面设置
 * @author rain
 *	2012.4.15
 */
public class CompileView extends JFrame{

	private static JTextArea ta1;
	private static JTextArea ta2;
	private JButton jb=new JButton("词法分析"); 
	private JButton jb1=new JButton("打开文件");
	private JButton jb2=new JButton("语法分析");
	private JLabel  jl1=new JLabel("输入源代码：");
	private JLabel  jl2=new JLabel("分析结果：");
//	String gj[]={"else","if","int","return","void","while"};
//	String fh[]={"+","-","*","/","<","<=",">",">=","==","!=","=",";",",","(",")","[","]","{","}"};
	public CompileView() {
			
			super("编译原理");  
			this.UISet();        //设置主题
			this.setSize(600,448);
			this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-this.getWidth())/2,
					(Toolkit.getDefaultToolkit().getScreenSize().height-this.getHeight())/2);     //设置位置在屏幕中间
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLayout(null);
			JPanel jp =new JPanel();
			JPanel jp1 =new JPanel();
			
			//对jp和jp1进行初始化（start）
			
			jp.setSize(300, 400);
			jp1.setSize(300, 400);
			jp.setLocation(0, 0);
			jp1.setLocation(300, 0);
			jp.setLayout(null);
			jp1.setLayout(null);
			
			//对jp和jp1进行初始化（end）
			
			//对文本框ta和ta1进行初始化并加入滚动条（start）
			ta1=new JTextArea(20,30);
			ta2=new JTextArea(20,30);
			ta2.setEditable(false);
		    JScrollPane scrol1=new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    JScrollPane scrol2=new JScrollPane(ta2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    scrol1.setSize(260, 310);
		    scrol1.setLocation(18, 40);
		    scrol2.setSize(260, 310);
		    scrol2.setLocation(18, 40);
	        jp.add(scrol1);  
		    jp1.add(scrol2);
		  //对文本框ta和ta1进行初始化并加入滚动条（end）
		    
		    //对按钮jb,jb1和对提示框进行设置（start）
		    jb.setBounds(25, 370, 100, 25);
		    jb1.setBounds(80, 370, 100, 25);
		    jb2.setBounds(170, 370, 100, 25);
		    jl1.setFont(new Font("楷书",Font.BOLD,12));
		    jl1.setSize(140, 25);
		    jl1.setLocation(0, 0);
		    jl2.setFont(new Font("楷书",Font.BOLD,12));
		    jl2.setSize(140, 25);
		    jl2.setLocation(0, 0);
		    //对按钮jb,jb1和对提示框进行设置（end）
		    
		    //添加panel到JPanel(start)
		    jp.add(jb1);
		    jp.add(jl1);
			jp1.add(jb);
			jp1.add(jb2);
			jp1.add(jl2);
			this.add(jp);
			this.add(jp1);
			//添加panel到JPanel(end)
			
			//对按钮jb,jb1,jb2设置监听（start）
			jb.setActionCommand("start");
			jb1.setActionCommand("openfile");
			jb2.setActionCommand("startGrammer");
			jb.addActionListener(new Action());
			jb1.addActionListener(new Action());
			jb2.addActionListener(new Action());
			//对按钮jb,jb1,jb2设置监听（end）
			
			this.setResizable(true);
			this.setVisible(true);
	}
	
	private void UISet()
	{
		int i=1;
		 try {  
			 
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//当前系统风格  
		  
		        switch (i) {  
                    case 0:  
                        MetalLookAndFeel.setCurrentTheme(new OceanTheme());//海洋场景  
                        i = 1;  
                        break;  
                    case 1:  
                        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());//默认场景  
                        i = 0;  
                        break;  
		        }//设置主题场景  
		  
		        SwingUtilities.updateComponentTreeUI(this);//更新外观，如果以上代码直接放在main中，此行可以不加  
		  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
	}

	public static String getString() {
		String temp=ta1.getText();
		return temp;
	}

	public static void setText(String text) {
		ta2.setText(text);
	}
	
	public static void setTa1Text(String text)
	{
		ta1.setText(text);
	}
	
	public static void main(String[] args) {
		
		new CompileView();
	}
}
