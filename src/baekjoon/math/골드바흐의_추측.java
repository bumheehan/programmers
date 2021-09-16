package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 골드바흐의_추측 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> test = new ArrayList<>();

        int nextInt = 0;
        int max = 0;
        while ((nextInt = nextInt(br)) != 0) {
            test.add(nextInt);
            if (nextInt > max) {
                max = nextInt;
            }
        }
        //        boolean[] primeList = prime(max);
        StringBuilder sb = new StringBuilder();
        for (int i : test) {
            if (sb.length() > 0) {
                sb.append("\n");
            }

            boolean chk = false;
            for (int j = i - 1; j >= 2; j--) {
                if (isPrime(j) && isPrime(i - j)) {
                    if ((i - j) % 2 == 1) {
                        sb.append(i).append(" = ").append((i - j)).append(" + ").append(j);
                        chk = true;
                        break;
                    }
                }
            }

            if (!chk) {
                sb.append("Goldbach's conjecture is wrong.");
            }
        }
        pln(sb.toString());
        //        1000000

    }

    public static boolean[] prime(int max) {
        boolean[] primeList = new boolean[max + 1];
        primeList[2] = true;
        for (int i = 3; i <= max; i++) {
            boolean chk = false;
            int sqrt = (int) Math.sqrt(i);
            for (int j = 0; j <= sqrt; j++) {
                if (primeList[j]) {
                    if (i % j == 0) {
                        chk = true;
                    }
                }

            }
            if (!chk) {
                primeList[i] = true;
            }

        }
        return primeList;

    }

    public static boolean isPrime(int data) {
        if (data == 0) {
            return false;
        } else if (data == 1) {
            return false;
        } else if (data == 2) {
            return true;
        }
        int sqrt = (int) Math.sqrt(data);
        for (int i = 2; i <= sqrt; i++) {
            if (data % i == 0) {
                return false;
            }
        }
        return true;
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
