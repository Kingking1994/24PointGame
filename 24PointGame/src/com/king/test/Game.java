package com.king.test;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Game {

	public static void play() throws Exception{
		
		System.out.println("**********************");
		System.out.println("*******welcome********");
		System.out.println("*******24点游戏*********");
		System.out.println("**********************");
		System.out.println("***designed by King***");
		System.out.println("**********************");
		System.out.println("**********************");
		
		
		new Thread().sleep(3000);
		
		System.out.println();
		System.out.println();
		System.out.println(">>>>>输入1：跳过此题，实在太难了");
		System.out.println(">>>>>输入2：给我答案，脑子烧掉了");
		System.out.println(">>>>>输入3：退出游戏，我要吃饭了");
		System.out.println(">>>>>输入?：调出此菜单");
		System.out.println();
		System.out.println();
		
		boolean playing = true;

		
		while(playing){
			
			Data data = Generateor.generate();
			Counter counter = new Counter();
			counter.count(data);
			Set<String> resultSet= counter.getResultSet();
			//判断这组数据是否有解，无解就跳过，重新生成data
			if (resultSet == null) {
				continue;
			}
			
			System.out.println("游戏将在10s后开始......");
			for (int i = 10; i > 0; i--) {
				System.out.println("..."+i+"...");
			
				new Thread().sleep(1000);
				
			}
			
			long start = System.currentTimeMillis();
			
			
			//转换类型，float to int
			float [] num = data.arr;
			int []ints = new int [4];
			for (int i = 0; i < num.length; i++) {
				ints[i] = (int)num[i];
			}
			System.out.println();
			System.out.println(ints[0]+"  "+ints[1]+"  "+ints[2]+"  "+ints[3]);
			System.out.println("请输入算术表达式：");
			
			while(true){
				Scanner scanner = new Scanner(System.in);
				String input = scanner.nextLine();
				//输入为？，英文的问号,这里并没有兼容中文的问号
				//当输入中文的问号时，就卡机了
				if (input.equals("?")) {
					System.out.println(">>>>>输入1：跳过此题，实在太难了");
					System.out.println(">>>>>输入2：给我答案，脑子烧掉了");
					System.out.println(">>>>>输入3：退出游戏，我要吃饭了");
					System.out.println(">>>>>输入?：调出此菜单");
				}else if(input.equals("1")){
					break;
				}else if(input.equals("2")){
					System.out.println("真是愚蠢的人类！！！！@_@");
					System.out.println("这就是答案↓↓↓↓↓↓↓↓↓↓");
					
					Iterator<String> iter = resultSet.iterator();
					while (iter.hasNext()) {
						new Thread().sleep(500);
						System.out.println(iter.next());
						
					}
					System.out.println();
					System.out.println(">>>>>>>>>>>>我是分隔线>>>>>>>>>>>>>>>>>");
					System.out.println();
					//判断数据库是否存在答案，否则保存
					if (!DBController.exists(data)) {
						DBController.save(resultSet, data);
					}
					break;
				}else if(input.equals("3")){
					System.out.println("**********************");
					System.out.println("*******goodbye********");
					System.out.println("*******24点游戏*********");
					System.out.println("**********************");
					System.out.println("**********************");
					playing = false;
					break;
				}else{
					//判断输入是否合法的表达式
					if (MyMatcher.match(input,ints)) {
						Calculator calculator = new Calculator();
						long end = System.currentTimeMillis();
						double resultDouble = calculator.calculate(input);
						if (resultDouble == 24) {
							
							//判断数据库是否存在答案，否则保存
							if (!DBController.exists(data)) {
								DBController.save(resultSet, data);
							}
							
							System.out.println("     *    *    *   *      *  *");
							System.out.println("  *   *    *    *     *    *");
							System.out.println("    *     *    *   *    *");
							System.out.println("   答对了，太棒了，民族英雄啊     ");
							System.out.println("     用了"+(end-start)/1000+"s就做出来了");
							System.out.println("  *   *   *  *    *   **  *");
							System.out.println("    *   *    * *  *  *   *");
							System.out.println("  *    *   *    *    *   * *  *");
							System.out.println("进入下一道题》》》》》》》》》》》");
							
							System.out.println();
							System.out.println(">>>>>>>>>>>>我是分隔线>>>>>>>>>>>>>>>>>");
							System.out.println();
							break;
						}else{
							System.out.println("不对，你太笨了，赶紧再答一次，用实力证明自己吧！");
						}
					}else{
						System.out.println("哎呦喂，你输入的表达式不合法啊，再试试吧！！！");
					}
				}
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		try {
			Game.play();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
