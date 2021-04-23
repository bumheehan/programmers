package programmers.level1;

public class 문자열_내_p와_y의_개수 {
  boolean solution(String s) {
    int p = 0;
    int y = 0;

    for (char a : s.toCharArray()) {
      if (a == 'y' || a == 'Y') {
        y++;
      } else if (a == 'p' || a == 'P') {
        p++;
      }
    }

    return p == y;
  }
}
