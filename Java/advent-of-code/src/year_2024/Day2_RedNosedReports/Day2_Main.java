package year_2024.Day2_RedNosedReports;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Day2_Main {

    private static Day2_RedNosedReports_Part1 part1 = new Day2_RedNosedReports_Part1();
    private static Day2_RedNosedReports_Part2 part2 = new Day2_RedNosedReports_Part2();

    public static void main(String[] args) {
        String filename = VariablesGeneralUsages.getFilename();
        InputStream inputStream = Day2_RedNosedReports_Part1.class.getClassLoader().getResourceAsStream(filename);

        List<String> allPuzzleContent = new ArrayList<>();
        allPuzzleContent = populateInputArray(inputStream, allPuzzleContent);

        HashMap<Integer, ArrayList<Integer>> reportList = VariablesGeneralUsages.getReportList();
        reportList = populateReportList(allPuzzleContent);

        part1.resolution(reportList);
        part2.resolution(reportList);
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

    private static HashMap<Integer, ArrayList<Integer>> populateReportList (List<String> allPuzzleContent) {
        HashMap<Integer, ArrayList<Integer>> reportList = new HashMap<Integer, ArrayList<Integer>>();
        int keyCount = 0;
        for (String s : allPuzzleContent) {
            String[] report = s.split(" ");
            Integer[] reportNumbers = new Integer[report.length];

            for (int i = 0; i < report.length; i++) {
                reportNumbers[i] = Integer.parseInt(report[i]);
            }

            reportList.put(keyCount, new ArrayList<>(Arrays.asList(reportNumbers)));

            keyCount++;
        }

        return reportList;
    }
}
