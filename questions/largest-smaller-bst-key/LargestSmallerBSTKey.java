public class LargestSmallerBSTKey {

    static Node root;

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int key) {
            this.val = key;
            left = null;
            right = null;
        }
    }

    //  inserts a new node with the given number in the
    //  correct place in the tree
    void insert(int key) {
        // 1) If the tree is empty, create the root
        if(this.root == null) {
            this.root = new Node(key);
            return;
        }

        // 2) Otherwise, create a node with the key
        //    and traverse down the tree to find where to
        //    to insert the new node
        Node currentNode = this.root;
        Node newNode = new Node(key);

        while(currentNode != null) {
            if(key < currentNode.val) {
                if(currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if(currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    // finds the largest key in the tree that is smaller than num.
    static int findLargestSmallerKey(int num) {
        Node curr = root;
        int result = -1;

        while(curr != null) {
            if (curr.val < num) { // curr node's val is smaller than num, maybe the result
                result = curr.val;
                curr = curr.right; // find larger value
            } else {
                curr = curr.left;  // not satisfied, need to find smaller
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Create a Binary Search Tree
        LargestSmallerBSTKey bst = new LargestSmallerBSTKey();
        bst.insert(20);
        bst.insert(9);
        bst.insert(25);
        bst.insert(5);
        bst.insert(12);
        bst.insert(11);
        bst.insert(14);

        int result1 = bst.findLargestSmallerKey(17);
        System.out.println("Largest smaller number is " + result1);
    }

}
