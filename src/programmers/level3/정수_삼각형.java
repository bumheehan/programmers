package programmers.level3;

public class 정수_삼각형 {
    public int solution(int[][] triangle) {
        int[][] max = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            max[i] = new int[triangle[i].length];
        }
        int answer = 0;

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                bfs(max, triangle, i, j);
                if (i == triangle.length - 1) {
                    if (answer < max[i][j]) {
                        answer = max[i][j];
                    }
                }

            }
        }
        return answer;
    }

    public void bfs(int[][] max, int[][] tri, int depth, int idx) {
        //현재 위치 넣기
        if (depth == 0) {
            max[0][0] = tri[0][0];
        } else {
            //leftMax
            int leftMax = 0;
            if (idx != 0) {
                leftMax = max[depth - 1][idx - 1];
            }
            //rightMax
            int rightMax = 0;
            if (idx < tri[depth - 1].length) {
                rightMax = max[depth - 1][idx];
            }
            max[depth][idx] = Math.max(leftMax, rightMax) + tri[depth][idx];
        }

    }

    public static void main(String[] args) {
        int[][] data = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int ret = new 정수_삼각형().solution(data);
        System.out.println(ret);
    }
}
