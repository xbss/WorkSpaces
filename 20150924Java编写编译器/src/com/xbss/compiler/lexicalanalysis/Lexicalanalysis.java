package com.xbss.compiler.lexicalanalysis;



import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 源程序
public class Lexicalanalysis
{

	public ArrayList bracket;
	public ArrayList keyword;
	public ArrayList symbol;
	public ArrayList semicolon;
	public ArrayList operator;

	static HashMap BRACKET;
	static HashMap KEYWORD;
	static HashMap SEMICOLON;
	static HashMap OPERATOR;

	public Lexicalanalysis()
	{
		this.KEYWORD = new HashMap();
		this.BRACKET = new HashMap();
		this.SEMICOLON = new HashMap();
		this.OPERATOR = new HashMap();
		this.bracket = new ArrayList();
		this.keyword = new ArrayList();
		this.symbol = new ArrayList();
		this.semicolon = new ArrayList();
		this.operator = new ArrayList();
	}

	public void init()
	{
		initBracket();
		initKeyword();
		initSemicolon();
		initOperator();
	}

	public void initBracket()
	{
		this.BRACKET.put("(", "(");
		this.BRACKET.put(")", ")");
		this.BRACKET.put("[", "[");
		this.BRACKET.put("]", "]");
		this.BRACKET.put("{", "{");
		this.BRACKET.put("}", "}");
	}

	public void initKeyword()
	{
		this.KEYWORD.put("class", "class");
		this.KEYWORD.put("package", "package");
		this.KEYWORD.put("this", "this");
		this.KEYWORD.put("abstract", "abstract");
		this.KEYWORD.put("boolean", "boolean");
		this.KEYWORD.put("break", "break");
		this.KEYWORD.put("byte", "byte");
		this.KEYWORD.put("case", "case");
		this.KEYWORD.put("cast", "cast");
		this.KEYWORD.put("catch", "catch");
		this.KEYWORD.put("char", "char");
		this.KEYWORD.put("continue", "continue");
		this.KEYWORD.put("default", "default");
		this.KEYWORD.put("do", "do");
		this.KEYWORD.put("double", "double");
		this.KEYWORD.put("else", "else");
		this.KEYWORD.put("extends", "extends");
		this.KEYWORD.put("false", "false");
		this.KEYWORD.put("final", "final");
		this.KEYWORD.put("finally", "finally");
		this.KEYWORD.put("float", "float");
		this.KEYWORD.put("for", "for");
		this.KEYWORD.put("future", "future");
		this.KEYWORD.put("generic", "generic");
		this.KEYWORD.put("if", "if");
		this.KEYWORD.put("implements", "implements");
		this.KEYWORD.put("import", "import");
		this.KEYWORD.put("inner", "inner");
		this.KEYWORD.put("instanceof", "instanceof");
		this.KEYWORD.put("int", "int");
		this.KEYWORD.put("interface", "interface");
		this.KEYWORD.put("long", "long");
		this.KEYWORD.put("native", "native");
		this.KEYWORD.put("new", "new");
		this.KEYWORD.put("null", "null");
		this.KEYWORD.put("operator", "operator");
		this.KEYWORD.put("outer", "outer");
		this.KEYWORD.put("package", "package");
		this.KEYWORD.put("private", "private");
		this.KEYWORD.put("protected", "protected");
		this.KEYWORD.put("public", "public");
		this.KEYWORD.put("reset", "reset");
		this.KEYWORD.put("return", "return");
		this.KEYWORD.put("short", "short");
		this.KEYWORD.put("static", "static");
		this.KEYWORD.put("super", "super");
		this.KEYWORD.put("switch", "switch");
		this.KEYWORD.put("synchronize", "synchronize");
		this.KEYWORD.put("this", "this");
		this.KEYWORD.put("throw", "throw");
		this.KEYWORD.put("throws", "throws");
		this.KEYWORD.put("transient", "transient");
		this.KEYWORD.put("true", "true");
		this.KEYWORD.put("try", "try");
		this.KEYWORD.put("var", "var");
		this.KEYWORD.put("void", "void");
		this.KEYWORD.put("volatile", "volatile");
		this.KEYWORD.put("while", "while");
	}

	public void initSemicolon()
	{
		this.SEMICOLON.put(".", ".");
		this.SEMICOLON.put(";", ";");
		this.SEMICOLON.put(",", ",");
		this.SEMICOLON.put(" ", " ");
	}

