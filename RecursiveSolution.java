import java.util.List;

class RecursiveSolution {
    
    static int minDistance = Integer.MAX_VALUE;
    static int absDistance = 0;
    static double count = 0;
    static double combinations = factorial(Main.NUMOFNODES - 1);
    static double percentage;

    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    
    static void solveRecursively(Node[] nodes, List<Node> path, Node curNode, int curDistance) {
        if (path.size() == Main.NUMOFNODES) {
            if (curDistance < minDistance) {
                for (int i = 0; i < Main.NUMOFNODES; i++) {
                    Main.bestPath[i] = path.get(i);
                }
                minDistance = curDistance;             
            }


            count++;
            percentage = count / combinations * 100;
            // System.out.println((double) Math.round(percentage * 100) / 100 + "% KLAR");
 
            for (int i = 0; i < Main.NUMOFNODES; i++) {
                Main.attemptedPath[i] = path.get(i);
            }

            return;
        }
        for (Node neighbor : curNode.neighbors) {
            if (!path.contains(neighbor)) {
                
                path.add(neighbor);
                absDistance =   (int) Math.sqrt(
                                      Math.pow(curNode.x - neighbor.x, 2) + 
                                      Math.pow(curNode.y - neighbor.y, 2)
                                                );
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
