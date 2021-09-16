package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열_분석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //        소문자, 대문자, 숫자, 공백

        String line = null;
        while ((line = br.readLine()) != null) {
            int[] data = new int[4];

            line.chars().forEach(s -> {
                if (s >= 'a' && s <= 'z') {
                    data[0]++;
                } else if (s >= 'A' && s <= 'Z') {
                    data[1]++;
                } else if (s >= '0' && s <= '9') {
                    data[2]++;
                } else if (s == ' ') {
                    data[3]++;
                }


            });

            pln(data[0] + " " + data[1] + " " + data[2] + " " + data[3]);
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
