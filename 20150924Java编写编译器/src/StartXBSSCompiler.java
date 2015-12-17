import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.xbss.compiler.view.MainView;

/**
 * @author XBSS
 * @title 启动xbss编译器
 * @version 1.0 
 * @date 2015-09-24
 * @
 */
public class StartXBSSCompiler{
	
	private static final long serialVersionUID = 1L;
	
	/*if (new File("resources/img/general/AppIcon.png"))
		this.setIconImage(toolkit.getImage(systemPropertiesMap.get("appIcon")));*/
	//
	ImageIcon img = new ImageIcon("resources/img/general/Adm.png");
    JLabel background = new JLabel(img);
    JFrame admFrame = new JFrame();
    //
    JLabel user = new JLabel("用户名：");
    JTextField userInput = new JTextField(20);
    JLabel passWord = new JLabel("口    令：");
    JPasswordField passWordIn = new JPasswordField(20);
    //
    String choice = "";
    JPanel panel = new JPanel();
    /*ButtonGroup selectGroup = new ButtonGroup();
    JRadioButton train,plane;*/
    //
    JButton login = new JButton("登陆");
    JButton exit = new JButton("退出");

    public StartXBSSCompiler() {
    	Toolkit toolkit = admFrame.getToolkit();
    	if (new File("resources/img/general/AppIcon.png").exists())
    		admFrame.setIconImage(toolkit.getImage("resources/img/general/AppIcon.png"));
        admFrame.setLayout(null);
        admFrame.setTitle("XBSS编译器 管理员入口");
        admFrame.setSize(img.getIconWidth(), img.getIconHeight() + 20);
        /*admFrame.setSize(500, 320);*/
       
        admFrame.setLocationRelativeTo(null);
        admFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 信息获取
        panel.setLayout(new GridLayout(2, 2, 20, 20));
        panel.setLocation(admFrame.getWidth()-200, admFrame.getHeight()-200);
        panel.setBackground(new Color(234,236,235));
        panel.add(user);
        user.setHorizontalAlignment(JTextField.RIGHT);
        passWord.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(userInput);
        panel.add(passWord);
        panel.add(passWordIn);

        /*panel.setBounds(40, 50, 250, 60);*/
        panel.setBounds(400, 280, 250, 60);
        // 单选框按钮
       /* JPanel select = new JPanel();
        select.setLayout(new GridLayout(1,2,10,10));
        select.setBackground(new Color(234, 235, 236));
        selectGroup.add(train = new JRadioButton("火车"));
        train.setActionCommand("train");
        train.addActionListener(new SelectActionListener());
        selectGroup.add(plane = new JRadioButton("飞机"));
        plane.setActionCommand("plane");
        plane.addActionListener(new SelectActionListener());
        select.add(train);
        select.add(plane);
        select.setBounds(470, 350, 200, 40);
        admFrame.add(select);*/
        // 功能按钮
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(new Color(234, 235, 236));
        tempPanel.add(login);
        tempPanel.add(exit);
        tempPanel.setBounds(450, 400, 200, 40);
        admFrame.add(panel);
        admFrame.add(tempPanel);
        admFrame.add(background);
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        admFrame.setVisible(true);
        admFrame.setResizable(false);
        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        login.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (userInput.getText().trim().equals("") || passWordIn.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "请输入用户名或口令！",
                            "TS 信息不完整", JOptionPane.WARNING_MESSAGE);
                } else if (userInput.getText().equals("admin") && passWordIn.getText().equals("123456")) {
                	
                	// 关闭登陆窗口 显示功能窗口
                	admFrame.dispose();
                	MainView mainView = new MainView();
                	mainView.setVisible(true);
                	
                	/*if (choice.equals("train")) {
                		// 关闭主要窗口
                   	 	admFrame.dispose();
                		AdmMainWindowTrain amw = new AdmMainWindowTrain();
                		amw.setVisible(true);
					} else if (choice.equals("plane")) {
						// 关闭主要窗口
	                	 admFrame.dispose();
						AdmMainWindowPlane amw = new AdmMainWindowPlane();
						amw.setVisible(true);
					} else {
						System.out.println("DEBUG--> 单选框出错");
						JOptionPane.showMessageDialog(null, "您还没有选择交通工具！",
	                            "TS 输入信息出错", JOptionPane.ERROR_MESSAGE);
					}*/
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或口令错误，\n请重新输入！",
                            "TS 输入信息出错", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
    }
    /*class SelectActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// 得到的选择
			System.out.println(selectGroup.getSelection().getActionCommand());
			choice = selectGroup.getSelection().getActionCommand().trim();
		}
    }*/

    public static void main(String[] args) {
        StartXBSSCompiler af = new StartXBSSCompiler();

    }
	
	
	// 配置文件 
	static Properties systemProperties;
	static Map<String, String>systemPropertiesMap = new HashMap<String, String>();
	public static void jmain(String[] args) {
		// 创建iframe
		//System.out.println(new File("resources/img/mainview/background.jpg").exists());
		// 打开开始界面
		MainView mainView = new MainView();
	}

}
