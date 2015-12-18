package com.king.test;

public class Test {
	
	public static void main(String[] args) {
		
//		//太暴力了，出现heap error
//		for (int i = 1; i < 14; i++) {
//			for (int j = 1; j < 14; j++) {
//				for (int k = 1; k < 14; k++) {
//					for (int l = 1; l < 14; l++) {
//						
						Data data=new Data(1, 2, 3, 4);
//				        Counter counter = new Counter();
//				        counter.count(data);
//				        String result = counter.getResult();
				        try {
//							DBController.save(result, data);
				        	System.out.println(DBController.exists(data));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
//					}
//				}
//			}
//		}
//		
//		
        
	}

}
