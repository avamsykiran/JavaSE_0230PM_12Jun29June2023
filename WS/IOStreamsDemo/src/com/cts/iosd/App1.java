package com.cts.iosd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("File Name: ");
		String fileName = scan.nextLine();
		
		List<String> data = new ArrayList<>();
		 
		String line = null;
		
		System.out.println("Type data into the file, type '*QUIT*' to STOP: ");
		
		while(!"*QUIT*".equals(line)) {
			line = scan.nextLine();
			if(!"*QUIT*".equals(line)) {
				data.add(line);
			}
		}
		
		Path filePath = Paths.get(fileName);
		try {
			Files.write(filePath, data);
			System.out.println("File saved!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		scan.close();

	}

}
