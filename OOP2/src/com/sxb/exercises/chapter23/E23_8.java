package com.sxb.exercises.chapter23;

import java.awt.List;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;

public class E23_8 {

	/**
	 * @param args
	 */
	
	static BigInteger bigInteger = new BigInteger("10000000000");
	static File file = new File("Exercise23_8.dat");
	public static void main(String[] args) {
		FileExist();
		

	}
	private static void FileExist() {
		// TODO Auto-generated method stub
		if(file.exists())
			System.out.println("");
	}

}
