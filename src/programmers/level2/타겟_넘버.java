package programmers.level2;

public class 타겟_넘버 {
  public int solution(int[] numbers, int target) {
    dfsR(numbers, 0, 0, target);
    return count;
  }

  int count = 0;

  public void dfsR(int[] numbers, int depth, int sum, int target) {
    if (numbers.length == depth) {
      if (sum == target) {
        count++;
      }
      return;
    }

    int ele = numbers[depth];

    dfsR(numbers, depth + 1, sum + ele, target);
    dfsR(numbers, depth + 1, sum - ele, target);


  }
}
