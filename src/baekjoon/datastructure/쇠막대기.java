package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 쇠막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        Stack<Pipe> st = new Stack<>();
        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                if (line.charAt(i + 1) == ')') {
                    i++;
                    sum += st.size();
                } else {
                    st.add(new Pipe());
                }
            } else {
                st.pop();
                sum += 1;
            }
        }
        System.out.println(sum);
    }

    static class Pipe {
        public boolean open;
        public int cnt;
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
