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

public class 최소비용_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        //노드 생성
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new Node(i));
        }
        List<Distance> dists = new ArrayList<Distance>();
        for (int i = 0; i < n; i++) {
            dists.add(new Distance(i));
        }
        String[] line = null;
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            graph.get(Integer.parseInt(line[0]) - 1).add(Integer.parseInt(line[1]) - 1,
                    Integer.parseInt(line[2]));
        }
        PriorityQueue<Distance> qu = new PriorityQueue<>();
        line = br.readLine().split(" ");
        int startIdx = Integer.parseInt(line[0]) - 1;
        int destIdx = Integer.parseInt(line[1]) - 1;

        //시작점 설정
        dists.get(startIdx).dist = 0;
        qu.add(dists.get(startIdx));

        while (!qu.isEmpty()) {
            Distance dist = qu.poll();
            if (dist.visited) {
                continue;
            } else {
                dist.visited = true;
            }
            Node node = graph.get(dist.idx);

            for (Entry<Integer, Integer> edge : node.edges.entrySet()) {
                Distance nextDist = dists.get(edge.getKey());
                if (!nextDist.visited) {
                    nextDist.checkDist(dist.dist + edge.getValue());
                    qu.add(nextDist);
                }
            }
        }
        //        for (int i = 0; i < dist.size(); i++) {
        //            System.out.println(dist.get(i).dist);
        //        }
        System.out.println(dists.get(destIdx).dist);

    }

    static class Distance implements Comparable<Distance> {
        public int idx = 0;
        public int dist = Integer.MAX_VALUE;
        public boolean visited;

        public Distance(int idx) {
            this.idx = idx;
        }

        @Override
        public int compareTo(Distance o) {
            int compare = Integer.compare(this.dist, o.dist);
            if (compare == 0) {
                compare = Integer.compare(this.idx, o.idx);
            }
            return compare;
        }

        public void checkDist(int dist) {
            this.dist = Math.min(this.dist, dist);
        }

    }

    static class Node {
        public int idx;
        public Map<Integer, Integer> edges;

        public Node(int idx) {
            this.idx = idx;
            this.edges = new HashMap<>();
        }

        public void add(int idx, int cost) {
            if (edges.containsKey(idx)) {
                edges.put(idx, Math.min(edges.get(idx), cost));
            } else {
                edges.put(idx, cost);
            }
        }

    }
}