	public void initOperator()
	{
		this.OPERATOR.put("+", "+");
		this.OPERATOR.put("-", "-");
		this.OPERATOR.put("*", "*");
		this.OPERATOR.put("/", "/");
		this.OPERATOR.put("%", "%");
		this.OPERATOR.put("=", "=");
		this.OPERATOR.put("&&", "&&");
		this.OPERATOR.put("&", "&");
		this.OPERATOR.put("^", "^");
		this.OPERATOR.put("||", "||");
		this.OPERATOR.put("|", "|");
		this.OPERATOR.put("!", "!");
		this.OPERATOR.put("~", "~");
		this.OPERATOR.put(">>", ">>");
		this.OPERATOR.put("<<", "<<");
		this.OPERATOR.put(">>>", ">>>");
		this.OPERATOR.put("<<<", "<<<");
	}

	public int min(int a, int b, int c, int d, int e, int f, int g, int h,
			int i, int j, int k)
	{
		int min = Integer.MAX_VALUE;
		if (min > a && a != -1)
		{
			min = a;
		}
		if (min > b && b != -1)
		{
			min = b;
		}
		if (min > c && c != -1)
		{
			min = c;
		}
		if (min > d && d != -1)
		{
			min = d;
		}
		if (min > e && e != -1)
		{
			min = e;
		}
		if (min > f && f != -1)
		{
			min = f;
		}
		if (min > g && g != -1)
		{
			min = g;
		}
		if (min > h && h != -1)
		{
			min = h;
		}
		if (min > i && i != -1)
		{
			min = i;
		}
		if (min > j && j != -1)
		{
			min = j;
		}
		if (min > k && k != -1)
		{
			min = k;
		}
		return min;
	}

	public String tostring(char dst[], int length)
	{
		StringBuffer sb = new StringBuffer();
		int i = 0;
		char c;
		while (i < length)
		{
			c = dst[i];
			sb.append(c);
			i++;
		}
		return sb.toString();
	}

	public void lexicalAnalysis(String arg, int line)
	{
		char a = arg.charAt(0);
		if (((a >= 65) && (a <= 90)) || ((a >= 97) && (a <= 122)) || a == 95
				|| a == 36)
		{
			System.out.println(" ");
		}
		else
		{
			System.out.print("line" + "  " + line + " " + "error\n");
		}
	}

	public void read(String arg)
	{
		BufferedReader in = null;
		StringBuffer thisLine = null;
		String current = null;
		char dst[] = new char[50];
		int dstLength = 0;
		int c = 0;
		int lineNum = 0;

		try
		{
			File file = new File(arg);
			FileReader reader = new FileReader(file);
			in = new BufferedReader(reader);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		try
		{
			String temp;
			while ((temp = in.readLine()) != null)
			{
				thisLine = new StringBuffer(temp);
				lineNum++;
				System.out.println("**************" + "line" + lineNum + "*************");
				while (thisLine.length() != 0)
				{
					c = min(thisLine.indexOf(","), thisLine.indexOf("."),
							thisLine.indexOf("_"), thisLine.indexOf("["),
							thisLine.indexOf("]"), thisLine.indexOf("{"),
							thisLine.indexOf("}"), thisLine.indexOf("("),
							thisLine.indexOf(")"), thisLine.indexOf(" "),
							thisLine.indexOf(";"));
					if (c == 0)
					{
						dstLength = 1;
						//dst = new char[1];
					}
					else
					{
						dstLength = c;
						//dst = new char[c];
					}
					if (c == -1)
						break;
					if (c == 0)
					{
						thisLine.getChars(0, 1, dst, 0);
						thisLine.delete(0, c + 1);
					}
					else
					{
						thisLine.getChars(0, c, dst, 0);
						thisLine.delete(0, c);
					}
					if (dst[0] != ' ')
					{
						current = tostring(dst, dstLength);
						if (this.KEYWORD.get(current) != null)
						{
							this.keyword.add(current);
							System.out.println("keyword" + " " + current);
						}
						else if (this.BRACKET.get(current) != null)
						{
							this.bracket.add(current);
							System.out.println("bracket" + " " + current);
						}
						else if (this.SEMICOLON.get(current) != null)
						{
							this.semicolon.add(current);
							System.out.println("semicolon" + " " + current);
						}
						else if (this.OPERATOR.get(current) != null)
						{
							this.operator.add(current);
							System.out.println("oprator" + " " + current);
						}
						else
						{
							this.symbol.add(current);
							System.out.print("symbol" + " " + current);
							lexicalAnalysis(current, lineNum);
						}
					}
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		Lexicalanalysis reader = new Lexicalanalysis();
		reader.init();
		String file = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入文件：");
		// E:\Documents\办公文档\其他类\桌面\词法分析测试文件1.txt
		file = scanner.next();
		reader.read(file);
		System.out.print(reader.symbol.size());
	}
}
//参数
/*public class lexicalanalysis{
    public static void main(String args[]){
        int a;
        String as;
    }
}*/

