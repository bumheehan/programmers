package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 다리_놓기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        while (cnt-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            BigInteger sum = BigInteger.ONE;
            BigInteger sum2 = BigInteger.ONE;
            for (int i = 0; i < n; i++) {
                sum = sum.multiply(BigInteger.valueOf(m - i));
                sum2 = sum2.multiply(BigInteger.valueOf(i + 1));
            }

            System.out.println(sum.divide(sum2));
        }

    }
}
