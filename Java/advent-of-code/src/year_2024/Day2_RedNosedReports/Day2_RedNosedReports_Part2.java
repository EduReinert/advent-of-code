package year_2024.Day2_RedNosedReports;

import java.util.ArrayList;
import java.util.HashMap;

public class Day2_RedNosedReports_Part2 {

    public Day2_RedNosedReports_Part2() {
    }

    public void resolution (HashMap<Integer, ArrayList<Integer>> reportList) {
        int countSafeReports = 0;

        for (Integer key : reportList.keySet()) {
            int badLevelTolerance = 0;
            ArrayList<Integer> reportData = reportList.get(key);
            boolean isSafe = true;
            boolean isAdding = false;
            boolean isSubtracting = false;

            for (int i = 0; i < reportData.size(); i++) {
                if (isSafe) {
                    if (i+1 >= reportData.size()) {
                        break;
                    } else {
                        int differenceFromNextNumber = reportData.get(i) - reportData.get(i+1);

                        //data is subtracting
                        if (differenceFromNextNumber >= 1 && differenceFromNextNumber <= 3) {
                            if (isAdding) {
                                badLevelTolerance++;
                                reportData.remove(i+1);
                                i--;
                            } else {
                                isSubtracting = true;
                            }
                        }
                        //data is adding
                        else if (differenceFromNextNumber <= -1 && differenceFromNextNumber >= -3) {
                            if (isSubtracting) {
                                badLevelTolerance++;
                                reportData.remove(i+1);
                                i--;
                            } else {
                                isAdding = true;
                            }
                        } else {
                            badLevelTolerance++;
                            reportData.remove(i+1);
                            i--;
                        }

                        if (badLevelTolerance > 1) {
                            isSafe = false;
                            break;
                        }
                    }
                }

                if (isSubtracting && isAdding && badLevelTolerance <= 1) {
                    isSafe = false;
                    break;
                }
            }

            if (isSafe) {
                countSafeReports++;
            } else {
                System.out.println("Invalid: " + key);
            }
        }

        System.out.println("Total safe reports (part 2): " + countSafeReports);
    }
}
