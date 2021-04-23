package programmers.level3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 아직 BFS ,DFS 미숙
public class 단어_변환 {
  public int solution(String begin, String target, String[] words) {
    boolean include = false;
    Node[] nodes = new Node[words.length + 1];
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(target)) {
        include = true;
      }
      nodes[i] = new Node(words[i]);
    }
    nodes[nodes.length - 1] = new Node(begin);
    if (!include) {
      return 0;
    }
    relate(nodes);

    int answer = bfs(nodes[nodes.length - 1], target);
    return answer;
  }

  public int bfs(Node root, String target) {

    Queue<Node> qu = new LinkedList<>();
    qu.add(root);
    root.depth = 0;
    int answer = 0;
    while (!qu.isEmpty()) {
      Node node = qu.poll();
      if (node.node.equals(target)) {
        answer = node.depth;
        break;
      }
      System.out.println("방문" + node.node + "depth : " + node.depth);
      for (Node child : node.children) {
        if (child.depth != null) {
          continue;
        }
        child.depth = node.depth + 1;
        qu.add(child);
      }
    }
    return answer;
  }

  public void relate(Node[] nodes) {
    for (int k = 0; k < nodes.length; k++) {
      Node node = nodes[k];
      int length = node.node.length();
      for (int i = 0; i < length; i++) {
        String prefix = node.node.substring(0, i);
        String suffix = node.node.substring(i + 1);
        for (int j = 0; j < nodes.length; j++) {
          if (k == j) {
            continue;
          }
          Node ele = nodes[j];
          if (ele.node.startsWith(prefix) && ele.node.endsWith(suffix)) {
            addAdjacent(ele, node);
          }
        }
      }
    }
  }

  public void addAdjacent(Node a, Node b) {
    if (a == b) {
      return;
    }
    a.children.add(b);
    b.children.add(a);
  }

}


class Node {
  String node;
  Set<Node> children;
  Integer depth;

  public Node(String node) {
    this.node = node;
    this.children = new HashSet<Node>();
  }

}
