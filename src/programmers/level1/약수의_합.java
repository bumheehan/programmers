package programmers.level1;

public class 약수의_합 {
  public static int solution(int n) {

    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int minNum = (int) Math.sqrt(n);
    int sum = n + 1;
    for (int i = 2; i <= minNum; i++) {
      if (n % i == 0) {
        int next = n / i;
        if (next == i) {
          sum += i;
        } else {
          sum += (i + next);
        }
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(solution(1));
  }
}
