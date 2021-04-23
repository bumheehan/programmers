package programmers.level1;

public class 두_정수_사이의_합 {
  public long solution(int a, int b) {
    int up = 0;
    int down = 0;
    if (a > b) {
      up = a;
      down = b;
    } else {
      down = a;
      up = b;
    }

    long sum = 0;
    for (int i = down; i <= up; i++) {
      sum += i;
    }
    return sum;
  }
}
