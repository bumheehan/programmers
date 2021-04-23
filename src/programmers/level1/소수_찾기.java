package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 소수_찾기 {
  public int solution(int n) {

    List<Integer> primeList = new ArrayList<>();
    primeList.add(2);
    int limit = (int) Math.sqrt(n) + 1;
    for (int i = 3; i < n; i += 2) {
      boolean chk = true;
      for (int j : primeList) {
        if (j > limit) {
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

    int answer = 0;
    return answer;
  }
}
