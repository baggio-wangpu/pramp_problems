public class SalesPath {

    static class Node {
        int cost;
        Node[] children;

        Node(int cost) {
            this.cost = cost;
            children = null;
        }
    }

    static int getCheapestCost(Node rootNode) {
        if (rootNode == null) return 0;

        if (rootNode.children == null) return rootNode.cost;

        int minCost = Integer.MAX_VALUE;
        for (Node n : rootNode.children) {
            int cost = getCheapestCost(n);
            minCost = Math.min(minCost, cost + rootNode.cost);
        }
        return minCost;
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        Node c11 = new Node(5);
        Node c12 = new Node(3);
        Node c13 = new Node(6);

        root.children = new Node[3];
        root.children[0] = c11;
        root.children[1] = c12;
        root.children[2] = c13;

        Node c21 = new Node(4);
        Node c22 = new Node(2);
        Node c23 = new Node(0);
        Node c24 = new Node(1);
        Node c25 = new Node(5);

        c11.children = new Node[1];
        c11.children[0] = c21;

        c12.children = new Node[2];
        c12.children[0] = c22;
        c12.children[1] = c23;

        c13.children = new Node[2];
        c13.children[0] = c24;
        c13.children[1] = c25;

        Node c31 = new Node(1);
        Node c32 = new Node(10);
        c22.children = new Node[1];
        c23.children = new Node[1];
        c22.children[0] = c31;
        c23.children[0] = c32;

        Node c41 = new Node(1);
        c31.children = new Node[1];
        c31.children[0] = c41;

        System.out.println("Sales path : " + getCheapestCost(root));
    }
}
