package com.sxb.exercises.chapter25.e01;

public class Test {

	public static void main(String[] arags) {
		// MyArrayList对象
		MyArrayList<String> list1 = new MyArrayList<String>();
		MyArrayList<String> list2 = new MyArrayList<String>();

		// 添加元素到第一个list
		list1.add("Tom");
		list1.add("George");
		list1.add("Peter");
		list1.add("Jean");
		list1.add("Jane");

		// 添加元素到第二个list
		list2.add("Tom");
		list2.add("George");
		list2.add("Michael");
		list2.add("Michelle");
		list2.add("Daniel");

		// 打印list1执行方法后的结果
		System.out.println("未调用方法前--->>>" + list1);
		
		list1.addAll(list2);
		System.out.println("调用方法addAll()后--->>>" + list1);
		
		list1.removeAll(list2);
		System.out.println("调用方法removeAll()后--->>>" + list1);

		list1.retainAll(list2);
		System.out.println("调用方法retainAll()后--->>>" + list1);

	}
}
