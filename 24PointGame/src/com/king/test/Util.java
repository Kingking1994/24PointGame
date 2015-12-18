package com.king.test;

/**
 * 工具类
 * @author king
 *
 */

public class Util {

	
	/**
	 * 通过data的四个数字生成数据库对应的datastring，以便进行查找
	 * @param data
	 * @return
	 */
	public static String changeDataToString(Data data){
		String temp = "";
		StringBuffer sb = new StringBuffer();
		float[]  arr = data.arr;
		bubbleSort(arr);
		for (float f : arr) {	
			int num = (int)f;
			sb.append(num+"_");
		}
		sb.deleteCharAt(sb.length()-1);
		temp = sb.toString();
		return temp;
	}
	
	
	/**
	 * 冒泡排序，升序
	 * @param numbers
	 */
	public static void bubbleSort(float[] numbers) {   
	    float temp; // 记录临时中间值   
	    int size = numbers.length; // 数组大小   
	    for (int i = 0; i < size - 1; i++) {   
	        for (int j = i + 1; j < size; j++) {   
	            if (numbers[i] > numbers[j]) { // 交换两数的位置   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	            }   
	        }   
	    }   
	} 
}
