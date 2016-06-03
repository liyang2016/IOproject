package com.leon.copy;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args)throws IOException {
		File file=new File("test");
		if(!file.exists()) file.mkdir();
		File demo=new File(file, "RandomAccessFile.txt");
		if(!demo.exists()) demo.createNewFile();
		RandomAccessFile raf=new RandomAccessFile(demo,"rw");
		
		System.out.println(raf.getFilePointer());
		raf.write('A');                             //每次写一个字节
		System.out.println(raf.getFilePointer());
		raf.write('B');
		System.out.println(raf.getFilePointer());
		raf.writeInt(100);                          //一个int型包含四个字节
		System.out.println(raf.getFilePointer());
		String str="中";                         //这个字符串包含十个字节
		raf.writeChars(str);
		System.out.println(raf.getFilePointer());
		raf.close();
	}
}
