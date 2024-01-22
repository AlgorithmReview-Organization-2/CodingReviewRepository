import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Node{
    char data;
    Node left,right;

    public Node(char data){
        this.data = data;
        left = right = null;
    }
}
public class BinaryTree {
    Node root;
    HashMap<Character,Node> nodes = new HashMap<>();

    public void addNode(char data, char leftData, char rightData){
        Node node = nodes.getOrDefault(data,new Node(data));
        nodes.put(data,node);

        if(leftData != '.'){
            node.left = nodes.getOrDefault(leftData,new Node(leftData));
            nodes.put(leftData, node.left);
        }
        if(rightData != '.'){
            node.right =nodes.getOrDefault(rightData,new Node(rightData));
            nodes.put(rightData,node.right);
        }

        if(root == null){
            root =node;
        }
    }
    private static void preorder(Node node){
        if(node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    private static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        BinaryTree tree = new BinaryTree();

        for(int i =0; i<n ; i++){
            String[] input = bf.readLine().split(" ");
            for(int j =0;j<3;j++){
                tree.addNode(input[0].charAt(0),input[1].charAt(0),input[2].charAt(0));
            }
        }
        preorder(tree.root);
        System.out.println();
        inorder(tree.root);
        System.out.println();
        postorder(tree.root);
    }
}
