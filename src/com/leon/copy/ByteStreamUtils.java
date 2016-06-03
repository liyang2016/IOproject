package com.leon.copy;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamUtils {
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
	
	
}
