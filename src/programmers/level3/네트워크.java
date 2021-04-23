package programmers.level3;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 네트워크 {
  public int solution(int n, int[][] computers) {

    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++)
      nodes[i] = new Node(i);

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (computers[i][j] == 1)
          addAdjacent(nodes, i, j);

    int countNetwork = 0;

    for (Node node : nodes) {
      if (!node.visited) {
        countNetwork++;
        dfs(node);
      } else {
        continue;
      }
    }
    System.out.println(countNetwork);
    return countNetwork;
  }

  public void addAdjacent(Node[] nodes, int i, int j) {
    if (i == j)
      return;
    if (!nodes[i].adjacent.contains(nodes[j])) {
      nodes[i].adjacent.add(nodes[j]);
    }
    if (!nodes[j].adjacent.contains(nodes[i])) {
      nodes[j].adjacent.add(nodes[i]);
    }

  }

  public void dfs(Node root) {
    Stack<Node> stack = new Stack<>();

    root.visited = true;
    stack.push(root);

    while (!stack.empty()) {
      Node popNode = stack.pop();
      for (Node child : popNode.adjacent) {
        if (!child.visited) {
          child.visited = true;
          stack.push(child);
        }
      }
      System.out.print(popNode.node);
    }
  }

  public class Node {
    int node;
    List<Node> adjacent;
    boolean visited;

    Node(int node) {
      this.node = node;
      this.adjacent = new LinkedList<>();
      this.visited = false;
    }
  }
}
