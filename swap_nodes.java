import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution{

    public static class Node{
        public int data;
        public Node left;
        public Node right;
        public Node parent;
    }
    
    public static void Inorder(Node root){
        if(root==null)
            return;
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
        
    }
    public static Node swapnodes(Node root,int depth,HashMap hm){
           
        if(root==null)
            return null;
        root.left=swapnodes(root.left,depth+1,hm);
        root.right=swapnodes(root.right,depth+1,hm);
            
        if(hm.containsKey(depth)){
               Node temp=root.left;
               root.left=root.right;
               root.right=temp;
    
        }
        return root;
               
    }
    public static int height(Node root){
        if(root==null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node nodes[]=new Node[n+1];
        for(int i=1;i<=n;i++)
            nodes[i]=new Node();
        for(int i=1;i<=n;i++){
            nodes[i].data=i;
            int left=sc.nextInt();
            int right=sc.nextInt();
            if(left!=-1){
                nodes[i].left=nodes[left];
                nodes[i].left.parent=nodes[i];
            }
            if(right!=-1){
                nodes[i].right=nodes[right];
                nodes[i].right.parent=nodes[i];
            }
        }
        Node root=nodes[1];
        for(int i=1;i<=n;i++){
            if(nodes[i].parent==null){
                root=nodes[i];
                break;
            }
        }
        int t=sc.nextInt();
        int h=height(root);
        
        for(int i=1;i<=t;i++){
            int k=sc.nextInt();
            int j=1;
            HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
            while(k*j<=h){
                hm.put(k*j,1);
                j++;
            }
            root=swapnodes(root,1,hm);
            Inorder(root);
            System.out.println();
        }
            
    
    
    }
    
}