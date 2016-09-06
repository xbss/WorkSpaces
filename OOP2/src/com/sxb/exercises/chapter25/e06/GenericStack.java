package com.sxb.exercises.chapter25.e06;

public class GenericStack<E> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
	
	public int getSize(){
		return list.size();
	}
	
	public E peek(){
		return list.get(getSize() -1);
	}
	
	public E pop(){
		E o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
	
	public boolean push(E e){
		return list.add(e);
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
}
