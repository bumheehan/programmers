package programmers.level3;

import java.util.HashMap;
import java.util.Map;

// 다른 방법으로 풀어봄
public class 단어_변환2 {
  int min = Integer.MAX_VALUE;
  Map<String, Boolean> memory = new HashMap<>();
  Map<String, Boolean> ansMemory = new HashMap<>();

  public int solution(String begin, String target, String[] words) {
    boolean cont = false;
    for (int i = 0; i < words.length; i++) {
      if (target.equals(words[i])) {
        cont = true;
        break;
      }
    }
    if (!cont) {
      return 0;
    }
    permute(begin, target, words, 0);
    return min;
  }


  public void permute(String begin, String target, String[] words, int n) {
    if (n >= words.length - 1) {
      return;
    }
    String concat = concat(begin, target);
    if (ansMemory.containsKey(concat)) {
      if (ansMemory.get(concat)) {
        if (min > n) {
          min = n;
        }
        return;
      }
    } else {
      boolean res = begin.equals(target);
      ansMemory.put(concat, res);
      if (res) {
        if (min > n) {
          min = n;
        }
        return;
      }
    }
    for (int i = n; i < words.length; i++) {
      if (check(begin, words[i])) {
        swap(words, i, n);
        permute(words[n], target, words, n + 1);
        swap(words, i, n);
      }
    }

  }

  public void swap(String[] words, int idx1, int idx2) {
    if (idx1 == idx2) {
      return;
    }
    String c = words[idx1];
    words[idx1] = words[idx2];
    words[idx2] = c;
  }

  public String concat(String a, String b) {
    int i = a.compareTo(b);
    String concat = null;
    if (i > 0) {
      concat = a + b;
    } else {
      concat = b + a;
    }
    return concat;
  }

  public boolean check(String a, String b) {
    String concat = concat(a, b);
    Boolean cache = memory.get(concat);
    if (cache != null) {
      return cache;
    }


    if (a.length() != b.length()) {
      memory.put(concat, false);
      return false;
    }
    int count = 0;
    char[] acharA = a.toCharArray();
    char[] bcharA = b.toCharArray();
    for (int j = 0; j < acharA.length; j++) {
      if (acharA[j] != bcharA[j]) {
        count++;
        if (count > 1) {
          memory.put(concat, false);
          return false;
        }
      }
    }
    memory.put(concat, true);
    return true;
  }
}
