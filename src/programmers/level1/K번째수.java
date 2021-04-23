package programmers.level1;

import java.util.Arrays;

public class K번째수 {
  public int[] solution(int[] array, int[][] commands) {

    int[] retVal = new int[commands.length];
    for (int i = 0; i < commands.length; i++) {
      int[] item = commands[i];
      // 복사
      int[] arr = new int[item[1] - item[0] + 1];
      for (int j = 0; j < arr.length; j++) {
        arr[j] = array[item[0] + j - 1];
      }
      Arrays.sort(arr);
      retVal[i] = arr[item[2] - 1];
    }

    return retVal;
  }
}
