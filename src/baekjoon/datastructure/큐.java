package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = nextInt(br);
        Deque<Integer> qu = new LinkedList<>();
        while (cnt-- > 0) {
            String[] data = nextStringArr(br, " ");
            switch (data[0]) {
                case "push":
                    qu.add(Integer.parseInt(data[1]));
                    break;
                case "pop":
                    if (qu.isEmpty()) {
                        pln(-1);
                    } else {
                        pln(qu.poll());
                    }
                    break;
                case "size":
                    pln(qu.size());
                    break;
                case "front":
                    if (qu.isEmpty()) {
                        pln(-1);
                    } else {
                        pln(qu.peek());
                    }
                    break;
                case "back":
                    if (qu.isEmpty()) {
                        pln(-1);
                    } else {
                        pln(qu.peekLast());
                    }
                    break;
                case "empty":
                    pln(qu.isEmpty() ? 1 : 0);
                    break;

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
