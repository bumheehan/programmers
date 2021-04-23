package programmers.level1;

import java.util.Arrays;

public class 나누어_떨어지는_숫자_배열 {
  public int[] solution(int[] arr, int divisor) {
    int[] zero = {-1};
    int[] ret = Arrays.stream(arr).filter(s -> s % divisor == 0).sorted().toArray();
    return ret.length == 0 ? zero : ret;
  }
}
