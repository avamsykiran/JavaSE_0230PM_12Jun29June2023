package com.cts.iosd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cts.iosd.model.Consumer;

public class App3 {

	public static void main(String[] args) {

		Path filePath = Paths.get("./Consumers.csv");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Function<String, Consumer> mapper = line -> {
			String[] fields = line.split(",");
			return new Consumer(fields[0], LocalDate.parse(fields[1], formatter), fields[2], fields[3], fields[4]);
		};

		try {
			List<String> data = Files.readAllLines(filePath);
			List<Consumer> consumers = data.stream().map(mapper).collect(Collectors.toList());
			consumers.stream().forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
