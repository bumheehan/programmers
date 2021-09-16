package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class 후위_표기식2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = nextInt(br);
        String eq = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        char a = 'A';
        while (count-- > 0) {
            map.put(a++, nextInt(br));
        }
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < eq.length(); i++) {
            char ch = eq.charAt(i);
            switch (ch) {
                case '+':
                    double aa = stack.pop();
                    double bb = stack.pop();
                    stack.push(aa + bb);
                    break;
                case '-':
                    double aaa = stack.pop();
                    double bbb = stack.pop();
                    stack.push(bbb - aaa);
                    break;
                case '*':
                    double aaaa = stack.pop();
                    double bbbb = stack.pop();
                    stack.push(bbbb * aaaa);
                    break;
                case '/':
                    double aaaaa = stack.pop();
                    double bbbbb = stack.pop();
                    stack.push(bbbbb / aaaaa);
                    break;
                default:
                    stack.push((double) map.get(ch));
            }
        }


        System.out.println(String.format("%.2f", stack.pop()));
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
