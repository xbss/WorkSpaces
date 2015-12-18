package _01LongestSubString;
/**
 * 
 * @author XBSS
 * @title 测试最长公共子序列
 *
 */
public class Test01 {
	public static void main(String[] args){
		
		// 构造字符串
		String aString = "zxyxyz";
		char[] a = {'z','x','y','x','y','z'};
		String bString = "xyyzx";
		char[] b = {'x','y','y','z','x'};
		LongestCommonSubString longestSubString = new LongestCommonSubString();
		System.out.println("最长子序列长度：" + longestSubString.LCSLength(a, b));
		
	}

}
