package com.leon.fileoperation;

public class FileUtilsTest {
	public static void main(String[] args) {
		try {
			FileUtils.listDir("D://test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
