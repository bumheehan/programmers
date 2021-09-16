package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = nextInt(br);
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        boolean chk = true;
        StringBuilder sb = new StringBuilder();
        loop: for (int i = 0; i < cnt; i++) {
            int data = nextInt(br);
            while (stack.size() == 0 || stack.lastElement() < data) {
                if (idx > cnt) {
                    chk = false;
                    break loop;
                }
                stack.add(idx++);
                sb.append("+").append("\n");
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        if (chk) {
            pln(sb.toString().trim());
        } else {
            pln("NO");
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
