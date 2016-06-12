package com.leon.copy;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		try {
			long start=System.currentTimeMillis();
//			ByteStreamUtils.printHexByte("test//ByteStreamUtils.java");
//			ByteStreamUtils.printHexByteArr("test//ByteStreamUtils.java");
			StreamUtils.copyByteArr(new File("test//ByteStreamUtils.java"), new File("test//ByteStreamUtils1.java"));
			long end=System.currentTimeMillis();
			System.out.println(end-start);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
