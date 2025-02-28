package year_2024.Day1_HistorianHysteria;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Day1_HistorianHysteria_Part1 {

    private static VariablesGeneralUsages variables = new VariablesGeneralUsages();

    public Day1_HistorianHysteria_Part1() {
    }

    public void resolution() {
        int totalDistance = 0;

        int[] firstList = variables.getFirstList();
        int[] secondList = variables.getSecondList();

        firstList = orderArray(firstList);
        secondList = orderArray(secondList);

        totalDistance = calculateTotalDistance(firstList, secondList, firstList.length);

        // RESULT OF THE PART1 OF THE CHALLENGE
        System.out.println("Total distance: " + totalDistance);
    }

    private static int[] orderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (array[i] < array[j]) {
                        int tempValueI = array[i];

                        array[i] = array[j];
                        array[j] = tempValueI;
                    }
                }
            }
        }
        return array;
    }

    private static List<String> populateInputArray (InputStream inputStream, List<String> array) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                array.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return array;
    }

    private static int calculateTotalDistance (int[] firstList, int[] secondList, int listsSize) {
        int totalDistance = 0;

        for (int j = 0; j < listsSize; j++) {
            if (firstList[j] > secondList[j]) {
                totalDistance += firstList[j] - secondList[j];
            } else {
                totalDistance += secondList[j] - firstList[j];
            }
        }

        return totalDistance;
    }
}
