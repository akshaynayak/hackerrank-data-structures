import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Node{
        public int data;
        public ArrayList<Node> children;
        public int cost;
    }
    public static class graph{
        public Node nodes[];
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int testcases=sc.nextInt();
       
    for(int z=1;z<=testcases;z++){    
        int n=sc.nextInt();
        int edges=sc.nextInt();
        graph g=new graph();
        g.nodes=new Node[n+1];
        for(int i=1;i<=n;i++){
            g.nodes[i]=new Node();
            g.nodes[i].data=i;
            g.nodes[i].cost=-1;
            g.nodes[i].children=new ArrayList<Node>();
        }
        for(int i=1;i<=edges;i++){
            int s=sc.nextInt();
            int e=sc.nextInt();
            g.nodes[s].children.add(g.nodes[e]);
            g.nodes[e].children.add(g.nodes[s]);
            
        }
        int source=sc.nextInt();
        int cost[]=new int[n+1];
        int visited[]=new int[n+1];
        LinkedList<Node> q=new LinkedList<Node>();
        g.nodes[source].cost=0;
        q.add(g.nodes[source]);
        visited[source]=1;
       
        while(!q.isEmpty()){
            Node t=q.removeFirst();
            ///if(visited[t.data]==0){
               // visited[t.data]=1;
                for(Node x:t.children){
                    if(visited[x.data]==0){
                        q.add(g.nodes[x.data]);
                        visited[x.data]=1;
                        x.cost=t.cost+6;
                    }
                }
            //}
        }
        for(int l=1;l<=n;l++){
            if(l!=source){
            System.out.print(g.nodes[l].cost+" ");
            }
        }System.out.println();
    }
        
    }
}