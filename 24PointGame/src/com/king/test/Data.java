package com.king.test;

/**
 * 实体类
 * @author king
 *
 */
public class Data{
    public float[]  arr;
    public String optStr="";
    public String[] strs;
    public Data(){}
    public Data(int a,int b,int c,int d) {
        arr=new float[]{a,b,c,d};
        strs=new String[]{a+"",b+"",c+"",d+""};
        optStr=a+"";
    }
    public Data(int [] numbers) {
    	int a = numbers[0];
    	int b = numbers[1];
    	int c = numbers[2];
    	int d = numbers[3];
        arr=new float[]{a,b,c,d};
        strs=new String[]{a+"",b+"",c+"",d+""};
        optStr=a+"";
    }
     
}
