package programmers.level1;

public class 자연수_뒤집어_배열로_만들기 {
  public int[] solution(long n) {
    String[] split = Long.toString(n).split("");
    int[] answer = new int[split.length];
    for (int i = 0; i < split.length; i++) {
      answer[i] = Integer.parseInt(split[split.length - 1 - i]);
    }
    return answer;
  }
}
