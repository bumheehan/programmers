package programmers.level1;

public class 서울에서_김서방_찾기 {
  public String solution(String[] seoul) {
    int i = 0;
    for (; i < seoul.length; i++) {
      String string = seoul[i];
      if ("Kim".equals(string)) {
        break;
      }
    }
    return String.format("김서방은 %d에 있다", i);
  }
}
