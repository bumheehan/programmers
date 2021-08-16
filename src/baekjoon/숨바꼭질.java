package baekjoon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();
    System.out.println(bfs(x, y));
  }

  public static int bfs(int start, int end) {
    int retVal = 0;
    Queue<Integer> qu = new LinkedList<>();
    Map<Integer, Integer> depth = new HashMap<>();

    depth.put(start, 0);
    qu.add(start);

    while (!qu.isEmpty()) {

      Integer x = qu.poll();

      if (x == end) {
        retVal = depth.get(end);
        break;
      }
      chk(x, x + 1, depth, qu);
      chk(x, x - 1, depth, qu);
      chk(x, x * 2, depth, qu);
    }
    return retVal;

  }

  public static void chk(int preX, int x, Map<Integer, Integer> depth, Queue<Integer> qu) {
    if (x >= 0 && x <= 100000) {
      if (!depth.containsKey(x)) {
        depth.put(x, depth.get(preX) + 1);
        qu.add(x);
      }
    }
  }


}
