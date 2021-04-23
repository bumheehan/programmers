package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 소수_만들기 {

  public int solution(int[] nums) {

    List<Integer> prime = new ArrayList<>();
    // 1000+999+998 총 3천까지 소수 체크
    int limit = (int) Math.sqrt(3000) + 1;
    prime.add(2);
    for (int i = 3; i < 3000; i += 2) {
      boolean primeChk = true;
      for (int j = 0; j < prime.size(); j++) {
        int primeNum = prime.get(j);
        if (primeNum > limit) {
          break;
        }
        if (i % primeNum == 0) {
          primeChk = false;
          break;
        }
      }
      if (primeChk) {
        prime.add(i);
      }
    }
    int answer = 0;

    // 간단하게 for문 3개쓰면 풀림 개수가 50개 이하
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          int sum = nums[i] + nums[j] + nums[k];
          if (prime.indexOf((Integer) sum) >= 0) {
            System.out.println(String.format("i : %d, j : %d, k : %d", i, j, k));
            answer++;
          }
        }
      }
    }
    System.out.println(answer);
    return answer;
  }

  public static void main(String[] args) {
    int[] test = {1, 2, 7, 6, 4};
    new 소수_만들기().solution(test);

  }
}
