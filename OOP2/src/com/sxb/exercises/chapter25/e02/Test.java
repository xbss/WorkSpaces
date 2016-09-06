package com.sxb.exercises.chapter25.e02;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"Tom", "George", "Peter", "Jean", "Jane"};
		MyLinkedList<String> linkedList = new MyLinkedList<String>(strings);
		
		System.out.println("未改变之前---->>>" + linkedList);
		
		linkedList.addFirst("123456");
		System.out.println("调用方法addFirst()后---->>>" + linkedList);
		
		linkedList.addFirst("123456");
		System.out.println("调用方法addFirst()后---->>>" + linkedList);
	}

}
