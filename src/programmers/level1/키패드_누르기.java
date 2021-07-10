package programmers.level1;

/**
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * * 0 #
 * 00 01 02
 * 10 11 12
 * 20 21 22
 * 30 31 32
 */
public class 키패드_누르기 {
  public static String solution(int[] numbers, String hand) {

    int lPosition1 = 3;
    int lPosition2 = 0;
    int rPosition1 = 3;
    int rPosition2 = 2;

    StringBuilder sb = new StringBuilder();
    for (int number : numbers) {
      if (number == 0)
        number = 11;
      switch (number) {
        case 1:
        case 4:
        case 7:
          lPosition1 = (number - 1) / 3;
          lPosition2 = (number - 1) % 3;
          sb.append("L");
          break;
        case 3:
        case 6:
        case 9:
          rPosition1 = (number - 1) / 3;
          rPosition2 = (number - 1) % 3;
          sb.append("R");
          break;
        default:
          int position1 = (number - 1) / 3;
          int position2 = (number - 1) % 3;

          int ind = (int) ((Math.abs(lPosition1 - position1) + Math.abs(lPosition2 - position2))
              - (Math.abs(rPosition1 - position1) + Math.abs(rPosition2 - position2)));
          if (ind > 0) {
            rPosition1 = position1;
            rPosition2 = position2;
            sb.append("R");
          } else if (ind < 0) {
            lPosition1 = position1;
            lPosition2 = position2;
            sb.append("L");
          } else {
            if (hand.equals("left")) {
              lPosition1 = position1;
              lPosition2 = position2;
              sb.append("L");
            } else {
              rPosition1 = position1;
              rPosition2 = position2;
              sb.append("R");
            }
          }
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    System.out.println(solution(numbers, "right"));
  }
}
