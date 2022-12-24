package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _8진수_2진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chArr = br.readLine().toCharArray();

        if (chArr.length == 1 && chArr[0] == '0') {
            pln("0");
            return;
        }
        char zero = '0';
        for (int i = chArr.length - 1; i >= 0; i--) {
            int c = chArr[i] - zero;
            StringBuilder sbb = new StringBuilder();
            if (c >= 4) {
                c -= 4;
                sbb.append("1");
            } else {
                sbb.append("0");
            }
            if (c >= 2) {
                c -= 2;
                sbb.append("1");
            } else {
                sbb.append("0");
            }
            if (c >= 1) {
                sbb.append("1");
            } else {
                sbb.append("0");
            }
            if (i == 0) {
                while (sbb.charAt(0) == '0') {
                    sbb.deleteCharAt(0);
                }
            }
            sb.append(sbb.reverse());
        }
        pln(sb.reverse());


    }

    public static int nextInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static int[] nextIntArr(BufferedReader br, String token) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), token);
        int[] retVal = new int[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            retVal[i++] = Integer.parseInt(st.nextToken());
        }
        return retVal;
    }

    public static String[] nextStringArr(BufferedReader br, String token) throws IOException {
        return br.readLine().split(token);
    }

    public static void pln(Object o) {
        System.out.println(o);
    }
}
