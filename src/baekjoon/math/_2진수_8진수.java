package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2진수_8진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chArr = br.readLine().toCharArray();

        if (chArr.length == 1 && chArr[0] == '0') {
            pln("0");
            return;
        }
        int sum = 0;
        for (int i = chArr.length - 1; i >= 0; i--) {
            int chkVal = (chArr.length - i) % 3;
            if (chArr[i] != '0') {
                sum += (int) Math.pow(2, chkVal == 0 ? 2 : chkVal - 1);
            }
            if (chkVal == 0) {
                sb.append(sum);
                sum = 0;
            }
        }
        if (sum != 0) {
            sb.append(sum);
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
