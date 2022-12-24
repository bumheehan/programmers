package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다. -> 소인수분해 할려면 소수 필요 
// 에러스토테네스 -> nloglogn -> 1억안됨 가능
public class 소인수분해 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = nextInt(br); // 21억 미만

        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        for (int i = 3; i <= input; i += 2) {
            boolean chk = true;
            for (int prime : primes) {

                if (prime * prime > i) {
                    break;
                }
                if (i % prime == 0) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                primes.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (input != 1) {
            for (; i < primes.size(); i++) {
                int prime = primes.get(i);
                if (input % prime == 0) {
                    sb.append(prime).append("\n");
                    input /= prime;
                    break;
                }
            }
        }

        System.out.println(sb.toString());


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
