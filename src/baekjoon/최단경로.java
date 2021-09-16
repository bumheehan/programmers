package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 최단경로 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int r = sc.nextInt();


        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i + 1, new Node(i + 1));
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Node aa = map.get(a);
            Node bb = map.get(b);
            aa.linked.add(new Edge(bb, c));
            //            bb.linked.add(new Edge(aa, c));
        }

        int[] distance = getDistance(n, map.get(r), map);

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public static int[] getDistance(int n, Node root, Map<Integer, Node> map) {
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        //초기화
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //distance 노드 값 넣어주기
        distance[root.idx] = 0;
        for (Edge edge : root.linked) {
            distance[edge.node.idx] = edge.cost;
        }

        visited[root.idx] = true;

        Queue<Edge> qu = new PriorityQueue<Edge>();

        qu.addAll(root.linked);

        while (!qu.isEmpty()) {
            Edge next = qu.poll();
            if (visited[next.node.idx]) {
                continue;
            }
            visited[next.node.idx] = true;

            if (next.cost < distance[next.node.idx]) {
                distance[next.node.idx] = next.cost;
            }

            for (Edge link : next.node.linked) {
                if (!visited[link.node.idx]) {
                    link.cost += next.cost;
                    qu.add(link);
                }
            }
        }
        return distance;

    }

    static class Node {
        int idx;
        List<Edge> linked;

        Node(int idx) {
            this.idx = idx;
            linked = new ArrayList<>();
        }
    }

    static class Edge implements Comparable<Edge> {
        Node node;
        int cost;

        Edge(Node node, int cost) {
            this.cost = cost;
            this.node = node;
        }

        @Override
        public int compareTo(Edge o) {

            return Integer.compare(this.cost, o.cost);
        }
    }

}


