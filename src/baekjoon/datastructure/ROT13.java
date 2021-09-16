package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ROT13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        br.readLine().chars().forEach(s -> {
            if (s >= a && s <= z) {
                if ((s + 13) > z) {
                    sb.append((char) (s + 13 - z + a - 1));
                } else {
                    sb.append((char) (s + 13));
                }
            } else if (s >= A && s <= Z) {
                if ((s + 13) > Z) {
                    sb.append((char) (s + 13 - Z + A - 1));
                } else {
                    sb.append((char) (s + 13));
                }
            } else {
                sb.append((char) s);
            }


        });
        System.out.println(sb.toString());

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
