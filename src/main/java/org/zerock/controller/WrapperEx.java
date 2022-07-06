package org.zerock.controller;

import java.util.stream.Stream;

public class WrapperEx {
	
	private static String STR = "Hello World";
	
	public static String str() {
		System.out.println(STR);
		STR = "hello world";
		return STR;
	}
	
    public static void main(String[] args) {
       String n = "123456";
       
       char[] charArray=n.toCharArray();
       char max=charArray[0];
       for(int i=0;i<charArray.length;i++){
    	   if(charArray[i]<max) {
    		   max=charArray[i];
    		   System.out.println(max);
    	   }
       }
       System.out.println(Integer.valueOf(new String(charArray,0,charArray.length))); 	        
    }
}



