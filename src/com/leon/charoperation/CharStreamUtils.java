package com.leon.charoperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CharStreamUtils {
	
	/**
	 * 使用InputStreamReader、OutputStreamWriter类
	 * @param scrFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyByChar(File scrFile,File destFile)throws IOException{
		if(!scrFile.exists()){
			throw new IllegalArgumentException(scrFile+"不存在");
		}
		if(scrFile.isDirectory()){
			throw new IllegalArgumentException(scrFile+"不是文件");
		}
		FileInputStream fis = new FileInputStream(scrFile);
		FileOutputStream fos=new FileOutputStream(destFile);
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		OutputStreamWriter osw=new OutputStreamWriter(fos, "utf-8");
		int c;
		while ((c = isr.read()) != -1) {
			osw.write((char)c);
		}
		osw.close();
		isr.close();
	}
	
	/**
	 * 使用FileReader和FileWriter类
	 */
	public static void copyByFrandFw(File scrFile,File destFile)throws IOException{
		if(!scrFile.exists()){
			throw new IllegalArgumentException(scrFile+"不存在");
		}
		if(scrFile.isDirectory()){
			throw new IllegalArgumentException(scrFile+"不是文件");
		}
		FileReader fr=new FileReader(scrFile);
		FileWriter fw=new FileWriter(destFile,true);
		char[] buffer=new char[1024];
		int c;
		while((c=fr.read(buffer, 0, buffer.length))!=-1){
			fw.write(buffer, 0, c);
			fw.flush();
		}
		fw.close();
		fr.close();
	}
	
	/**
	 * 使用BufferedReader和BufferedWrite类，实现拷贝
	 * @param scrFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyByBuffered(File scrFile,File destFile)throws IOException{
		if(!scrFile.exists()){
			throw new IllegalArgumentException(scrFile+"不存在");
		}
		if(scrFile.isDirectory()){
			throw new IllegalArgumentException(scrFile+"不是文件");
		}
		BufferedReader br=new BufferedReader(
					new InputStreamReader(new FileInputStream(scrFile)));
		BufferedWriter bw=new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(destFile)));
		String line;
		while((line=br.readLine())!=null){
			bw.write(line);
			//手动添加换行
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
