package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의_합_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] setting = nextIntArr(br, " ");
        int[] testArr = nextIntArr(br, " ");
        System.out.println(twoPointer(setting, testArr));

    }

    public static int twoPointer(int[] setting, int[] test) {

        //포인터
        int i = 0;
        int j = 0;

        //카운트
        int retVal = 0;

        //초기값
        int sum = test[i];

        while (i < test.length) {

            if (sum > setting[1]) {
                sum -= test[i++];
            } else {
                if (sum == setting[1]) {
                    retVal++;
                }
                ++j;
                if (j == test.length) {
                    break;
                }
                sum += test[j];
            }

        }
        return retVal;

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
