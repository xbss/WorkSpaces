/**
 * @author rain
 * 2012.4.15
 */
package compile;

import java.io.File;

import util.ReadFile;
import util.XMLReader;
import view.CompileView;

public class WordAnalysis {

	private String word;
	private char[] Input;
	private String[] Defind;  			//标识符数组
	private String[] Operator;			//操作符数组
	private String[] Exception;         //例外符数组
	private String analy="";
	private String showString="";
	private int j=0;
	private boolean ok=true;            //非法字符的标识
	private boolean isstring=false;		//是否为字符串的标识
	private boolean ischar=false;		//是否为字符的标识
	
	/**
	 * 初始化元素
	 * @param FilePath  需要分析的文件路径
	 * @param XMLPath   XML文件路径
	 */
	public WordAnalysis(File FilePath,String XMLPath)    
	{
		word=new ReadFile().startRead(FilePath);
		//System.out.println(word);
		Input=new char[word.length()];
		Defind=new XMLReader().startprase(XMLPath, "sign");         //设置标识符
		Operator=new XMLReader().startprase(XMLPath, "opeator");    //设置操作符
		Exception=new XMLReader().startprase(XMLPath, "special");   //设置例外符
		for(int i=0;i<word.length();i++)                            //把输入的字符串变成char数组
		{
			Input[i]=word.charAt(i);
		} 
	}
	
	/**
	 * 初始化元素
	 * @param word  输入要分析的文本
	 */
	public WordAnalysis(String word,String XMLPath)
	{
		this.word=word;
		//System.out.println(word);
		Input=new char[word.length()];
		Defind=new XMLReader().startprase(XMLPath, "sign");         //设置标识符
		Operator=new XMLReader().startprase(XMLPath, "opeator");    //设置操作符
		Exception=new XMLReader().startprase(XMLPath, "special");   //设置例外符
		for(int i=0;i<word.length();i++)                                //把输入的字符串变成char数组
		{
			Input[i]=word.charAt(i);
		}
	}
	
	/**
	 * 判断是不是操作符
	 * @param word  要判断的字符值
	 * @return  是否是操作符
	 */
	private boolean checkSpecialWord(char word)               
	{
		boolean isspecial=false;
		String testword=word+"";
		for(int i=0;i<Operator.length;i++)
		{
			if(testword.equals(Operator[i]))
			{
				isspecial=true;
			}
			else if(testword.equals(","))
			{
				isspecial=true;
			}
		}
		return isspecial;
	}
	
	/**
	 * 判断例外符
	 * @param word 要判断的字符值
	 * @return 是否是例外符
	 */
	private boolean checkException(char word)
	{
		boolean isexception=false;
		String testword=word+"";
		for(int i=0;i<Exception.length;i++)
		{
			if(testword.equals(Exception[i]))
			{
				isexception=true;
			}
		}
		return isexception;
	}
	
	/**
	 * 判断是否为字符串或者是字符
	 * @param i    字符串临时标识
	 * @param charnumber  字符临时标识
	 */
	private void checkStringOrChar(int i,int charnumber)
	{
		while(j<word.length()&&i==1)
		{
			analy+=Input[j]+"";
			j++;
			if(j<word.length()&&Input[j]=='"')
			{
				analy+=Input[j]+"";
				j++;
				i=2;
				isstring=true;
			}
		}
		while(j<word.length()&&charnumber==1)
		{
			analy+=Input[j]+"";
			j++;
			if(j<word.length()&&Input[j]=='\'')
			{
				analy+=Input[j]+"";
				j++;
				charnumber=2;
				ischar=true;
			}
		}
	}
	
