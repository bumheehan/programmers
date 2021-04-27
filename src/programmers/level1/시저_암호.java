package programmers.level1;

import java.util.stream.Collectors;

public class 시저_암호 {
  public String solution(String s, int n) {

    return s.chars().mapToObj(a -> {
      if (a <= 122 && a >= 97) {
        return String.valueOf((char) ((a - 97 + n) % 26 + 97));
      } else if (a <= 90 && a >= 65) {
        return String.valueOf((char) ((a - 65 + n) % 26 + 65));
      } else {
        return String.valueOf((char) a);
      }
    }).collect(Collectors.joining());
  }

  public static void main(String[] args) {
    System.out.println(new 시저_암호().solution("yY", 1));
  }
}
