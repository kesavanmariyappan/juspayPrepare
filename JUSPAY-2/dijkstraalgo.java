import java.util.*;

class Pair {
    int distance;
    int node;

    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

public class dijkstraalgo {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new Pair(0, S));
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        while (!pq.isEmpty()) {
            int currDistance = pq.peek().distance;
            int currNode = pq.peek().node;
            pq.poll();

            // Iterate through adjacent nodes
            for (int i = 0; i < adj.get(currNode).size(); i++) {
                int adjNode = adj.get(currNode).get(i).get(0);
                int weight = adj.get(currNode).get(i).get(1);

                // Relaxation step
                if (dist[adjNode] > currDistance + weight) {
                    dist[adjNode] = currDistance + weight;
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
