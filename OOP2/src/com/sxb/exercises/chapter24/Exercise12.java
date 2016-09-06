package com.sxb.exercises.chapter24;

import java.util.ArrayList;

public class Exercise12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    int[] array = new int[100];
	    
	    for (int i = 0; i < array.length; i++)
	      array[i] = (int)(Math.random() * 1000);
	    
	    radixSort(array, 3);
	    
	    for (int i = 0; i < array.length; i++)
	      System.out.print(array[i] + " ");
	  }

	   public static int getKey(int number, int position) {
	    int result = 1;
	    for (int i = 0; i < position; i++)
	      result *= 10;

	    return (number / result) % 10;
	  }
	  public static void radixSort(int[] array, int numberOfDigits) {
	    @SuppressWarnings("unchecked")
		ArrayList<Integer>[] temps = new ArrayList[10];
	    for (int i = 0; i < temps.length; i++) {
	      temps[i] = new java.util.ArrayList<Integer>();
	    }

	    for (int position = 0; position <= numberOfDigits; position++) {
	      for (int i = 0; i < temps.length; i++) {
	        temps[i].clear();
	      }      
	      
	      for (int i = 0; i < array.length; i++) {
	        int key = getKey(array[i], position);
	        temps[key].add(array[i]);
	      }

	      int k = 0;
	      for (int i = 0; i < temps.length; i++) {
	        if (temps[i] != null) {
	          for (int j = 0; j < temps[i].size(); j++)
	            array[k++] = temps[i].get(j);
	        }
	      }
	    }
	  }

}