	/**
	 * 词法分析主方法
	 */
	public void analy()
	{
		while(j<word.length())
		{
			if(Character.isWhitespace(Input[j]))      //判断是否是空格，是就跳过这个值
			{
				j++;
			}
			else if(Character.isLetter(Input[j]))     //判断是否是字母
		{
			ok=true;
			while(j<word.length()&&Character.isLetter(Input[j])||j<word.length()&&Character.isDigit(Input[j])||j<word.length()&&this.checkException(Input[j]))   //判断是否是字母或者数字或者是$,_
			{				
				analy+=Input[j]+"";	
				j++;			
			}
			while(j<word.length()&&!Character.isWhitespace(Input[j])&&!Character.isDigit(Input[j])&&!Character.isLetter(Input[j])    //如果字母后跟有数字和没有操作符
				&&!this.checkSpecialWord(Input[j]))
			{
				analy+=Input[j]+"";
				j++;
				ok=false;
			}
			for(int z=0;z<Defind.length;z++)                      //查找看是否是关键字
			{
				if(analy.equals(Defind[z]))
				{
					System.out.println(analy+"是关键字");
					showString+="   "+analy+"\t是关键字"+"\n";
					analy="";
				}
			}
			if(!analy.equals(""))                                 //判断是否是合法的标识符
			{
				if(ok)
				{
					System.out.println(analy+"是标识符");
					showString+="   "+analy+"\t是标识符"+"\n";
				}
				if(!ok)
				{
					System.out.println(analy+"是非法");
					showString+="   "+analy+"\t是非法符"+"\n";
				}
				analy="";
			}
		}
			else if(Character.isDigit(Input[j]))              //判断是否是数字
			{
				ok=true;
				while(j<word.length()&&!Character.isWhitespace(Input[j])&&Character.isDigit(Input[j])||j<word.length()&&Input[j]=='.'&&!Character.isWhitespace(Input[j]))   //同时判断是否是小数
				{
					analy+=Input[j]+"";
					j++;
				}
				while(j<word.length()&&!Character.isWhitespace(Input[j])        //判断是否是非法的变量
						&&!this.checkSpecialWord(Input[j]))
				{				
					analy+=Input[j]+"";
					j++;
					ok=false;
				}
				if(ok)
				{
					System.out.println(analy+"是数值");
					showString+="   "+analy+"\t是数值"+"\n";
					analy="";
				}
				if(!ok)
				{
					System.out.println(analy+"是非法符");
					showString+="   "+analy+"\t是非法符"+"\n";
					analy="";
				}

			}
			else if(!Character.isDigit(Input[j])&&!Character.isLetter(Input[j])&&!Character.isWhitespace(Input[j]))             //判断是否是操作符
			{
				ok=true;
				int i=0;
				int charnumber=0;
				while(j<word.length()&&!Character.isWhitespace(Input[j])&&!Character.isDigit(Input[j])&&!Character.isLetter(Input[j]))
				{
						analy=Input[j]+"";
						if(Input[j]=='"')
						{
							i=1;
						}
						else if(Input[j]=='\'')
						{
							charnumber=1;
						}
						j++;
					if(j<word.length()&&!Character.isWhitespace(Input[j])&&!Character.isDigit(Input[j])&&!Character.isLetter(Input[j])
							&&Input[j-1]!=';'&&Input[j-1]!='('&&Input[j-1]!=')'&&Input[j-1]!='='&&Input[j-1]!='{'&&Input[j-1]!='}'&&Input[j-1]!=','&&Input[j-1]!='"'&&Input[j-1]!='\'')
					{
						analy+=Input[j]+"";
						j++;
					}
					
					this.checkStringOrChar(i,charnumber);    //检测是否是字符或者是字符串
					
					for(int z=0;z<Operator.length;z++)
					{
						if(analy.equals(Operator[z]))
						{
							ok=true;
							System.out.println(analy+"是操作符");
							showString+="   "+analy+"\t是操作符"+"\n";
							analy="";
						}
						else if(analy.equals(","))
						{
							ok=true;
							System.out.println(analy+"是操作符");
							showString+="   "+analy+"\t是操作符"+"\n";
							analy="";
						}
					}
					if(!ok)
					{
						System.out.println(analy+"是非法");
						showString+="   "+analy+"\t是非法符"+"\n";
						analy="";
					}
					if(isstring)
					{
						System.out.println(analy+"是字符串");
						showString+="   "+analy+"\t是字符串"+"\n";
						isstring=false;
						i=0;
						analy="";
					}
					if(ischar)
					{
						System.out.println(analy+"是字符");
						showString+="   "+analy+"\t是字符"+"\n";
						ischar=false;
						charnumber=0;
						analy="";
					}
					
				}
			}
		}
		CompileView.setText(showString);                    //把结果显示到ta1文本编辑框中
	}
	/**
	 * @author XBSS
	 * @tiltle 针对使用java实现编译原理语法分析模块
	 */
	public void GrammerAnalysis(){
		
	}
	
//	public static void main(String[] args) {
//		
//		new WordAnaly("src/test.txt","src/a.xml").analy();
//	}

}
