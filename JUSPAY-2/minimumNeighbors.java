import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class minimumNeighbors {
    static int min = 0;

    public static void minimumNeighborsBlock(int[] Edges, int n, int src, int des) {
        Queue<Integer> q = new LinkedList<>();      //BFS
        boolean[] visited = new boolean[n + 1];     //To find if visited or not
        q.add(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == des) {      // if equals blocking member plus 1
                min += 1;
            }
            if(Edges[node]!=-1){
                if(!visited[Edges[node]]){
                    visited[Edges[node]] = true;
                    q.add(Edges[node]);     // if not visited recursion
                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Edges[] = new int[n];
        for (int i = 0; i < n; i++)
            Edges[i] = sc.nextInt();

        int src = sc.nextInt();
        int des = sc.nextInt();

        minimumNeighborsBlock(Edges, n, src, des);
        System.out.println("Minimum neighbors block -->" + min);
        sc.close();
    }
}