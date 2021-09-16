package baekjoon.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class 염색체 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        Pattern pa = Pattern.compile("^[A-F]?A+F+C+[A-F]?$");
        while (cnt-- > 0) {
            if (pa.matcher(br.readLine()).matches()) {
                System.out.println("Infected!");
            } else {
                System.out.println("Good");
            }
        }

    }
}
