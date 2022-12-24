package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class 덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = nextInt(br);
        int[][] arr = new int[count][2];
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = nextIntArr(br, " ");
        }

        for (int i = 0; i < count; i++) {
            int rank = 1;
            int[] me = arr[i];
            for (int j = 0; j < count; j++) {
                if(i==j){
                    continue;
                }
                int[] targetArr = arr[j];
                if(me[0]<targetArr[0] && me[1]<targetArr[1]){
                    rank++;
                }
            }
            result[i]=rank;
        }

        String out = Arrays.stream(result).boxed().map(s -> "" + s).collect(Collectors.joining(" "));
        pln(out);

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
