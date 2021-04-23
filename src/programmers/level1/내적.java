package programmers.level1;

public class 내적 {
  public int solution(int[] a, int[] b) {
    int sum = 0;
    for (int i = 0; i < b.length; i++) {
      sum += (a[i] * b[i]);
    }
    return sum;
  }
}
