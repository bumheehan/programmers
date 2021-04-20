package programmers.level1;

public class 신규_아이디_추천 {
  public String solution(String new_id) {

    StringBuilder sb = new StringBuilder(15);
    char[] charArray = new_id.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char a = charArray[i];
      if (sb.length() == 15) {
        break;
      }
      if (a >= 65 && a <= 90) {
        sb.append((char) (a + 32));
      } else if (a >= 97 && a <= 122) {
        sb.append(a);
      } else if (a >= 48 && a <= 57) {
        sb.append(a);
      } else if (a == 45) {
        sb.append(a);
      } else if (a == 46) {
        if (sb.length() == 0) {
          continue;
        } else if (sb.charAt(sb.length() - 1) == a) {
          continue;
        } else {
          sb.append(a);
        }

      } else if (a == 95) {
        sb.append(a);
      }
    }
    if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 46) {
      sb.deleteCharAt(sb.length() - 1);
    }
    if (sb.length() == 0) {
      sb.append('a');
    }
    while (sb.length() < 3) {
      sb.append(sb.charAt(sb.length() - 1));
    }

    String answer = sb.toString();
    return answer;
  }

  // 맨위 답 , 정규표현식 공부 필요
  public String solution2(String new_id) {
    String answer = "";
    String temp = new_id.toLowerCase();

    temp = temp.replaceAll("[^-_.a-z0-9]", "");
    System.out.println(temp);
    temp = temp.replaceAll("[.]{2,}", ".");
    temp = temp.replaceAll("^[.]|[.]$", "");
    System.out.println(temp.length());
    if (temp.equals(""))
      temp += "a";
    if (temp.length() >= 16) {
      temp = temp.substring(0, 15);
      temp = temp.replaceAll("^[.]|[.]$", "");
    }
    if (temp.length() <= 2)
      while (temp.length() < 3)
        temp += temp.charAt(temp.length() - 1);

    answer = temp;
    return answer;
  }

  public static void main(String[] args) {
    String result = new 신규_아이디_추천().solution("=.=");
    System.out.println(result);
  }
}
