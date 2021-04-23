package programmers.level1;

public class 문자열_다루기_기본 {

  public boolean solution(String s) {
    boolean answer = false;

    if (s.length() == 4 || s.length() == 6) {
      answer = true;
      for (int i = 0; i < s.length(); i++) {
        char ele = s.charAt(i);
        if (ele < 48 || ele > 57) {
          answer = false;
          break;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    int down = '0';
    int up = '9';
    System.out.println(up);
  }
}
