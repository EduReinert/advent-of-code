package year_2024.Day1_HistorianHysteria;

public class VariablesGeneralUsages {

    public static String filename = "2024_day1_puzzleInput.txt";
    public static int[] firstList;
    public static int[] secondList;

    public VariablesGeneralUsages() {
    }

    public int[] getFirstList() {
        return firstList;
    }

    public static void setFirstList(int[] firstList) {
        VariablesGeneralUsages.firstList = firstList;
    }

    public int[] getSecondList() {
        return secondList;
    }

    public static void setSecondList(int[] secondList) {
        VariablesGeneralUsages.secondList = secondList;
    }

    public static String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        VariablesGeneralUsages.filename = filename;
    }
}
