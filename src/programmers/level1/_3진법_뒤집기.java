package programmers.level1;

public class _3진법_뒤집기 {


  public int solution(int n) {

    String three = Integer.toString(n, 3);
    char[] threeChars = three.toCharArray();
    char[] inverseChars = new char[threeChars.length];
    int j = 0;
    for (int i = threeChars.length - 1; i >= 0; i--) {
      inverseChars[j++] = threeChars[i];
    }
    String inverse = String.valueOf(inverseChars);

    return Integer.parseInt(inverse, 3);
  }


  public static void main(String[] args) {
    new _3진법_뒤집기().solution(20132);
  }
}
