package com.onurusta.hashcode2017;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SolutionWritter {

	public void writeSolutionToFile(String outputFileName) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

			int activeCache = 0;
			for (int i = 0; i < ProblemDefinition.C; i++) {
				if (ProblemDefinition.caches[i].results.size() > 0) {
					activeCache++;
				}
			}

			bw.write(activeCache + "\n");
			for (int i = 0; i < ProblemDefinition.C; i++) {
				List<Integer> list = ProblemDefinition.caches[i].results;
				if (list.size() > 0) {
					bw.write(i + " ");
					for (int j = 0; j < (list.size()); j++) {
						bw.write(list.get(j) + " ");
					}
					bw.write("\n");
				}

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
