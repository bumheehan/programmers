package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 소수_찾기 {
  public int solution(int n) {

    List<Integer> primeList = new ArrayList<>();
    if (n < 2) {
      return 0;
    }
    primeList.add(2);
    for (int i = 3; i <= n; i += 2) {
      boolean chk = true;
      for (int j : primeList) {
        int pow = j * j;
        if (i < pow) {
          break;
        }
        if (i % j == 0) {
          chk = false;
          break;
        }
      }
      if (chk) {
        primeList.add(i);
      }

    }
    return primeList.size();
  }

  public static void main(String[] args) {
    new 소수_찾기().solution(10);
  }
}
