package com.xbss.test01;

public class TestA {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		System.out.println("a1.show(b):" + a1.show(b));
		System.out.println("a1.show(c):" + a1.show(c));
		System.out.println("a1.show(d):" + a1.show(d));
		System.out.println("a2.show(b):" + a2.show(b));
		System.out.println("a2.show(c):" + a2.show(c));
		System.out.println("a2.show(d):" + a2.show(d));
		System.out.println("b.show(b):" + b.show(b));
		System.out.println("b.show(c):" + b.show(c));
		System.out.println("b.show(d):" + b.show(d));
	}

}
