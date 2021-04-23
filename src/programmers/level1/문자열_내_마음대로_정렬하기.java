package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열_내_마음대로_정렬하기 {

  public String[] solution(String[] strings, int n) {
    Arrays.sort(strings, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        int compare = Character.compare(o1.charAt(n), o2.charAt(n));
        if (compare == 0) {
          return o1.compareTo(o2);
        } else {
          return compare;
        }
      }
    });
    return strings;
  }
}
