package com.leon.charoperation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CharStreamUtils {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("test//ByteStreamUtils.java");
			FileOutputStream fos=new FileOutputStream("test//ByteStreamUtils1.java");
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			OutputStreamWriter osw=new OutputStreamWriter(fos, "utf-8");
			int c;
			while ((c = isr.read()) != -1) {
				osw.write((char)c);
			}
			osw.close();
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
