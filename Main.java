import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class Main {

     
    static int NUMOFNODES = 14;
    static Node[] nodes = new Node[NUMOFNODES];
    static Node[] bestPath = new Node[NUMOFNODES];
    static Node[] attemptedPath = new Node[NUMOFNODES];
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
        attemptedPath = nodes.clone();
        bestPath = nodes.clone();

        List<Node> path = new ArrayList<Node>();
        path.add(nodes[0]);

        
        // RecursiveSolution.solveRecursively(nodes, path, nodes[0], 0); 
        GeneticAlgorithmSolution.geneticAlgorithmSolve(nodes);
        
    }
}
