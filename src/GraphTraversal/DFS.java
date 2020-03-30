package GraphTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    void processNode(int node) {
        System.out.print(node + "  ");
    }

    void dfs_recursive(List<List<Integer>> graph) {
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited.contains(i))
                dfs_helper(graph, i, visited);
        }

    }

    private void dfs_helper(List<List<Integer>> graph, int node, List<Integer> visited) {
        visited.add(node);
        processNode(node);
        for (int neighbor:graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs_helper(graph, neighbor, visited);
            }
        }
    }

    void dfs_iterative(List<List<Integer>> graph) {
        List<Integer> visited = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            if (visited.contains(i)) continue;
            Stack<Integer> stack = new Stack<>();
            stack.push(i);

            while (!stack.isEmpty()) {
                int curNode = stack.pop();
                if (!visited.contains(curNode)) {
                    processNode(curNode);
                    visited.add(curNode);
                }
                for (int neighbor : graph.get(curNode)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
