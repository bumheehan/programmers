package programmers.level1;

import java.time.LocalDate;

public class _2016년 {

  class Solution {
    public String solution(int a, int b) {
      LocalDate date = LocalDate.of(2016, a, b);
      return date.getDayOfWeek().name().substring(0, 3);
    }
  }
}
