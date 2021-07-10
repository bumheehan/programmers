package programmers.level1;

public class 이상한_문자_만들기 {
  public String solution(String s) {
    int dif = 'A' - 'a';
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (char a : s.toLowerCase().toCharArray()) {
      if (a == ' ') {
        sb.append(a);
        i = 0;
        continue;
      } else {
        if (i % 2 == 0) {
          sb.append((char) (a + dif));
        } else {
          sb.append(a);
        }
      }
      i++;

    }
    System.out.println(sb.toString());
    return sb.toString();
  }
}
