package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = nextInt(br);
        while (cnt-- > 0) {
            String[] sb = br.readLine().split("");
            int sum = 0;
            boolean chk = true;
            for (int i = 0; i < sb.length; i++) {
                if (sb[i].equals("(")) {
                    sum++;
                } else {
                    sum--;
                }
                if (sum < 0) {
                    chk = false;
                    break;
                }
            }
            if (sum == 0 && chk) {
                pln("YES");
            } else {
                pln("NO");
            }
        }

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
