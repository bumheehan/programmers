package baekjoon.regex;

import java.util.Scanner;

public class Contact {

    public static void main(String[] args) {
        String regex = "(100+1+|01)+";

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(sc.next().matches(regex) ? "YES" : "NO");
        }
    }
}
