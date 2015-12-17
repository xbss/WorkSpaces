package com.xbss.compiler.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;



public class MainView extends JFrame {
	
	// 通用文件存取
	static Map<String, Object> generalMap = new HashMap<String, Object>();
	// 配置文件 
	String filename = "";
	static Properties systemProperties;
	static Map<String, String>systemPropertiesMap = new HashMap<String, String>();
	private static final long serialVersionUID = 1L;
	// 左边的文件读入框
	JTextArea fileReadertTextArea;
	// 右边的taken框字符串
	JTextArea fileTokentTextArea;
	// 右下边的错误信息打印框
	JTextArea infoTextArea;
	public MainView (){
		// 初始化系统参数
		GetSystemProperties();
		
		// 设置窗口参数
		SetFrameConfig();
		// 设置背景图标
		//SetBGImage(systemPropertiesMap.get("mainBackground"));
		
		// 设置菜单按钮 
		SetMenu();
		
		// 设置功能按钮
		
		//paintComponent(this.getGraphics());
		
		
		
		// 添加读取文件显示框
		AddFileOutViewJPanel();
		
		// 增加符号表的显示
		AddChartPanel();
		setVisible(true);
	}
	/** 
	 * @title 重写 paintComponent方法，实现背景图片的设置
	 */
	protected void paintComponent(Graphics g){
		super.paintComponents(g);
		if(new File(systemPropertiesMap.get("mainBackground")).exists()){
			try {
				BufferedImage image = ImageIO.read(MainView.class.getResource("background.jpg"));
				System.out.println(image);
				ImageIcon image1 = new ImageIcon(getClass().getResource("background.jpg"));
				image1.setImage(image1.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
				image1.paintIcon(this, g, 0, 0);
				//g.drawImage(image1.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @title 读取XML参数
	 */
	public int GetSystemProperties(){
		systemProperties = new Properties();
		InputStream inputStream = MainView.class.getClassLoader().getResourceAsStream("com/xbss/compiler/config/system.properties");
		if (inputStream != null) {
			try {
				systemProperties.load(inputStream);
				Set<Object> set = systemProperties.keySet();
				for (Object object : set) {
					String value = systemProperties.getProperty(object.toString()).toString();
					systemPropertiesMap.put(object.toString(), value);
				}
				// 打印参数数据
				//System.out.println(systemPropertiesMap);
			} catch (IOException e) {
				System.out.println("读取系统参数错误");
				e.printStackTrace();
			}
		} else {
			System.out.println("系统配置路径出错");
		}
		return 0;
	}
	
	/**
	 * @title 设置窗口具体参数
	 */
	public int SetFrameConfig(){
		setLayout(new GridLayout(1, 2));
		// 该窗口的工具包
		Toolkit toolkit = this.getToolkit();
		if (new File(systemPropertiesMap.get("appIcon")).exists())
			setIconImage(toolkit.getImage(systemPropertiesMap.get("appIcon")));
		
		// 设置窗口的具体参数
		setTitle("XBSS ' Java编译器");
		setSize(800, 600);
		setLocationRelativeTo(null);
		

		//  设置关闭按钮
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		return 0;
	}
	
	/**
	 * @title 设置背景图标
	 */
	public void SetBGImage(String path){
		ImageIcon background = null;
		// 判断图片的存在情况
		if (new File(systemPropertiesMap.get("mainBackground")).exists())
			 background = new ImageIcon(path);
		JLabel labelBackground = new JLabel(background);
		labelBackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		
		
		add(labelBackground);
		// 利用其他的方法
		
		
	}
	/**
	 * @title 设置菜单按钮
	 */
	public int SetMenu(){
		JMenuBar menuBar = new JMenuBar();
		// 文件
		JMenu menuFile = new JMenu("文件");
		JMenuItem itemOpenFile = new JMenuItem("打开文件");
		menuFile.add(itemOpenFile);
		JMenuItem itemClose = new JMenuItem("关闭");
		menuFile.add(itemClose);
		menuBar.add(menuFile);
		// 设置菜单按钮-文件选择按钮
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		
		itemOpenFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					String name = fileChooser.getSelectedFile().getPath();
					generalMap.put("filePath", name);
					filename = name;
					// 将文件放入读入文件框
					// 读入文件BufferedReader
					BufferedReader bufferedReader = null;
					try {
						bufferedReader = new BufferedReader(new FileReader(name));
						String line;
						String fileString = "";
						while ((line = bufferedReader.readLine()) != null) {
							fileString += line;
						}
						// 将文件放入读入文件框
						fileReadertTextArea.setText(fileString);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally{
						try{
							bufferedReader.close();
						}catch (IOException ex) {
							// TODO: handle exception
							ex.printStackTrace();
						}
					}
				}
				
			}
		});
		itemClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		// 编辑
		JMenu menuEdit = new JMenu("编译");
		JMenuItem itemEditSaveSource = new JMenuItem("开始编译");
		JMenuItem itemEditSaveToken = new JMenuItem("保存token");
		menuEdit.add(itemEditSaveSource);
		menuEdit.add(itemEditSaveToken);
		menuBar.add(menuEdit);
		
		// 编辑-保存源文件
		itemEditSaveSource.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BufferedWriter bufferedWriter;
				
				if (fileReadertTextArea.getText().toString() != null) {
					try {
						bufferedWriter = new BufferedWriter(new FileWriter(filename));
						bufferedWriter.write(fileReadertTextArea.getText().toString());
						//bufferedWriter.write("s4564fs6d5f465sd4f6sd4f65sd4");
						File file = new File(filename);
						/*FileOutputStream fileOutputStream = new FileOutputStream(file);
						fileOutputStream.write(new Byte(fileReadertTextArea.getText()));*/
						fileTokentTextArea.setText(fileReadertTextArea.getText());
						System.out.println(generalMap.get("filePath").toString().toString()+ "/t"+fileReadertTextArea.getText().toString());
						JOptionPane.showMessageDialog(null, "提示",
	                            "保存成功", JOptionPane.ERROR_MESSAGE);
						bufferedWriter.close();
					} catch (IOException e2) {
						// TODO: handle exception
						/*bufferedWriter.close();*/
						e2.printStackTrace();
						
					} finally {
						try {
							
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}
				} else {
					System.out.println("文件错误>>>>>Writer");
				}
			}
		});
		
		// 
		setJMenuBar(menuBar);
		return 0;
	}
	/**
	 * @title 增加读入文件的显示框
	 */
	public int AddFileOutViewJPanel(){
		fileReadertTextArea = new JTextArea();
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE, 3));
		panel.setSize(this.getWidth()/3, this.getHeight());
		panel.setLayout(new GridLayout(1,1));
		// 文本框
		fileReadertTextArea = new JTextArea("123");
		fileReadertTextArea.setText("");
		fileReadertTextArea.setLineWrap(true);
		JScrollPane p = new JScrollPane(fileReadertTextArea);
		// add
		panel.add(p);
		
		add(panel);
		return 0;
	}
	/**
	 * @title 增加符号表的显示和系统信息显示
	 */
	public int AddChartPanel(){
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 3));
		panel.setSize(this.getWidth()/3*2, this.getHeight());
		panel.setLayout(new GridLayout(2,1));
		// 文本框
		fileTokentTextArea = new JTextArea("123");
		fileTokentTextArea.setText("");
		panel.add(fileTokentTextArea);
		// 系统信息框
		infoTextArea = new JTextArea();
		infoTextArea.setText("");
		
		add(panel);
		return 0;
	}

}
