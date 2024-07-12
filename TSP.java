import java.util.ArrayList;

class TSP {
    
    static int minDistance = Integer.MAX_VALUE;
    static int absDistance = 0;
    static ArrayList<Node> bestPath;
    
    static void solveRecursively(Node[] nodes, ArrayList<Node> path, Node curNode, int curDistance) {
        if (path.size() >= nodes.length) {
            if (curDistance < minDistance) {
                bestPath = new ArrayList<>(path);
                minDistance = curDistance;
             
            }
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = TSP.bestPath.get(i);
                // nodes[i] = path.get(i);
            }
            // Main.window.add(draw);
            Main.window.revalidate();
            Main.window.repaint(); 

            return;
        }
        for (Node neighbor : curNode.neighbors) {
            if (!path.contains(neighbor)) {
                
                path.add(neighbor);
                absDistance =   (int) Math.sqrt((
                                      Math.pow(curNode.x - neighbor.x, 2) + 
                                      Math.pow(curNode.y - neighbor.y, 2)
                                                ));
                curDistance += absDistance;
                solveRecursively(nodes, path, neighbor, curDistance);
                absDistance =   (int) Math.sqrt((
                                      Math.pow(curNode.x - neighbor.x, 2) + 
                                      Math.pow(curNode.y - neighbor.y, 2)
                                                ));
                curDistance -= absDistance;
                path.remove(path.size() - 1);
            }
        }
    }
}
