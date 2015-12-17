package com.compile;

import java.util.regex.Pattern;

import com.view.CompileView;

/**
 * 功能：语法分析
 * 分析算术运算
 * @author rain
 *	2012.4.16
 */
public class Grammer {
	
	private int i=0;
	private int var=0;            //定义统计变量数量
	private int opearator=0;      //定义统计操作符数量
	private int left=0;           //定义统计左括号数量
	private int right=0;          //定义统计右括号数量
	private String Input;         //获得输入字符串
	private char[] analy;         //把输入字符串变成char数组
	private boolean isspace=true; //括号内的东西是否是空的

	
	public Grammer(String word) {

		Input=word;
		analy=new char[Input.length()];
		Pattern pp2=Pattern.compile("\\(+\\s*\\)+");          //正则表达式
		if(pp2.matcher(Input).find())
		{
			System.out.println("fail");                      //如果是空
			isspace=false;
		}
		for(int i=0;i<Input.length();i++)              //把括号除出检测范围
		{
			
			if(Input.charAt(i)=='(')
			{	
				analy[i]+=' ';
				left++;
			}
			else if(Input.charAt(i)==')')
			{
				analy[i]+=' ';
				right++;
			}
			else
			{
				analy[i]+=Input.charAt(i);
			}
		}
	}
	
	/**
	 * 语法分析主方法
	 * @param word  要检测的char字符
	 */
	public void analydetail(char word)            
	{
		
		if(Character.isWhitespace(word))
		{
			i++;
		}
		else if(Character.isLetter(word)||Character.isDigit(word))
		{
			i++;
			var++;
			if(Character.isDigit(word)&&Character.isDigit(analy[i]))              //数字为多位数字的处理
			{
				var--;
			}
		}
		else if(word=='*'||word=='-'||word=='+'||word=='*'||word=='='||word=='/'||word=='%')
		{
			i++;
			opearator++;
		}
		else if(word=='.')                                         //数字是小数的处理
		{
			if(Character.isDigit(analy[i-1]))
			{
				var--;
			}
			i++;
		}
		else
		{
			i++;
		}
	}
	
	
	public void analy()
	{
		while (i<analy.length)
		{
			this.analydetail(analy[i]);
		}
		if(var-opearator==1&&left==right&&isspace)
		{
			System.out.println(Input+" is ok!");
			CompileView.setText(Input+"是合法的表达式!");                    //把结果显示到ta1文本编辑框中
		}
		else
		{
			System.out.println(Input+" is fail!");
			CompileView.setText(Input+"不是合法的表达式!");                    //把结果显示到ta1文本编辑框中
		}
	}

//	public static void main(String[] args) {
//		
//		new Grammer("(i+i*i*i)+100+(i*i)").analy();
//	}

}
