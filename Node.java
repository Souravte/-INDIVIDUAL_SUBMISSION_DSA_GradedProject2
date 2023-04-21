class Node {
    int data;
    Node left, right;
    
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Main {
    Node node;
    
    // Function to convert BST to skewed tree
    public void convertToSkewed() {
        node = convertToSkewed(node, null);
    }
    
    // Helper function to convert BST to skewed tree
    private Node convertToSkewed(Node root, Node prev) {
        if (root == null) {
            return prev;
        }
        
        // Recursively convert left subtree
        Node left = convertToSkewed(root.left, root);
        
        // Set the right pointer of the previous node
        root.left = null;
        root.right = prev;
        prev = root;
        
        // Recursively convert right subtree
        return convertToSkewed(root.right, prev);
    }
    
    // Function to print node values in ascending order
    public void printInOrder() {
        printInOrder(node);
    }
    
    // Helper function to print node values in ascending order
    private void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
    
    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);
        
        tree.convertToSkewed();
        tree.printInOrder();
    }
}
