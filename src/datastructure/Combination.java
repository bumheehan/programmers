package datastructure;

public class Combination {

  public static void combination(int[] arr, int n, int k) {

    if (n == k) {
      for (int i = 0; i < n; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }
    for (int i = n; i < arr.length; i++) {
      swap(arr, i, n);
      combination(arr, n + 1, k);
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
    int[] arr = {1, 2, 3, 4};
    combination(arr, 0, 3);
  }
}
