package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
  public int[] solution(int[] answers) {
    int[] aa = {1, 2, 3, 4, 5};
    int[] bb = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] cc = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int a = 0;
    int b = 0;
    int c = 0;
    int max = 0;
    for (int i = 0; i < answers.length; i++) {
      int d = answers[i];
      // 1번
      if (aa[i % 5] == d) {
        a++;
        if (a > max) {
          max = a;
        }
      }
      // 2번
      if (bb[i % 8] == d) {
        b++;
        if (b > max) {
          max = b;
        }
      }
      // 3번
      if (cc[i % 10] == d) {
        c++;
        if (c > max) {
          max = c;
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    if (max == a) {
      result.add(1);
    }
    if (max == b) {
      result.add(2);
    }
    if (max == c) {
      result.add(3);
    }

    return result.stream().mapToInt(s -> s).toArray();
  }
}
