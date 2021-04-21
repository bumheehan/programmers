package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 같은_숫자는_싫어 {
  public int[] solution(int[] arr) {

    List<Integer> list = new ArrayList<>();
    if (arr.length > 0) {
      list.add(arr[0]);
      for (int i = 1; i < arr.length; i++) {
        if (list.get(list.size() - 1) != arr[i]) {
          list.add(arr[i]);
        }
      }
    }

    return list.stream().mapToInt(s -> s).toArray();
  }

  public static void main(String[] args) {


  }

}
