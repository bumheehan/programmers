package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어_뒤집기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        String readLine = br.readLine();
        char[] charArray = readLine.toCharArray();
        boolean chk = false;
        StringBuilder sbb = new StringBuilder();
        StringBuilder tag = new StringBuilder();
        StringBuilder body = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            if (ch == '<') {
                sbb.append(body.reverse());
                body = new StringBuilder();
                tag = new StringBuilder();
                tag.append('<');
                chk = true;
            } else if (ch == '>') {
                tag.append('>');
                sbb.append(tag);
                chk = false;
            } else {
                if (chk) {
                    tag.append(ch);
                } else {
                    if (ch == ' ') {
                        sbb.append(body.reverse()).append(' ');
                        body = new StringBuilder();
                    } else {
                        body.append(ch);
                    }

                }
            }



        }
        if (body.length() > 0) {
            sbb.append(body.reverse());
        }

        System.out.println(sbb.toString());


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
