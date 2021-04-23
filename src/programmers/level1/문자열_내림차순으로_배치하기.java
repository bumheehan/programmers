package programmers.level1;

import java.util.Comparator;

public class 문자열_내림차순으로_배치하기 {



  public String solution(String s) {

    StringBuilder sb = new StringBuilder();
    s.chars().boxed().sorted(Comparator.reverseOrder()).forEach(a -> sb.append((char) (int) a));
    return sb.toString();
  }

}
