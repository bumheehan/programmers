package programmers.level1;

public class 자릿수_더하기 {
  public int solution(int n) {
    int answer = 0;

    for (char a : Integer.toString(n).toCharArray()) {
      answer += Integer.parseInt(String.valueOf(a));
    }

    return answer;
  }
}
