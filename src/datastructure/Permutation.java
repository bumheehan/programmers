package datastructure;

import java.util.Arrays;

public class Permutation {

  public static void permute(int[] arr, int n) {
    if (n == arr.length) {
      Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
      System.out.println();
      return;
    }
    for (int i = n; i < arr.length; i++) {
      swap(arr, i, n);
      permute(arr, n + 1);
      swap(arr, i, n);
    }
  }

  public static void swap(int[] arr, int idx1, int idx2) {
    if (idx1 == idx2)
      return;

    int c = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = c;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    permute(arr, 0);
  }
}
