package programmers.level1;

import java.util.HashMap;
import java.util.Map;

// replaceAll하는건 속도 느릴거같아서 다른방법으로 풀이해봄
public class 숫자_문자열과_영단어 {

  public static int solution(String s) {
    int[] leftWord = {2, 1, 1, 3, 2, 2, 1, 3, 3, 2};
    String[] secondWord = {"ze", "on", "tw", "th", "fo", "fi", "si", "se", "ei", "ni"};
    Map<String, Integer> leftWordMap = new HashMap<>();

    for (int i = 0; i < secondWord.length; i++) {
      leftWordMap.put(secondWord[i], i);
    }


    StringBuilder sb = new StringBuilder();
    StringBuilder alpha = new StringBuilder();
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length;) {
      char cha = charArray[i];
      if (cha >= '0' && cha <= '9') {
        sb.append(cha);
        i++;
        continue;
      }
      alpha.append(cha);

      if (alpha.length() == 2) {
        int appendInt = leftWordMap.get(alpha.toString());
        sb.append(appendInt);
        i += (leftWord[appendInt] + 1);
        alpha.delete(0, 2);
      } else {
        i++;
      }

    }

    return Integer.parseInt(sb.toString());
  }

  public static void main(String[] args) {
    System.out.println(solution("2three45sixseven"));
  }
}
