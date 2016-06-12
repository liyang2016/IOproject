package com.leon.byteoperation;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * 使用RandomAccessFile文件
 * 向文件写入和从文件读出数据
 * @author Administrator
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args)throws IOException {
		File file=new File("test");
		if(!file.exists()) file.mkdir();
		File demo=new File(file, "RandomAccessFile.txt");
		if(!demo.exists()) demo.createNewFile();
		RandomAccessFile raf=new RandomAccessFile(demo,"rw");
		
		//写文件
		System.out.println(raf.getFilePointer());
		raf.write('A');                           //一个字符占用一个字节
		System.out.println(raf.getFilePointer());
		//raf.writeInt(1);                          //一个int型占用四个字节
		System.out.println(raf.getFilePointer());
		/*String str="中国";                         //一个中文字符占用两个字节
		byte[] utf=str.getBytes("utf8");
		raf.write(utf);*/                     
		System.out.println(raf.getFilePointer());
		raf.writeUTF("中国");
		System.out.println(raf.getFilePointer());
		System.out.println("-----------------------------------");
		//读文件
		
		raf.seek(0);
		char ch=raf.readChar();
		System.out.println(ch);
		raf.seek(5);
		System.out.println(raf.getFilePointer());
		byte[] bytes=new byte[(int) raf.length()];
		raf.read(bytes);
		String bytesStr=new String(bytes);
		System.out.println(bytesStr);
		raf.close();
	}
}
