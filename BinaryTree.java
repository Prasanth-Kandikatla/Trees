import java.util.Scanner;

class BinaryTree{

    //Creating a Node class with 3 binary tree charactaristics (value of that node, left pointer, right pointer)
    class Node {
        int value;
        Node left;
        Node right;

        //Defining constructor
        public Node(int value){
            this.value = value;
        }
    }

    //Declaring rood node variable
    private Node root;

    //Set root node and call function recursively to build the binary tree
    private void populate(Scanner scanner){
        System.out.println("Enter root node: ");
        int value = scanner.nextInt();
        root = new Node(value);

        populate(scanner, root);
    }

    //Method declaration to build left and right branches to the nodes recursively
    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter left node to "+node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the left value to "+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right node to "+node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the right value to "+node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    //Method to displaying Binary Tree
    // public void display(){
        
    //     display(root, "");
    // }

    
    // private void display(Node node, String indent){
    //     if (node == null){
    //         return;
    //     }
    //     System.out.println(indent+ node.value);
    //     display(node.left, indent + "      ");
    //     display(node.right, indent + "      ");
    // }
    
    //Method to prettyDisplay
    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }
           prettyDisplay(node.right, level+1);

           if(level != 0){
            for (int i = 0; i< level - 1; i++){
                System.out.print("|\t");
            }
            System.out.println("|------>"+ node.value);
           } else {
                System.out.println(node.value);
           }

           prettyDisplay(node.left, level+1);
    }


    //Main method
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        
        tree.populate(scanner);
        tree.prettyDisplay();
    }
}
