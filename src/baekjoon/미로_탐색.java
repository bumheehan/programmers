package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로_탐색 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][][] nodes = new int[n][m][5];
    for (int i = 0; i < n; i++) {
      String s = sc.next();
      for (int j = 0; j < m; j++) {
        nodes[i][j][0] = i;
        nodes[i][j][1] = j;
        nodes[i][j][2] = s.charAt(j) - (int) '0';
      }
    }
    Queue<int[]> qu = new LinkedList<>();

    //root 
    qu.add(nodes[0][0]);
    nodes[0][0][3] = 1;

    while (!qu.isEmpty()) {
      int[] node = qu.poll();

      //logic
      if (node[0] == n - 1 && node[1] == m - 1) {
        System.out.println(node[4] + 1);
        return;
      }

      //add
      int r = 0;
      int c = 0;
      //top
      r = (node[0] - 1);
      c = node[1];
      if (r >= 0) {
        if (nodes[r][c][2] == 1 && nodes[r][c][3] != 1) {
          nodes[r][c][4] = node[4] + 1;
          nodes[r][c][3] = 1;
          qu.add(nodes[r][c]);
        }
      }
      //bottom
      r = (node[0] + 1);
      c = node[1];
      if (r < n) {
        if (nodes[r][c][2] == 1 && nodes[r][c][3] != 1) {
          nodes[r][c][4] = node[4] + 1;
          nodes[r][c][3] = 1;
          qu.add(nodes[r][c]);
        }
      }
      //left
      r = node[0];
      c = node[1] - 1;
      if (c >= 0) {
        if (nodes[r][c][2] == 1 && nodes[r][c][3] != 1) {
          nodes[r][c][4] = node[4] + 1;
          nodes[r][c][3] = 1;
          qu.add(nodes[r][c]);
        }
      }
      //
      r = node[0];
      c = node[1] + 1;
      if (c < m) {
        if (nodes[r][c][2] == 1 && nodes[r][c][3] != 1) {
          nodes[r][c][4] = node[4] + 1;
          nodes[r][c][3] = 1;
          qu.add(nodes[r][c]);
        }
      }
    }
  }
}
