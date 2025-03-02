class AVL {
    
    //Creating a Node class which is represents charactaristics of each node
    class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        Node(int value) {
            this.value = value;
            this.height = 1;
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
        return rotate(node);
    }

    //Rotate function this function checks and 
    //rotates the tree/sub-tree for each non-balancing input
    public Node rotate(Node node) {

        if(height(node.left) - height(node.right) > 1) {
            //Left heavy

            if(height(node.left.left) - height(node.left.right) > 0 ) {
                //Left-Left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0 ) {
                //Left-Right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1) {
            //Right heavy

            if(height(node.right.right) - height(node.right.left) > 0 ) {
                //Right-Right case
                return leftRotate(node);
            }
            if(height(node.right.right) - height(node.right.left) < 0 ) {
                //Right-Left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }


        return node;
    }

    private Node leftRotate(Node node) {
        Node c = node;
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;
        
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        return p;
    }
    private Node rightRotate(Node node) {
        Node p = node;
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;
        
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        return c;
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        System.out.println();
        tree.populate(100);
        System.out.println(tree.height());
    }
}
