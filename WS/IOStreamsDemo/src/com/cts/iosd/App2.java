package com.cts.iosd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("File Name: ");
		String fileName = scan.nextLine();

		Path filePath = Paths.get(fileName);

		try {
			List<String> data = Files.readAllLines(filePath);
			data.stream().forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
