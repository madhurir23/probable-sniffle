package GraphTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    void processNode(int node) {
        System.out.print(node + "  ");
    }

    void bfs(int[][] graph) {
        int noOfNodes = graph.length;
        boolean[] visited = new boolean[noOfNodes];

        for (int i = 0; i < noOfNodes; i++) {
            if (!visited[i]) {
                visited[i] = true;
                processNode(i);
                // Visit all neighbors of i
                for (int j = 0; j < noOfNodes; j++) {
                    if (graph[i][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        processNode(j);
                    }
                }
            }
        }
    }

    void bfs(List<List<Integer>> graph) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        if (graph.size() == 0) return;

        for (int i = 0; i < graph.size(); i++) {
            // start at node i
            if (visited.contains(i)) continue;

            queue.add(i);
            while (!queue.isEmpty()) {
                Integer curNode = queue.poll();
                visited.add(curNode);
                processNode(curNode);
                for (int neighbor : graph.get(curNode)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
}
