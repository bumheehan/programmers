package programmers.level1;

public class 수박수박 {
  public String solution(int n) {
    char[] data = {'수', '박'};
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        sb.append(data[0]);
      } else {
        sb.append(data[1]);
      }
    }
    return sb.toString();
  }

}
