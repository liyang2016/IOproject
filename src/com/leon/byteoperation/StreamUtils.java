package com.leon.byteoperation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamUtils {
	/**
	 * 读取指定文件内容，按照十六进制输出到控制台
	 * 逐个读取到Byte
	 * 每行输出十个
	 * @param filename
	 * @throws IOException 
	 */
	public static void printHexByte(String filename) throws IOException{
		FileInputStream fis=new FileInputStream(filename);
		int b;
		int i=1;
		while((b=fis.read())!=-1){           //这里的b表示的是当前位置返回的数据的值
			if(b<=0xf){
				System.out.print("0");
			}
		    System.out.print(Integer.toHexString(b)+" ");
			
			if(i++%10==0){
				System.out.println();
			}
		}
		fis.close();
	}
	
	/**
	 * 读取指定文件内容，按照十六进制输出到控制台
	 * 批量读取到Byte数组
	 * @param filename
	 * @throws IOException
	 */
	public static void printHexByteArr(String filename) throws IOException{
		FileInputStream fis=new FileInputStream(filename);
		byte[] bts=new byte[20*1024];
		/*int index=fis.read(bts, 0, bts.length);
		int j=1;
		for(int i=0;i<index;i++){
			if(bts[i]<=0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(bts[i]&0xff)+" ");
			if(j++%10==0) System.out.println();
		}*/
		int index;
		int j=1;
		while((index=fis.read(bts,0,bts.length))!=-1){   //index表示当前数据个数
			for(int i=0;i<index;i++){
				if(bts[i]<=0xf){
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(bts[i]&0xff)+" ");
				if(j++%10==0) System.out.println();
			}
		}
		fis.close();
	}
	
	public static void output() throws IOException{
		String filename="test"+File.separator+"outputDemo.txt";
	    FileOutputStream fos=new FileOutputStream(filename);
	    FileInputStream fis=new FileInputStream(filename);
	    fos.write('a');
	    int a=1;
	    fos.write(a>>>24);
	    fos.write(a>>>16);
	    fos.write(a>>>8);
	    fos.write(a);
	    int index;
	    while((index=fis.read())!=-1){
	    	System.out.println(Integer.toBinaryString(index));
	    }
	    fis.close();
	    fos.close();
	}
	
	/**
	 * 使用单个字节逐个读取，实现拷贝操作
	 * @param scrFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyByByte(File scrFile,File destFile) throws IOException{
		if(!scrFile.exists()){
			throw new IllegalArgumentException(scrFile+"不存在");
		}
		if(scrFile.isDirectory()){
			throw new IllegalArgumentException(scrFile+"不是文件");
		}
		FileInputStream fis=new FileInputStream(scrFile);
		FileOutputStream fos=new FileOutputStream(destFile);
		
		int b;
		while((b=fis.read())!=-1){
			fos.write(b);
			fos.flush();
		}
		fos.close();
		fis.close();
	}
	
	/**
	 * 使用字节数组读取，实现拷贝
	 * @param scrFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyByByteArr(File scrFile,File destFile) throws IOException{
		if(!scrFile.exists()){
			throw new IllegalArgumentException(scrFile+"不存在");
		}
		if(scrFile.isDirectory()){
			throw new IllegalArgumentException(scrFile+"不是文件");
		}
		FileInputStream fis=new FileInputStream(scrFile);
		FileOutputStream fos=new FileOutputStream(destFile);
		//批量读写
		byte[] bytes=new byte[8*1024];
		int b;
		while((b=fis.read(bytes, 0, bytes.length))!=-1){
			fos.write(bytes, 0, b);
			fos.flush();
		}
		fos.close();
		fis.close();
	}
	
	/**
	 * 使用缓冲读取，实现拷贝操作
	 * @param scrFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyByBuffer(File scrFile,File destFile) throws IOException{
		if(!scrFile.exists()){
			throw new IllegalArgumentException(scrFile+"不存在");
		}
		if(scrFile.isDirectory()){
			throw new IllegalArgumentException(scrFile+"不是文件");
		}
		BufferedInputStream bis=new BufferedInputStream(
				new FileInputStream(scrFile));
		BufferedOutputStream bos=new BufferedOutputStream(
				new FileOutputStream(destFile));
		int c;
		while((c=bis.read())!=-1){
			bos.write(c);
			bos.flush();
		}
		bos.close();
		bis.close();
	}
}
