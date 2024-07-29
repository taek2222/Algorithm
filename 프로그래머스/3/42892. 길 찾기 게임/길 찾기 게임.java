import java.util.*;
class Solution {
    public class Node{
        public int num; public int y; public int x;
        public Node left; public Node right;
        public Node(int num, int y, int x){
            this.y=y; this.x=x; this.num=num;
            this.left = null; this.right = null;
        }
    }
    public class Tree{
        public Node head;
        public Tree(Node node){
            this.head = node;
        }
        public void add(Node node){
            Node parent = head;
            Node child = parent;
            
            while(parent != null){
                if(node.x < parent.x){
                    if(parent.left == null){
                        parent.left = node; break;
                    }
                    else parent = parent.left;
                } 
                else{
                    if(parent.right == null){
                        parent.right = node; break;
                    }
                    else parent = parent.right;
                } 
            }
        }
    }
    public void preorder(Node node, ArrayList<Integer> list){
        if(node == null) return;
        list.add(node.num);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    public void postorder(Node node, ArrayList<Integer> list){
        if(node == null) return;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.num);
    }
    public int[] listToArray(ArrayList<Integer> list){
        int[] arr = new int[list.size()];
        int index = 0;
        for(int num : list) arr[index++] = num;
        return arr;
    }
    public int[][] solution(int[][] nodeinfo) {

        Node[] nodelist = new Node[nodeinfo.length];
        int index = 0;
        for(int[] node : nodeinfo)
            nodelist[index] = new Node(++index, node[1], node[0]);
        Arrays.sort(nodelist, (node1, node2) -> {
            if(node1.y == node2.y) return node1.x - node2.x;
            return node2.y - node1.y;
        });
        
        Tree tree = new Tree(nodelist[0]);
        for(index = 1; index < nodelist.length; index++){
            tree.add(nodelist[index]);
        }
        
        ArrayList<Integer> pre = new ArrayList<>();
        preorder(tree.head, pre);
        
        ArrayList<Integer> post = new ArrayList<>();
        postorder(tree.head, post);
        
        int[][] answer = {listToArray(pre), listToArray(post)};
        
        return answer;
    }
}