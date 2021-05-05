package programmers.level1;

public class 비밀지도 {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    for (int i = 0; i < n; i++) {
      String a = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i])));
      String b = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr2[i])));
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < n; j++) {
        char c = a.charAt(j);
        char d = b.charAt(j);
        if (c == d) {
          if (c == '1') {
            sb.append("#");
          } else {
            sb.append(" ");
          }
        } else {
          sb.append("#");
        }
      }
      answer[i] = sb.toString();
    }
    return answer;
  }

  public static void main(String[] args) {
    int[] a = {46, 33, 33, 22, 31, 50};
    int[] b = {27, 56, 19, 14, 14, 10};
    new 비밀지도().solution(6, a, b);
  }
}
