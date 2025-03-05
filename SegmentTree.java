public class SegmentTree {
    
    class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;
    public SegmentTree(int[] arr) {
        //Construct a tree with the given array
        this.root = constructTree(arr, 0, arr.length-1);
        
    }

    public Node constructTree(int[] arr, int start, int end) {
        //base case
        if(start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        
        Node node = new Node(start, end);
        int mid = (start+end) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    //Display function
    public void display() {
        
    }

    public static void main(String[] args) {
        int[] arr = {3,8,7,6,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
    }
}
