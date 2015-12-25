/**
 * @author rain
 * 2012.4.15
 * 对按钮的事件响应
 */
package view.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.view.CompileView;
import com.compile.WordAnaly;
import com.compile.Grammer;
import com.util.ReadFile;

public class Action implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("start"))
		{
			new WordAnaly(CompileView.getString(),"src/configure.xml").analy();  //开始词法分析
		}
		else if(e.getActionCommand().equals("openfile"))
		{
			JFileChooser showFile  =  new JFileChooser();		//打开文件选择框
			showFile.showOpenDialog(null);
			
			if(showFile.getSelectedFile()!=null)
			{
				String textword=new ReadFile().startRead(showFile.getSelectedFile()); //把文件内容写到文本编辑框ta
				CompileView.setTa1Text(textword);
			}
		}
		else if(e.getActionCommand().equals("startGrammer"))
		{
			new Grammer(CompileView.getString()).analy();
		}
	}

}
