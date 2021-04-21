package programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 완주하지_못한_선수 {
  public String solution(String[] participant, String[] completion) {
    List<String> p = Arrays.asList(participant);
    List<String> c = Arrays.asList(completion);

    String answer = "";

    Collections.sort(p);
    Collections.sort(c);

    for (int i = 0; i < c.size(); i++) {
      if (!c.get(i).equals(p.get(i))) {
        answer = p.get(i);
        break;
      }
    }
    if ("".equals(answer)) {
      answer = p.get(p.size() - 1);
    }

    return answer;
  }

  // 다른 사람
  public String solution2(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String, Integer> hm = new HashMap<>();
    for (String player : participant)
      hm.put(player, hm.getOrDefault(player, 0) + 1);
    for (String player : completion)
      hm.put(player, hm.get(player) - 1);

    for (String key : hm.keySet()) {
      if (hm.get(key) != 0) {
        answer = key;
      }
    }
    return answer;
  }
}
