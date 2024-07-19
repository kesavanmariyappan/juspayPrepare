public class Reachability {
    public static  boolean reachable(int []edges,boolean []visited,int src,int dest)
    {
        visited[src]=true;          //to set the node to visited
        if(edges[src]==dest)        //Condition to check whether reachable
            return true;
        if(edges[src]!=-1 && !visited[edges[src]])
        {
            reachable(edges,visited,edges[src],dest);       //Recursion
        }
        return false;
    }
    public static void main(String[] args) {
        int []edges={4,4,1,4,13,8,8,8,0,8,14,9,15,11,-1,10,15,22,22,22,22,22,21};
        int src=4;
        int dest=13;
        boolean[] visited=new boolean[edges.length];
        if(reachable(edges,visited,src,dest))
        {
            System.out.println("1");
        }
        else
        {
            System.out.println("0");
        }
    }
}
