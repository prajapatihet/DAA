import java.util.*;
public class sss {
    public static void dijkstra(int[][] graph, int start) {
        int numNodes = graph.length;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        for (int i = 0; i < numNodes - 1; i++) {
            int minDistanceNode = findMinDistance(distances, visited);
            visited[minDistanceNode] = true;
            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && graph[minDistanceNode][j] != 0 &&
                        distances[minDistanceNode] != Integer.MAX_VALUE &&
                        distances[minDistanceNode] + graph[minDistanceNode][j] <
                                distances[j]) {
                    distances[j] = distances[minDistanceNode] +
                            graph[minDistanceNode][j];
                }
            }
        }
        printShortestDistances(distances);
    }
    public static int findMinDistance(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceNode = -1;
        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minDistanceNode = i;
            }
        }
        return minDistanceNode;
    }
    public static void printShortestDistances(int[] distances) {
        System.out.println("Vertex\tShortest Distance");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        dijkstra(graph, 0);
    }
}
