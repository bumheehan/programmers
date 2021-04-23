package programmers.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class 폰켓몬 {

  public int solution(int[] nums) {
    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    int select = nums.length / 2;
    return select > set.size() ? set.size() : select;
  }


}
