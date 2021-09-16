package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD_합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = nextInt(br);
        StringBuilder sb = new StringBuilder();
        while (cnt-- > 0) {
            int[] test = nextIntArr(br, " ");
            long sum = 0;
            for (int i = 1; i < test[0]; i++) {
                for (int j = i + 1; j < test[0] + 1; j++) {
                    sum += gcd(test[i], test[j]);
                }
            }
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(sum);
        }
        pln(sb.toString());

    }

    public static int gcd(int a, int b) {
        int min = Math.min(a, b);

        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 0;
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
