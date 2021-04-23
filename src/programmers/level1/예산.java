package programmers.level1;

import java.util.Arrays;

public class 예산 {
  // n이 10만개라, 완전탐색 X, N^2 X -> 순열 X
  /* 처음에 완전탐색해서  시간초과 
  public int solution(int[] d, int budget) {
    check(d, budget, 0, 0);
    return max;
  }
  
  int max = Integer.MIN_VALUE;
  
  public void check(int[] d, int budget, int depth, int sum) {
    if (sum <= budget) {
      if (depth > max) {
        max = depth;
        System.out.println(max);
      }
    } else {
      return;
    }
  
    for (int i = depth; i < d.length; i++) {
      swap(d, depth, i);
      check(d, budget, depth + 1, sum + d[depth]);
      swap(d, i, depth);
    }
  
  }
  
  public void swap(int[] d, int i, int j) {
    int a = d[i];
    d[i] = d[j];
    d[j] = a;
  }
  */

  // 작은 값을 정렬해서 낮은거부터 더해나가면 될거라고 다시판단
  public int solution(int[] d, int budget) {
    Arrays.sort(d);
    int sum = 0;
    int i = 0;
    for (; i < d.length; i++) {
      sum += d[i];
      if (sum > budget) {
        break;
      }
    }
    System.out.println(i);
    return i;
  }

  public static void main(String[] args) {
    int[] aa = {2, 2, 3, 3};
    new 예산().solution(aa, 10);
  }
}
