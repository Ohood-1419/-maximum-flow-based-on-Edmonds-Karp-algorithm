/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms2_phase3pt1;

/**
 *
 * @author luluahmaldakhil
 */
import java.lang.*;
import java.util.LinkedList;
 
class MaxFlow {
    static final int V = 6; // Number of vertices in graph
 
    
    public boolean bfs(int rGraph[][], int s, int t, int parent[])
    {
        // creating a visited array and mark all vertices as
        // not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i)
            visited[i] = false;
 
       
        LinkedList<Integer> queue
            = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;
 
        // Standard BFS Loop
        while (queue.size() != 0) {
            int u = queue.poll();
 
            for (int v = 0; v < V; v++) {
                if (visited[v] == false
                    && rGraph[u][v] > 0) {
                    // If we find a connection to the sink
                    // node, then there is no point in BFS
                    // anymore We just have to set its parent
                    // and can return true
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
 
        //if sink not reached return false
        return false;
    }
 
   //Maxflow algorithm from s to t where s is source
    public int fordFulkerson(int graph[][], int s, int t)
    {
        int u, v;
 
 
        //if there is an edge. If rGraph[i][j] is 0, then there is
        // not)
        int rGraph[][] = new int[V][V];
 
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];
 
        // This array is filled by BFS and to store path
        int parent[] = new int[V];
 
        int max_flow = 0; // There is no flow in the beginning
 
        
        while (bfs(rGraph, s, t, parent)) {
            // Find minimum residual capacity of the edhes
            // along the path filled by BFS.
            //finding path flow for each aug. path
            int i =0;
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow
                    = Math.min(path_flow, rGraph[u][v]);
                i++;
            }
            
            // update edges
            // reverse edges along the path
            // then storing augumented paths in a seperate array 
             int [] augpath = new int[i];
            System.out.println("Augemented Path ");
            System.out.print(s+1+" -->");
            int j = 0;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
                
               augpath[j] = v+1;
               j++;
            }
            //printing augumented path in a reverse order so it can be started with source
            for (int k = augpath.length-1; k >= 0; k--) {
                if(k!=0){
                 System.out.print(" "+augpath[k]+" --> ");}
                else
                 System.out.println(augpath[k]);
            }
             
           
            System.out.println("Path Flow: "+path_flow);
            max_flow += path_flow;
            System.out.println("Updated Flow (for maximum): "+ max_flow);
            System.out.println("-------------------------");
        }
 
        // Return the overall maximum flow
        return max_flow;
    }
}
 