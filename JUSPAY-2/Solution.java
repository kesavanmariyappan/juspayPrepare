import java.util.*;

class Pair implements Comparable<Pair> {
    int distance;
    int node;

    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }

    @Override
    public int compareTo(Pair other) {
        // Compare by distance
        return Integer.compare(this.distance, other.distance);
    }
}

public class Solution {
    static int[] dijkstra(int V, int[][] edges, int S) {
        TreeSet<Pair> pq = new TreeSet<>();
        pq.add(new Pair(0, S));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.pollFirst(); // Retrieve and remove the smallest element

            int currDistance = current.distance;
            int currNode = current.node;

            // Iterate through adjacent nodes (for unweighted graph, consider all outgoing edges)
            for (int[] edge : edges) {
                if (edge[0] == currNode) {
                    int adjNode = edge[1];

                    // Relaxation step (for unweighted graph, weight is 1)
                    if (dist[adjNode] > currDistance + 1) {
                        // Remove old pair from set (if exists)
                        pq.remove(new Pair(dist[adjNode], adjNode));

                        // Update distance
                        dist[adjNode] = currDistance + 1;

                        // Add updated pair to set
                        pq.add(new Pair(dist[adjNode], adjNode));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // Example usage
        int V = 5;  // Number of vertices
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {1, 2},
            {2, 4},
            {3, 4}
        };

        int[] distances = dijkstra(V, edges, 0);

        // Print distances from source vertex (0 in this case)
        System.out.println("Shortest distances from source vertex:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }
}
