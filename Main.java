import java.util.Random;
import java.util.ArrayList;

class Main extends Thread {

     
    static int NUMOFNODES = 10;
    static Node[] nodes = new Node[NUMOFNODES];
    static Window window;
    static Draw draw;


    public static void main(String[] args) {
        
        window = new Window();
        draw = new Draw();
        window.add(draw);
        
        // skapa nodes
        Random random = new Random();
        for (int i = 0; i < NUMOFNODES; i++) {
            nodes[i] = new Node(random.nextInt(Window.WIDTH - 50), random.nextInt(Window.HEIGHT - 50));
        }
        // gör nodes till grannar
        for (int i = 0; i < NUMOFNODES; i++) {
            for (int j = i+1; j < NUMOFNODES; j++) {
                nodes[i].addNeighbor(nodes[j]);
            }
        }

        ArrayList<Node> shortestPath = new ArrayList<>();
        shortestPath.add(nodes[0]);
        TSP.solveRecursively(nodes, shortestPath, nodes[0], 0); 
        
    }
}
