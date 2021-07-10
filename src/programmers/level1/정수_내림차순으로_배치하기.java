package programmers.level1;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기 {
  public long solution(long n) {
    char[] charArray = Long.toString(n).toCharArray();
    Arrays.sort(charArray);
    StringBuilder sb = new StringBuilder();
    sb.append(String.valueOf(charArray));
    sb.reverse();
    return Long.parseLong(sb.toString());
  }
}
