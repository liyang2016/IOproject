package com.leon.copy;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		try {
			String filename="test//ByteStreamUtils.java";
			
			long start=System.currentTimeMillis();
//			ByteStreamUtils.printHexByte(filename);
			ByteStreamUtils.printHexByteArr(filename);
			long end=System.currentTimeMillis();
			System.out.println();
			System.out.println(end-start);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
