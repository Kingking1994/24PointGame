package com.king.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 算术表达式匹配器，判断表达式是否合法
 * @author king
 *
 */
public class MyMatcher {
	/**
	 * 
	 * @param exprection
	 * @param ints
	 * @return
	 */
	public static boolean match(String exprection,int[] ints){
//		Matcher matcher=Pattern.compile("^((?:(\\d+\\)+)|\\d+|(\\(+\\d+))[\\+|\\-|\\*|/])+(?:(\\d+\\)+)|\\d+)$")
//	            .matcher(exprection);
		
		//限定数字
		String num = "["+ints[0]+"|"+ints[1]+"|"+ints[2]+"|"+ints[3]+"]";
		String regex = "^((?:("+num+"+\\)+)|"+num+"+|(\\(+"+num+"+))[\\+|\\-|\\*|/])+(?:("+num+"+\\)+)|"+num+"+)$";
		Matcher matcher=Pattern.compile(regex).matcher(exprection);
		return matcher.find();
	}
	
	public static void main(String[] args) {
		int [] ints = {1,2,3,4};
		System.out.println(MyMatcher.match("1+4*(3+2)",ints));//true
	}

}
