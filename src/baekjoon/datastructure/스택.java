package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = nextInt(br);
        Stack<Integer> stack = new Stack<>();
        while (cnt-- > 0) {
            String[] data = nextStringArr(br, " ");
            switch (data[0]) {
                case "push":
                    stack.add(Integer.parseInt(data[1]));
                    break;
                case "top":
                    if (stack.size() == 0) {
                        pln(-1);
                    } else {
                        pln(stack.lastElement());
                    }
                    break;
                case "size":
                    pln(stack.size());
                    break;
                case "pop":
                    if (stack.size() == 0) {
                        pln(-1);
                    } else {
                        pln(stack.pop());
                    }
                    break;
                case "empty":
                    pln(stack.isEmpty() ? 1 : 0);
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
