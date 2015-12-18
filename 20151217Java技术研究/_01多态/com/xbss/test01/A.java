package com.xbss.test01;

public class A {
	public String show(D obj) {
		return ("A and D");
	}

	public String show(A obj) {
		return ("A and A");
	}
}

class B extends A{  
    public String show(B obj){  
           return ("B and B");  
    }  
    public String show(A obj){  
           return ("B and A");  
    }   
}  

class C extends B{}   
class D extends B{} 
