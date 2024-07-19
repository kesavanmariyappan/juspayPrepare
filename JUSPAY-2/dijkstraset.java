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

public class dijkstraset {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        TreeSet<Pair> pq = new TreeSet<>();
        pq.add(new Pair(0, S));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.pollFirst(); // Retrieve and remove the smallest element

            int currDistance = current.distance;
            int currNode = current.node;

            // Iterate through adjacent nodes
            for (int i = 0; i < adj.get(currNode).size(); i++) {
                int adjNode = adj.get(currNode).get(i).get(0);
                int weight = adj.get(currNode).get(i).get(1);

                // Relaxation step
                if (dist[adjNode] > currDistance + weight) {
                    // Remove old pair from set (if exists)
                    pq.remove(new Pair(dist[adjNode], adjNode));
                    
                    // Update distance
                    dist[adjNode] = currDistance + weight;
                    
                    // Add updated pair to set
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // Example usage
        int V = 5;  // Number of vertices
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example adjacency list
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 5)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 6)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 4)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));

        int[] distances = dijkstra(V, adj, 0);

        // Print distances from source vertex (0 in this case)
        System.out.println("Shortest distances from source vertex:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }
}