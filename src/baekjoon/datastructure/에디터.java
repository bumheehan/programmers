package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> left = new LinkedList<>();
        Deque<Character> right = new LinkedList<>();
        br.readLine().chars().forEach(s -> left.add((char) s));

        int cnt = nextInt(br);
        while (cnt-- > 0) {
            String line = br.readLine();
            switch (line.charAt(0)) {
                case 'L':
                    if (left.size() > 0) {
                        right.addFirst(left.pollLast());
                    }
                    break;
                case 'D':
                    if (right.size() > 0) {
                        left.addLast(right.pollFirst());
                    }
                    break;
                case 'B':
                    if (left.size() > 0) {
                        left.pollLast();
                    }
                    break;
                case 'P':
                    left.addLast(line.charAt(2));
                    break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        left.forEach(s -> {
            try {
                bw.append(s);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        right.forEach(s -> {
            try {
                bw.append(s);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        bw.flush();
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
