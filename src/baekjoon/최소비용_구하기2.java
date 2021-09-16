package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class 최소비용_구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new Node(i));
        }

        for (int i = 0; i < m; i++) {
            String[] readListSp = br.readLine().split(" ");
            graph.get(Integer.parseInt(readListSp[0]) - 1).add(Integer.parseInt(readListSp[1]) - 1,
                    Integer.parseInt(readListSp[2]));
        }
        String[] readListSp = br.readLine().split(" ");
        int startIdx = Integer.parseInt(readListSp[0]) - 1;
        int endIdx = Integer.parseInt(readListSp[1]) - 1;

        PriorityQueue<Node> qu = new PriorityQueue<>();

        qu.add(graph.get(startIdx));
        graph.get(startIdx).dist = 0;
        while (!qu.isEmpty()) {
            Node node = qu.poll();

            if (node.visited) {
                continue;
            } else {
                node.visited = true;
            }

            for (Entry<Integer, Integer> entry : node.edges.entrySet()) {
                Node enter = graph.get(entry.getKey());
                if (!enter.visited) {
                    enter.minCheck(node, node.dist + entry.getValue());
                    qu.add(enter);
                }
            }
        }
        Node endNode = graph.get(endIdx);
        System.out.println(endNode.dist);
        System.out.println(endNode.cnt + 1);
        System.out.println(endNode.preNode + " " + (endIdx + 1));


    }



    static class Node implements Comparable<Node> {
        public int idx;
        public Map<Integer, Integer> edges;
        public int dist;
        public boolean visited;
        public String preNode;
        public int cnt;

        public Node(int idx) {
            this.idx = idx;
            this.dist = Integer.MAX_VALUE;
            this.preNode = "";
            this.edges = new HashMap<>();
        }

        public void add(int idx, int cost) {
            if (edges.containsKey(idx)) {
                int preCost = edges.get(idx);
                if (preCost > cost) {
                    edges.put(idx, cost);
                }
            } else {
                edges.put(idx, cost);
            }
        }

        public void minCheck(Node preNode, int dist) {
            if (this.dist > dist) {
                this.dist = dist;
                this.preNode = preNode.preNode + " " + (preNode.idx + 1);
                this.cnt = preNode.cnt + 1;
            } else if (this.dist == dist) {
                String rePreNode = preNode.preNode + " " + (preNode.idx + 1);
                if (rePreNode.compareTo(this.preNode) == -1) {
                    this.preNode = rePreNode;
                }
            }

        }

        @Override
        public int compareTo(Node o) {
            int compare = Integer.compare(this.dist, o.dist);
            if (compare == 0) {
                compare = Integer.compare(this.idx, o.idx);
            }
            return compare;
        }

    }
}
