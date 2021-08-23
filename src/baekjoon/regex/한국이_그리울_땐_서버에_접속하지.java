package baekjoon.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class 한국이_그리울_땐_서버에_접속하지 {

    public static void main(String[] args) {
        //        3
        //        a*d
        //        abcd
        //        anestonestod
        //        facebook

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String regex = "^" + sc.next().replace("*", "\\w*") + "$";
        Pattern pattern = Pattern.compile(regex);


        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            String test = sc.next();
            if (pattern.matcher(test).matches()) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
        }

        System.out.println(sb.toString());

    }
}
