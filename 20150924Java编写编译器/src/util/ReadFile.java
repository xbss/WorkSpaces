/**
 * @author rain
 * 2012.4.14
 * 读取文件中的数据
 */
package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	private File f;
	
	private File init(String path)
	{
		return new File(path);
	}
	public String doRead(String path)
	{
		String outPut = "";
		f=this.init(path);
		try 
		{
		   FileReader fr = new FileReader(f);
		   BufferedReader br = new BufferedReader(fr);
		   String line = null;
		   while((line = br.readLine())!=null){
			   outPut += line+"\n";
		 }
		  } catch (FileNotFoundException fe) {
			  fe.printStackTrace();
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		//System.out.println(outPut);
			  
		return outPut;
	}
	public String startRead(File path)
	{
		String outPut = "";
		f=path;
		try 
		{
		   FileReader fr = new FileReader(f);
		   BufferedReader br = new BufferedReader(fr);
		   String line = null;
		   while((line = br.readLine())!=null){
			   outPut += line+"\n";
		 }
		  } catch (FileNotFoundException fe) {
			  fe.printStackTrace();
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		//System.out.println(outPut);
			  
		return outPut;
	}
	
//	public static void main(String[] args) {
//
//		new ReadFile().doRead("src/test.txt");
//	}

}
