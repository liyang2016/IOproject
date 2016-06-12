package com.leon.copy;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamUtils {
	/**
	 * 
	 * @param filename
	 * @throws IOException 
	 */
	public static void printHex(String filename) throws IOException{
		FileInputStream fis=new FileInputStream(filename);
		int b;
		int i=1;
		while((b=fis.read())!=-1){
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
	
	public static void printHexByteArr(String filename) throws IOException{
		FileInputStream fis=new FileInputStream(filename);
		byte[] bts=new byte[20*1024];
		int index=fis.read(bts, 0, bts.length);
		int j=1;
		for(int i=0;i<index;i++){
			if(bts[i]<=0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(bts[i])+" ");
			if(j++%10==0) System.out.println();
		}
		
		fis.close();
	}
}
