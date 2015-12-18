package com.king.test;

import java.util.Random;
/**
 * 随机数产生器
 * @author king
 *
 */
public class Generateor {

	/**
	 * 产生四个1-13的数字，存放在data
	 * @return data
	 */
	public static Data generate(){
		int [] numbers = new int [4];
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Math.abs(random.nextInt())%13 + 1;
		}
		Data data = new Data(numbers);
		
		return data;
	}
	
	public static void main(String[] args) {
		Generateor.generate();
	}
}
