package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JTextArea;

public class WriteFile {
	// 使用file 对象
	private File f;
	/**
	 * @param path
	 * @return
	 */
	private File init(String path){
		return new File(path);
	}
	/**
	 * @author XBSS
	 * @param path
	 * @return
	 */
	public String doWrite(String path, JTextArea area){
		f = this.init(path);
		String[] data = area.getText().split("\n");
		if (data != null && !data.equals("")) {
			try {
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				for (String string : data) {
					bw.write(string + "\r\n");
				}
			} catch (Exception e) {
				System.out.println("error:" + "存入文件错误");
			}
		}
		return null;
	}
	public void main(String[] args){
		new WriteFile();
	}

}
