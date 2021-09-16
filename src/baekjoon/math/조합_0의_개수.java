package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합_0의_개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = nextIntArr(br, " ");

        int a = cal2(arr[0]) - cal2(arr[0] - arr[1]) - cal2(arr[1]);
        int b = cal5(arr[0]) - cal5(arr[0] - arr[1]) - cal5(arr[1]);

        //2000000000 1000000000
        if (a >= 0 && b >= 0) {
            pln(Math.min(a, b));
        } else {
            pln(0);
        }

    }

    public static int cal5(int num) {
        int cnt = 0;
        for (long i = 5; i <= num; i *= 5) {
            cnt += num / i;
        }
        return cnt;
    }

    public static int cal2(int num) {
        int cnt = 0;
        for (long i = 2; i <= num; i *= 2) {
            cnt += num / i;
        }
        return cnt;
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
