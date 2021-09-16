package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int nextInt = nextInt(br);
        int[] test = nextIntArr(br, " ");
        int[] retVal = new int[test.length];
        Arrays.fill(retVal, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < test.length; i++) {

            int data = test[i];
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && test[stack.peek()] < data) {
                    retVal[stack.pop()] = data;
                }
                stack.push(i);

            }

        }
        for (int i = 0; i < retVal.length; i++) {
            sb.append(retVal[i]).append(" ");
        }
        pln(sb.toString().trim());

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
