package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nQueens {
    List<List<String>> res = new ArrayList<>();
    List<String> curBoard = new ArrayList<>();
    boolean[] occupied;

    private void backTrack(int n, int count) {
        if (count == 0) {
            if (curBoard.size() == n) {
                res.add(new ArrayList<>(curBoard));
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (occupied[i]) continue;

            int curRow = curBoard.size() - 1;
            int counter = 1;
            boolean abandon = false;
            while (curRow >= 0) {
                String prevRow = curBoard.get(curRow);

                if(i-counter >= 0 && prevRow.charAt(i-counter) == 'Q') {
                    abandon = true;
                    break;
                }
                if(i+counter < n && prevRow.charAt(i+counter) == 'Q') {
                    abandon = true;
                    break;
                }
                curRow--;
                counter++;
            }
            if (abandon) continue;

            char[] bytes = new char[n];
            Arrays.fill(bytes, '.');
            String str = new String(bytes);
            str = str.substring(0, i) + "Q" + str.substring(i + 1);
            occupied[i] = true;
            curBoard.add(str);
            backTrack(n, count-1);
            occupied[i] = false;
            if (curBoard.size() > 0) {
                curBoard.remove(curBoard.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        nQueens obj = new nQueens();
        int n = 5;
        obj.occupied = new boolean[n];
        obj.backTrack(n, n);
        System.out.println(obj.res);
    }
}
