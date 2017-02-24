package com.onurusta.hashcode2017;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Launcher {

	public static void main(String[] args) {
		String[] fileNames = { "me_at_the_zoo", "trending_today", "videos_worth_spreading", "kittens" };
		String filePath = "/home/onurus/Desktop/";

		System.out.println("*********************************");
		for (String fileName : fileNames) {
			String inputFileName = filePath + fileName + ".in";
			String outputFileName = filePath + fileName + ".out";
			System.out.println("***\tSolution For : " + fileName);
			long l1 = System.currentTimeMillis();
			ProblemDefinition problemDefinition = null;
			try (Stream<String> stream = Files.lines(Paths.get(inputFileName))) {
				problemDefinition = new ProblemDefinition(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}

			long l2 = System.currentTimeMillis();
			System.out.println("***\t\tConstruction Time : " + (l2 - l1) + memory());

			l1 = System.currentTimeMillis();
			for (Cache cache : problemDefinition.caches) {
				cache.solve();
			}
			l2 = System.currentTimeMillis();
			System.out.println("***\t\t Solve Time : " + (l2 - l1) + memory());

			l1 = System.currentTimeMillis();
			new SolutionWritter().writeSolutionToFile(outputFileName);
			l2 = System.currentTimeMillis();
			System.out.println("***\t\t Write Time : " + (l2 - l1) + memory());

			System.out.println("*********************************");

		}

	}

	private static String memory() {
		return "\t memory:" + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024)
				+ "MB";
	}
}
