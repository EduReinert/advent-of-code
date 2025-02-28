package year_2024.Day2_RedNosedReports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VariablesGeneralUsages {

    private static String filename = "2024_day2_puzzleInput.txt";
    private static HashMap<Integer, ArrayList<Integer>> reportList = new HashMap<Integer, ArrayList<Integer>>();

    public VariablesGeneralUsages() {
    }

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        VariablesGeneralUsages.filename = filename;
    }

    public static HashMap<Integer, ArrayList<Integer>> getReportList() {
        return reportList;
    }

    public static void setReportList(HashMap<Integer, ArrayList<Integer>> reportList) {
        VariablesGeneralUsages.reportList = reportList;
    }
}
