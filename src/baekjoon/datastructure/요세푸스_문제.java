package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스_문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nextIntArr = nextIntArr(br, " ");

        Queue<Integer> list = new LinkedList<>();

        for (int i = 0; i < nextIntArr[0]; i++) {
            list.add(i + 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 0;
        while (!list.isEmpty()) {
            Integer first = list.poll();
            if (idx < nextIntArr[1] - 1) {
                list.add(first);
                idx++;
            } else {
                idx = 0;
                sb.append(first);
                sb.append(", ");
            }
        }
        for (int i = 0; i < nextIntArr.length; i++) {

        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        pln(sb.toString());



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
