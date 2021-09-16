package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 후위_표기식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        System.out.println(cal(line));
    }


    public static String cal(String a) {
        if (a.length() == 1) {
            return a;
        }
        Stack<String> stack = new Stack<>();
        String[] split = a.split("");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(")")) {
                String pop = null;
                Deque<String> list = new LinkedList<>();
                while (!(pop = stack.pop()).equals("(")) {
                    if (!pop.equals("(")) {
                        list.addFirst(pop);
                    }
                }
                stack.add(operate(list.iterator()));
            } else {
                stack.add(split[i]);
            }
        }

        return operate(stack.iterator());
    }

    public static String operate(Iterator<String> iterator) {

        String pre = null;
        String post = null;
        String operator = null;
        Deque<String> multi = new LinkedList<>();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("*") || next.equals("/")) {
                multi.addLast(multi.pollLast() + iterator.next() + next);
            } else {
                multi.addLast(next);
            }
        }
        while (multi.size() > 1) {
            pre = multi.pollFirst();
            operator = multi.pollFirst();
            post = multi.pollFirst();
            multi.addFirst(pre + post + operator);
        }
        return multi.getFirst();
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
