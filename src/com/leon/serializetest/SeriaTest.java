package com.leon.serializetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriaTest {
	
	public static void writeObj(File destfile) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destfile));
		Student stu1 = new Student("366", "leon", 24);
		Student stu2 = new Student("883", "power", 25);
		oos.writeObject(stu1);
		oos.writeObject(stu2);
		oos.flush();
		oos.close();
	}

	public static void readObj(File srcfile) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(srcfile));
		Student stu1 = (Student) ois.readObject();
		Student stu2 = (Student) ois.readObject();
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		ois.close();
	}

	public static void main(String[] args) throws ClassNotFoundException {
		try {
//			writeObj(new File("test/obj.dat"));
			readObj(new File("test/obj.dat"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
