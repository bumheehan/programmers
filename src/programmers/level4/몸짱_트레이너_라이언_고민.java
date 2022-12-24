package programmers.level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//틀림
public class 몸짱_트레이너_라이언_고민 {
    public int solution(int n, int m, int[][] timetable) {

        int max = 0;
        int idx = 0;
        int[][] newTimeTable = new int[timetable.length * 2][2];
        for (int[] time : timetable) {
            int[] addTime = new int[2];
            addTime[0] = time[0];
            addTime[1] = 1;
            int[] addTime2 = new int[2];
            addTime2[0] = time[1];
            addTime2[1] = -1;
            newTimeTable[idx++] = addTime;
            newTimeTable[idx++] = addTime2;
        }
        Arrays.sort(newTimeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int ret = Integer.compare(o1[0], o2[0]);
                if (ret == 0) {
                    ret = Integer.compare(o2[1], o1[1]);
                }
                return ret;
            }
        });

        int count = 0;
        for (int[] time : newTimeTable) {
            count += time[1];
            if (count > max) {
                max = count;
            }
        }

        if (max == 1) {
            return 0;
        }
        int retVal = 1;
        for (int i = (n - 1) * 2; i > 0; i--) {
            if (maxSize(n, i) >= max) {
                retVal = i;
                break;
            }
        }
        System.out.println(retVal);
        return retVal;
    }

    public int maxSize(int n, int d) {
        int max = 0;
        for (int i = 0; i < d; i++) {
            List<int[]> list = new ArrayList<>();
            list.add(new int[] {0, i});

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == 0 && k <= i) {
                        continue;
                    }

                    boolean chk = true;
                    for (int[] arr : list) {
                        int dist = Math.abs(arr[0] - j) + Math.abs(arr[1] - k);
                        if (dist < d) {
                            chk = false;
                            break;
                        }
                    }
                    if (chk) {
                        list.add(new int[] {j, k});
                    }
                }
            }
            if (max < list.size()) {
                max = list.size();
            }
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        new 몸짱_트레이너_라이언_고민().maxSize(8, 3);
        //        3   2   {{1170,1210}, {1200,1260}}  4
        //        2   1   {{840,900}} 0
        //        2   2   {{600,630},{630,700}}   2
        //        4   5   {{1140,1200},{1150,1200},{1100,1200},{1210,1300},{1220,1280}}   4
        int a = 3;
        int b = 2;
        int[][] c = {{1170, 1210}, {1200, 1260}};
        new 몸짱_트레이너_라이언_고민().solution(a, b, c);
        a = 2;
        b = 1;
        int[][] c2 = {{840, 900}};
        new 몸짱_트레이너_라이언_고민().solution(a, b, c2);
        a = 2;
        b = 2;
        int[][] c3 = {{600, 630}, {630, 700}};
        new 몸짱_트레이너_라이언_고민().solution(a, b, c3);
        a = 4;
        b = 5;
        int[][] c4 = {{1140, 1200}, {1150, 1200}, {1100, 1200}, {1210, 1300}, {1220, 1280}};
        new 몸짱_트레이너_라이언_고민().solution(a, b, c4);

    }
}
