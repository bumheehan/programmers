package programmers.level1;

public class 가운데_글자_가져오기 {
  public String solution(String s) {
    int mid = s.length() / 2;
    if (s.length() % 2 == 0) {
      return s.substring(mid - 1, mid + 1);
    } else {
      return s.substring(mid, mid + 1);
    }
  }
}
