package GraphTraversal;

import java.util.ArrayList;
import java.util.List;

public class Sniffer {
    public static void main(String[] args) {
        //    (1) <--------- (0)            (4)  -----------> (6)
        //     |              |          ^    ^              |
        //     |              |      /       |              |
        //     |              v  /          |               v
        //    (2)            (3) -------> (5) -----------> (7)       (8) ------------ (9)
        int[][] graph = {
                {0,1,0,1,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1},
        };
        Sniffer obj = new Sniffer();
        List<List<Integer>> graphAdjList = obj.convertAdjMatrixToAdjList(graph);

        System.out.println("BFS");
        BFS bfs = new BFS();
        bfs.bfs(graphAdjList);
        System.out.println();
        System.out.println("DFS");
        DFS dfs = new DFS();
        dfs.dfs_iterative(graphAdjList);
        System.out.println();
        dfs.dfs_recursive(graphAdjList);
    }

    List<List<Integer>> convertAdjMatrixToAdjList(int[][] graph) {
        int noOfNodes = graph.length;
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int[] ints : graph) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < noOfNodes; j++) {
                if (ints[j] == 1)
                    list.add(j);
            }
            neighbors.add(list);
        }
        return neighbors;
    }
}
