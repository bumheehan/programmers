package programmers.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * tag : 2019 카카오 개발자 겨울 인턴십
 */
public class 크레인_인형뽑기_게임 {

  public int solution(int[][] board, int[] moves) {
    List<Queue<Integer>> trans = new ArrayList<>();
    Stack<Integer> bucket = new Stack<>();

    for (int i = 0; i < board.length; i++) {
      Queue<Integer> col = new LinkedList<>();
      for (int j = 0; j < board.length; j++) {
        int ele = board[j][i];
        if (ele > 0)
          col.add(ele);
      }
      trans.add(col);
    }

    int answer = 0;
    for (int i : moves) {
      Integer top = trans.get(i - 1).poll();
      if (top != null) {
        if (bucket.size() > 0 && bucket.peek() == top) {
          bucket.pop();
          answer += 2;
        } else {
          bucket.add(top);
        }
      }
    }

    return answer;
  }

  // 1등 답
  class Solution {
    public int solution(int[][] board, int[] moves) {
      int answer = 0;
      Stack<Integer> stack = new Stack<>();
      for (int move : moves) {
        for (int j = 0; j < board.length; j++) {
          if (board[j][move - 1] != 0) {
            if (stack.isEmpty()) {
              stack.push(board[j][move - 1]);
              board[j][move - 1] = 0;
              break;
            }
            if (board[j][move - 1] == stack.peek()) {
              stack.pop();
              answer += 2;
            } else
              stack.push(board[j][move - 1]);
            board[j][move - 1] = 0;
            break;
          }
        }
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    int[][] board =
        {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
    int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
    int result = 4;
    System.out.println("정답 : " + result + " 나의 답 : " + new 크레인_인형뽑기_게임().solution(board, moves));

  }
}
