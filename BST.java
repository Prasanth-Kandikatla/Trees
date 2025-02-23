class BST {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        Node(int value){
            this.value = value;
            this.height = 0;
        }
        public int getValue(Node node) {
            return node.value;
        }
    }

    // Create root node
    private Node root;

    // Function to check whether the tree is empty or not
    public boolean isEmpty() {
        return root == null;
    }


    //function to return height of a particular node
    public int height (Node node) {

        if (node == null) return -1;
        return node.height;
    }


    // Displaying the tree with details of each node
    public void display() {
        display (root, "root node: ");
    }

    private void display ( Node node, String details) {
        if (node == null) return;

        System.out.println(details + node.value);
        display(node.left, "left child of "+node.value+" is: ");
        display(node.right, "right child of "+node.value+" is: ");
    }

    // Populating elements into the tree by using an automated function
    public void populate(int[] nums){
        for (int i = 0; i<nums.length; i++){
            insert(nums[i]);
        }
    }

    //Inserting elements into BST such that all left side elements are lessthan
    // the parent and right side elements are greater than the parent
    public void insert (int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value){
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (node.value>value) {
            node.left = insert(node.left, value);
        }
        if (node.value<value) {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) +1;
        return node; 
    }

    // BST traversal Pre-order traversal
    public void preOrder() {
        System.out.print("Pre-Order: ");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {

        if (node == null) {
            return;
        }
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }


    // BST traversal In-order traversal
    public void inOrder() {
        System.out.print("In-Order: ");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {

        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    // BST traversal post-order traversal
    public void postOrder() {
        System.out.print("Post-Order: ");
        inOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {

        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }
    //Check tree is balanced or not (a BST is balanced if the height difference 
    // of nodes at same level is lessthan or equal to one then the tree is balanced)

    // Driver method
    public static void main(String[] args) {
        
        BST tree = new BST();
        int[] nums = {8, 2, 3, 0, 4, 5, 1, 6};
        tree.populate(nums);
        tree.display();
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
    }
}
