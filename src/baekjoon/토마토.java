package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[][] tomato = new int[m][n];
        Queue<int[]> qu = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                tomato[i][j] = Integer.parseInt(line[j]);
                if (tomato[i][j] == 1) {
                    qu.add(new int[] {i, j, 0});
                }
            }
        }
        int[][] relAdj = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxCnt = 0;
        while (!qu.isEmpty()) {
            int[] node = qu.poll();


            for (int i = 0; i < relAdj.length; i++) {
                int x = node[0] + relAdj[i][0];
                int y = node[1] + relAdj[i][1];
                int count = node[2] + 1;
                if (x < m && x >= 0 && y < n && y >= 0) {
                    if (tomato[x][y] == 0) {
                        tomato[x][y] = count;
                        if (count > maxCnt) {
                            maxCnt = count;
                        }
                        qu.add(new int[] {x, y, count});
                    }
                }
            }
        }


        //check
        Loop1: for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tomato[i][j] == 0) {
                    maxCnt = -1;
                    break Loop1;
                }
            }
        }
        System.out.println(maxCnt);


    }

}
