package com.leon.copy;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		try {
			long start=System.currentTimeMillis();
//			StreamUtils.printHexByte("test//ByteStreamUtils.java");
//			StreamUtils.printHexByteArr("test//ByteStreamUtils.java");
//			StreamUtils.copyByteArr(new File("test//ByteStreamUtils.java"), new File("test//ByteStreamUtils1.java"));
			StreamUtils.copyByBuffer(new File("test//ByteStreamUtils.java"), new File("test//ByteStreamUtils1.java"));
			long end=System.currentTimeMillis();
			System.out.println(end-start);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
