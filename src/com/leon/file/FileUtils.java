package com.leon.file;

import java.io.File;

public class FileUtils {
	/**
	 * 列出目录下所有的文件
	 * 不包括目录
	 * @param filename
	 */
	public static void listDir(String filename) {
		File file = new File(filename);
		if (!file.exists()) {
			throw new IllegalArgumentException("目录" + filename + "不存在");
		}
		if (!file.isDirectory()) {
			throw new IllegalArgumentException(file + "不是目录");
		}
		/*
		 * String[] str=file.list(); for (String string : str) {
		 * System.out.println(file+"\\"+string); }
		 */
		File[] files = file.listFiles();
		/*for (File file2 : files) {
			//System.out.println(file2);
			
		}*/
		if(files!=null&&files.length>0){
			for (File index : files) {
				if(index.isDirectory()){
					listDir(index.getAbsolutePath());
				}else{
					System.out.println(index);
				}
			}
		}
	}
	
}
