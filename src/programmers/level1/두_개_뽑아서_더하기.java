package programmers.level1;

import java.util.Set;
import java.util.TreeSet;

public class 두_개_뽑아서_더하기 {

  public int[] solution(int[] numbers) {
    Set<Integer> set = new TreeSet<>();
    combination(numbers, 0, 1, set);
    return set.stream().mapToInt(s -> s).toArray();
  }

  public void combination(int[] arr, int depth, int limit, Set<Integer> set) {
    if (depth > limit) {
      int sum = 0;
      for (int i = 0; i < depth; i++) {
        sum += arr[i];
      }
      set.add(sum);
      return;
    }
    for (int i = depth; i < arr.length; i++) {
      swap(arr, depth, i);
      combination(arr, depth + 1, limit, set);
      swap(arr, i, depth);
    }
  }

  public void swap(int[] arr, int i, int j) {
    int c = arr[i];
    arr[i] = arr[j];
    arr[j] = c;
  }

  public static void main(String[] args) {

    int[] aa = {5, 0, 2, 7};
    int[] solution = new 두_개_뽑아서_더하기().solution(aa);
    System.out.println();
  }
}
