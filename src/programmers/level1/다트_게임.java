package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 다트_게임 {
  public int solution(String dartResult) {
    List<Integer> score = new ArrayList<>();
    String cache = "";

    for (char a : dartResult.toCharArray()) {

      switch (a) {
        case 'S': {
          score.add((int) Math.pow(Integer.parseInt(cache), 1));
          cache = "";
          break;
        }
        case 'D': {
          score.add((int) Math.pow(Integer.parseInt(cache), 2));
          cache = "";
          break;
        }
        case 'T': {
          score.add((int) Math.pow(Integer.parseInt(cache), 3));
          cache = "";
          break;
        }
        case '*': {
          for (int i = score.size() - 1; i >= score.size() - 2 && i >= 0; i--) {
            score.set(i, score.get(i) * 2);
          }
          break;
        }
        case '#': {
          score.set(score.size() - 1, score.get(score.size() - 1) * -1);
          break;
        }
        default:
          cache += a;
      }
    }

    return score.stream().reduce((b, c) -> {
      return b + c;
    }).get();
  }

  public static void main(String[] args) {
    new 다트_게임().solution("1D2S3T*");
  }
}
