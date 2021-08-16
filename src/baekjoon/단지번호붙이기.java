package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 단지번호붙이기 {
  static int[] rowOffset = {-1, 1, 0, 0};
  static int[] colOffset = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());

      int[][][] nodes = new int[n][n][5];
      for (int i = 0; i < n; i++) {
        String s = br.readLine();
        for (int j = 0; j < n; j++) {
          nodes[i][j][0] = i;
          nodes[i][j][1] = j;
          nodes[i][j][2] = s.charAt(j) - (int) '0';
        }
      }
      List<Integer> ret = new ArrayList<>();

      for (int i = 0; i < nodes.length; i++) {
        for (int j = 0; j < nodes.length; j++) {
          if (nodes[i][j][2] == 1 && nodes[i][j][3] != 1) {
            ret.add(bfs(nodes, nodes[i][j]));
          }
        }
      }
      System.out.println(ret.size());
      ret.stream().sorted().forEach(System.out::println);

    }


  }

  public static int bfs(int[][][] nodes, int[] root) {
    Queue<int[]> qu = new LinkedList<>();
    int count = 1;
    //root 
    qu.add(root);
    root[3] = 1;
    int n = nodes.length;
    while (!qu.isEmpty()) {
      int[] node = qu.poll();
      for (int i = 0; i < 4; i++) {
        int r = node[0] + rowOffset[i];
        int c = node[1] + colOffset[i];
        if (r >= 0 && r < n && c >= 0 && c < n) {
          if (nodes[r][c][2] == 1 && nodes[r][c][3] != 1) {
            count++;
            nodes[r][c][3] = 1;
            qu.add(nodes[r][c]);
          }
        }
      }
    }
    return count;
  }
}
