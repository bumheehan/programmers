package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 골드바흐_파티션 {
    public static void main2(String[] args) throws IOException {
        //데이터 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = nextInt(br);
        int max = 0;
        List<Integer> dataSet = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int next = nextInt(br);
            if(max<next){
                max= next;
            }
            dataSet.add(next);
        }

        // 최대값에 대한 소수 계산
        Set<Integer> primeSet = new HashSet<>();

        //계산
        StringBuilder sb = new StringBuilder();
        for (int data : dataSet){
            int gold = 0;
            if(data ==2 ){
                if(sb.length()!=0){
                    sb.append("\n").append(gold);
                }else{
                    sb.append(gold);
                }
                continue;
            }
            int limit = data/2;
            for(int i = 2;i<=limit ; i++ ){
                if(isPrime(i,primeSet)){
                    int secondPrimeNumber = data-i;
                    if(isPrime(secondPrimeNumber,primeSet)){
                        gold++;
                    }
                }
            }
            if(sb.length()!=0){
                sb.append("\n").append(gold);
            }else{
                sb.append(gold);
            }
        }
        System.out.println(sb);


    }
    public static boolean isPrime(int primeCheckNumber,Set<Integer> dataSet) {
        if(dataSet.contains(primeCheckNumber)){
            return true;
        }
        if(primeCheckNumber == 2){
            return true;
        }

        if (primeCheckNumber % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(primeCheckNumber); i += 2) {
            if (primeCheckNumber % i == 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        //데이터 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = nextInt(br);
        int max = 0;
        List<Integer> dataSet = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int next = nextInt(br);
            if(max<next){
                max= next;
            }
            dataSet.add(next);
        }

        // 아리스토테네스 체
        int limit = max;
        boolean[] primeArr = new boolean[limit+1]; // true가 nonPrime, false가 prime
        primeArr[0] = primeArr[1] = true;
        for(int i = 2 ; i * i <=limit ;i++){
            if(!primeArr[i]){
                for(int j=2; j*i<=limit; j++) {
                    primeArr[j*i]=true;
                }
            }
        }


        //계산
        StringBuilder sb = new StringBuilder();
        for (int data : dataSet){
            if(sb.length()>0){
                sb.append("\n");
            }
            int gold = 0;
            for(int i = 2; i+i<=data;i++){
                if(!primeArr[i] && !primeArr[data-i]){
                    gold++;
                }
            }

            sb.append(gold);
        }
        System.out.println(sb);


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


