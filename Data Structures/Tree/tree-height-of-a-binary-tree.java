import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int max = 0;
    public static void find(Node n, int d) {
        if(n == null)
        {
            if(d > max+1)
                max = d-1;
            return;
        }
        find(n.left,d+1);
        find(n.right,d+1);
    }
    public static int height(Node n) {
        find(n,0);
        return max;
    }
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}