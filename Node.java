import java.util.ArrayList;

class Node {

    int x, y;
    ArrayList<Node> neighbors = new ArrayList<Node>();

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void addNeighbor(Node a) {
        this.neighbors.add(a);
        a.neighbors.add(this);
    }
}