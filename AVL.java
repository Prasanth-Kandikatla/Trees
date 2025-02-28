class AVL {
    
    //Creating a Node class which is represents charactaristics of each node
    class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        Node(int value) {
            this.value = value;
            this.height = 0;
        }
    }

    //Function for height of a particular node
    public int height(Node node) {
        if(node == null) return 0;
        return node.height;
    }

    public int height() {
        return height(root);
    }
    //Populate values

    public void populate(int n) {
        for (int i = 0; i<n; i++) {
            insert(i);
        }
    }
    //Create a root node
    private Node root;
    public void insert(int value) {
        
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if(node == null) {
            node = new Node(value);
            return node;
        }

        if(node.value > value) {
            node.left = insert(node.left, value);
        }
        if(node.value < value) {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(1);
        System.out.println(tree.height());
    }
}
