package org.zerock.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ex1 {
	
	public static void main(String[] args) {
		
		Timer timer = new Timer();
		
		Calendar startDate = Calendar.getInstance();   
		startDate.set(Calendar.YEAR, 2022);   
		startDate.set(Calendar.MONTH, Calendar.APRIL);   
		startDate.set(Calendar.DAY_OF_MONTH, 6);   
		startDate.set(Calendar.HOUR_OF_DAY, 17);   
		startDate.set(Calendar.MINUTE, 1);   
		startDate.set(Calendar.SECOND, 0);  
		startDate.set(Calendar.MILLISECOND, 0);

		Calendar betweenDate = Calendar.getInstance();   
		betweenDate.set(Calendar.YEAR, 2022);   
		betweenDate.set(Calendar.MONTH, Calendar.APRIL);   
		betweenDate.set(Calendar.DAY_OF_MONTH, 7);   
		betweenDate.set(Calendar.HOUR_OF_DAY, 17);   
		betweenDate.set(Calendar.MINUTE, 0);   
		betweenDate.set(Calendar.SECOND, 0);  
		betweenDate.set(Calendar.MILLISECOND, 0);  
		
		Calendar endDate = Calendar.getInstance();   
		endDate.set(Calendar.YEAR, 2022);   
		endDate.set(Calendar.MONTH, Calendar.APRIL);   
		endDate.set(Calendar.DAY_OF_MONTH, 8);   
		endDate.set(Calendar.HOUR_OF_DAY, 17);   
		endDate.set(Calendar.MINUTE, 1);   
		endDate.set(Calendar.SECOND, 0); 
		endDate.set(Calendar.MILLISECOND, 0);
		
		
		TimerTask task = new TimerTask() {
		    public void run() {
		    	
	    		
	    		if(endDate.getTime().getTime()<new Date().getTime()) {
	    			System.out.println(new Date() + " : Sale End");
	    			timer.cancel();
	    		} else {
	    			System.out.println(new Date() + " : Sale Start");
	    		}
		    }
		};  
		
		timer.schedule(task, startDate.getTime());
	}

}
