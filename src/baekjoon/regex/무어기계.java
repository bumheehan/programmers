package baekjoon.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class 무어기계 {

    //A 65
    //Z 90
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        while (cnt-- > 0) {
            String regex = br.readLine();
            String test = br.readLine();

            //1번 체크
            if (Pattern.matches(regex, test)) {
                System.out.println("_");
            } else if (!Pattern.matches(regex.replace("_", "."), test)) {
                System.out.println("!");
            } else {
                for (int i = 65; i < 91; i++) {
                    if (Pattern.matches(regex.replace('_', (char) i), test)) {
                        System.out.println((char) i);
                        break;
                    }
                }

            }

        }



    }
}
