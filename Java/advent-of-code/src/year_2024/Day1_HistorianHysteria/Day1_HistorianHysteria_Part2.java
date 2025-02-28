package year_2024.Day1_HistorianHysteria;

public class Day1_HistorianHysteria_Part2 {

    private static VariablesGeneralUsages variables = new VariablesGeneralUsages();

    public Day1_HistorianHysteria_Part2() {
    }

    public void resolution() {
        int similarityScore = 0;

        int[] firstList = variables.getFirstList();
        int[] secondList = variables.getSecondList();

        for (int i = 0; i < firstList.length; i++) {
            int count = 0;
            for (int j = 0; j < firstList.length; j++) {
                if (firstList[i] == secondList[j]) {
                    count++;
                }
            }

            similarityScore += firstList[i] * count;
        }

        System.out.println("Total similarity score: " + similarityScore);
    }
}
