package year_2024.Day1_HistorianHysteria;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Day1_Main {

    private static int[] firstList;
    private static int[] secondList;
    private static Day1_HistorianHysteria_Part1 part1 = new Day1_HistorianHysteria_Part1();
    private static Day1_HistorianHysteria_Part2 part2 = new Day1_HistorianHysteria_Part2();


    public static void main(String[] args) {
        String filename = VariablesGeneralUsages.getFilename();
        InputStream inputStream = Day1_HistorianHysteria_Part1.class.getClassLoader().getResourceAsStream(filename);

        List<String> allPuzzleContent = new ArrayList<>();
        allPuzzleContent = populateInputArray(inputStream, allPuzzleContent);

        firstList = new int[allPuzzleContent.size()];
        secondList = new int[allPuzzleContent.size()];

        populateFirstAndSecondList(allPuzzleContent);

        VariablesGeneralUsages.setFirstList(firstList);
        VariablesGeneralUsages.setSecondList(secondList);

        part1.resolution();

        part2.resolution();
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

    private static void populateFirstAndSecondList (List<String> allPuzzleContent) {
        for (int i = 0; i < allPuzzleContent.size(); i++) {
            int[] indexOfSpaces = new int[2];
            indexOfSpaces[0] = allPuzzleContent.get(i).indexOf(" ");
            indexOfSpaces[1] = allPuzzleContent.get(i).lastIndexOf(" ");

            String firstNumber = allPuzzleContent.get(i).substring(0, indexOfSpaces[0]);
            String secondNumber = allPuzzleContent.get(i).substring(indexOfSpaces[1]+1, allPuzzleContent.get(i).length());

            firstList[i] = Integer.parseInt(firstNumber);
            secondList[i] = Integer.parseInt(secondNumber);
        }
    }
}
