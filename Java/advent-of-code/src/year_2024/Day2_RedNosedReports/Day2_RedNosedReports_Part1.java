package year_2024.Day2_RedNosedReports;

import java.util.ArrayList;
import java.util.HashMap;

public class Day2_RedNosedReports_Part1 {

    public Day2_RedNosedReports_Part1() {
    }

    public void resolution (HashMap<Integer, ArrayList<Integer>> reportList) {
        int countSafeReports = 0;

        for (Integer key : reportList.keySet()) {
            ArrayList<Integer> reportData = reportList.get(key);
            boolean isSafe = true;
            boolean isAdding = false;
            boolean isSubtracting = false;

            for (int i = 0; i < reportData.size(); i++) {
                if (isSafe) {
                    if (i+1 >= reportData.size()) {
                        break;
                    } else {
                        Integer differenceFromNextNumber = reportData.get(i) - reportData.get(i+1);

                        //data is subtracting
                        if (differenceFromNextNumber >= 1 && differenceFromNextNumber <= 3) {
                            isSubtracting = true;
                        }
                        //data is adding
                        else if (differenceFromNextNumber <= -1 && differenceFromNextNumber >= -3) {
                            isAdding = true;
                        } else {
                            isSafe = false;
                            break;
                        }
                    }
                }

                if (isSubtracting && isAdding) {
                    isSafe = false;
                    break;
                }
            }

            if (isSafe) {
                countSafeReports++;
            }
        }

        System.out.println("Total safe reports (part 1): " + countSafeReports);
    }
}
