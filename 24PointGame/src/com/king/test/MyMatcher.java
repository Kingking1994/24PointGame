package com.king.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 算术表达式匹配器，判断表达式是否合法
 * @author king
 *
 */
public class MyMatcher {
	
	public static boolean match(String exprection){
		Matcher matcher=Pattern.compile("^((?:(\\d+\\)+)|\\d+|(\\(+\\d+))[\\+|\\-|\\*|/])+(?:(\\d+\\)+)|\\d+)$")
	            .matcher(exprection);
		return matcher.find();
	}
	
	public static void main(String[] args) {
		System.out.println(MyMatcher.match("24"));//false
	}

}
