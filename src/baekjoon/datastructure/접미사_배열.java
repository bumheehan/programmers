package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 접미사_배열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Set<String> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = line.length() - 1; i >= 0; i--) {
            sb.append(line.charAt(i));
            set.add(new StringBuilder(sb).reverse().toString());
        }
        StringBuilder ret = new StringBuilder();

        for (String a : set) {
            if (ret.length() > 0) {
                ret.append("\n");
            }
            ret.append(a);
        }
        pln(ret.toString());


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
