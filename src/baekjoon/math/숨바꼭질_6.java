package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숨바꼭질_6 {
    //    3 0
    //    14 21 28
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = nextIntArr(br, " ");
        int[] b = nextIntArr(br, " ");

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < b.length; i++) {
            b[i] = b[i] > a[1] ? b[i] - a[1] : a[1] - b[i];
            if (min > b[i]) {
                min = b[i];
            }
        }
        if (a[0] == 1) {
            min = b[0];
        }
        int mingcd = Integer.MAX_VALUE;
        for (int i = 0; i < b.length; i++) {
            int gcd = gcd(b[i], min);
            if (gcd < mingcd) {
                mingcd = gcd;
            }
        }
        pln(mingcd);

    }

    public static int gcd(int data1, int data2) {

        int a = Math.max(data1, data2);
        int b = Math.min(data1, data2);
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
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
