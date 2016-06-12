package com.leon.charoperation;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		try {
//			CharStreamUtils.copyByChar(new File("test//ByteStreamUtils.java"), 
//					new File("test//ByteStreamUtils1.java"));
//			CharStreamUtils.copyByFrandFw(new File("test//ByteStreamUtils.java"), 
//					new File("test//ByteStreamUtils1.java"));
			CharStreamUtils.copyByBuffered(new File("test//ByteStreamUtils.java"), 
					new File("test//ByteStreamUtils2.java"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
