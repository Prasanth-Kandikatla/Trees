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
        display(this.root);
    }
    private void display(Node node) {
        String str = "";
        //for printinh left child
        if(node.left != null) {
            str = str + "Interval is ["+ node.left.startInterval + ", "+ node.left.endInterval +"] and data: "+ node.left.data + " => ";
        } else {
            str = str + "no left child, ";
        }
        //for printintg current node
        str = str + "Interval is ["+ node.startInterval + ", "+ node.endInterval +"] and data: "+ node.data + " => ";
        //for printing right child
        if(node.right != null) {
            str = str + "Interval is ["+ node.right.startInterval + ", "+ node.right.endInterval +"] and data: "+ node.right.data;
        } else {
            str = str + "no right child ";
        }
        System.out.println(str);

        if(node.left != null) {
            display(node.left);
        }
        if(node.right != null) {
            display(node.right);
        }
    }

    //Query function which is reason for O(log N) time complixity
    public int query(int qsi, int qei) {
        return this.query(root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        //node intervals lies inside query interval hence consider all the node data
        if(node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            return 0;
        }
        else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    //Update  a value at a particular index
    public void update(int index, int value) {
        this.root.data = update(root, index, value);
    }
    private int update(Node node, int index, int value) {
        if(index > node.startInterval && index < node.endInterval) {
            if(index == node.startInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,7,4};
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.query(1,3));
    }
}
