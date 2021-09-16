package baekjoon;

import java.util.Scanner;

public class _1로_만들기 {
    //X가 3으로 나누어 떨어지면, 3으로 나눈다.
    //X가 2로 나누어 떨어지면, 2로 나눈다.
    //1을 뺀다.

    //public static Map<Integer,Integer> cache = new HashMap<>();

    public static Integer[] cache = null;

    public static void main(String[] args) {
        //cache.put(1,0);
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        cache = new Integer[a + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = 0;
        }
        System.out.println(dfs(a));
    }

    public static int dfs(int x) {
        if (x == 1) {
            return 0;
        }
        if (cache[x] != 0) {
            return cache[x];
        }
        //if(cache.containsKey(x)){
        //   return cache.get(x); 
        //}


        int child1 = Integer.MAX_VALUE;
        int child2 = Integer.MAX_VALUE;
        int child3 = Integer.MAX_VALUE;
        if (x % 3 == 0) {
            child1 = dfs(x / 3);
        }
        if (x % 2 == 0) {
            child2 = dfs(x / 2);
        }

        child3 = dfs(x - 1);

        int child = Math.min(Math.min(child1, child2), child3);

        //cache.put(x,child+1);
        cache[x] = child + 1;

        return child + 1;
    }
}
