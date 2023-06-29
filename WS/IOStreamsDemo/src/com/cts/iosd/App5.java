package com.cts.iosd;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.cts.iosd.model.Employee;

public class App5 {

	public static void main(String[] args) {

		final String fileName = "./emps.data";

		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fileName))){
			List<Employee> emps = (List<Employee>) objIn.readObject(); //DESERIALIZATION
			emps.stream().forEach(System.out::println);
		}catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		
	}
}
