package com.leon.copy;

import java.io.IOException;

public class Test1 {
	public static void main(String[] args) {
		try {
			ByteStreamUtils.output();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
