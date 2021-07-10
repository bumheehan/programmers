package programmers.level1;

import java.util.Collections;
import java.util.LinkedList;

public class 실패율 {
  public int[] solution(int N, int[] stages) {

    LinkedList<Stage> stagesList = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      stagesList.add(new Stage(i + 1));
    }
    int sum = 0;
    for (int a : stages) {
      if (a == N + 1) {
        sum++;
        continue;
      }
      Stage stage = stagesList.get(a - 1);
      stage.failCnt++;
    }

    for (int i = N - 1; i >= 0; i--) {
      Stage stage = stagesList.get(i);
      sum += stage.failCnt;

      if (sum == 0) {
        stage.failRate = 0;
      } else {
        stage.failRate = (double) stage.failCnt / sum;
      }
    }

    Collections.sort(stagesList);

    return stagesList.stream().mapToInt(sa -> sa.idx).toArray();
  }

  public class Stage implements Comparable<Stage> {
    public int failCnt = 0;
    public int idx = 0;
    public double failRate = 0;

    Stage(int idx) {
      this.idx = idx;
    }

    @Override
    public int compareTo(Stage o) {
      int compare = Double.compare(o.failRate, this.failRate);
      if (compare == 0) {
        return Integer.compare(this.idx, o.idx);
      }
      return compare;
    }
  }

  public static void main(String[] args) {
    int N = 1;
    int[] stages = {2, 1, 2};
    new 실패율().solution(N, stages);
  }
}
