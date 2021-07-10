package programmers.level1;

public class 정수_제곱근_판별 {
  public long solution(long n) {
    int sqrt = (int) Math.sqrt(n);
    return (long) Math.pow(sqrt, 2) == n ? (long) Math.pow(sqrt + 1, 2) : -1;
  }
}
