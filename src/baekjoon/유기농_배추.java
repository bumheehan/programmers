package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농_배추 {
    public static int[][] change = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int m;
        int n;
        int[][] arr;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            arr = new int[m][n];
            int data = sc.nextInt();
            for (int j = 0; j < data; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }
            boolean[][] visited = new boolean[m][n];
            //test

            int count = 0;
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if ((!visited[j][k]) && arr[j][k] == 1) {
                        count++;
                        int[] start = {j, k};
                        bfs(arr, start, visited);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int[][] arr, int[] start, boolean[][] visited) {
        int m = arr.length;
        int n = arr[0].length;


        Queue<int[]> qu = new LinkedList<>();

        qu.add(start);
        visited[start[0]][start[1]] = true;
        while (!qu.isEmpty()) {
            int[] node = qu.poll();
            for (int[] offset : change) {
                int x = node[0] + offset[0];
                int y = node[1] + offset[1];
                if (x >= 0 && y >= 0 && x < m && y < n) {
                    if ((!visited[x][y]) && arr[x][y] == 1) {
                        visited[x][y] = true;
                        int[] next = {x, y};
                        qu.add(next);
                    }
                }
            }
        }


    }

}
