package programmers.level1;

public class 로또의_최고_순위와_최저_순위 {
  public int[] solution(int[] lottos, int[] win_nums) {
    int win = 0;
    int re = 0;
    for (int myNum : lottos) {
      if (myNum == 0) {
        re++;
        continue;
      }

      for (int winNum : win_nums) {
        if (myNum == winNum) {
          win++;
          break;
        }
      }
    }

    int max = 7 - (win + re);
    int min = 7 - win;
    int[] answer = new int[2];
    answer[0] = max == 7 ? 6 : max;
    answer[1] = min == 7 ? 6 : min;
    return answer;
  }

  public static void main(String[] args) {
    int[] my = {44, 1, 0, 0, 31, 25};
    int[] lo = {31, 10, 45, 1, 6, 19};
    new 로또의_최고_순위와_최저_순위().solution(my, lo);
  }
}
