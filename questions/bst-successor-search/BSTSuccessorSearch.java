public class BSTSuccessorSearch {

    static class Node {

        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    /*
        same as https://leetcode.com/problems/inorder-successor-in-bst-ii/
     */
    Node findInOrderSuccessor(Node inputNode) {
        if (inputNode.right != null) {
            // 找最右边的最左边
            inputNode = inputNode.right;
            while (inputNode.left != null) {
                inputNode = inputNode.left;
            }
            return inputNode;
        } else { // 右边为空，则往parent上方找
            while (inputNode.parent != null && inputNode.parent.right == inputNode) { // 往右侧方向上去
                inputNode = inputNode.parent;
            }
            return inputNode.parent; // 上去不了了，说明是目标节点的左侧，则返回这个目标节点
        }
    }
}
