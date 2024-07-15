import java.util.Random;

class GeneticAlgorithmSolution {

    static int populationSize = 10000;
    static double mutateRate = 0.1;
    static int generations = 1000;
    static int bestCurFitness = Integer.MIN_VALUE;
    static int bestFitness = Integer.MIN_VALUE;
    static int bestCurIndex;
    static int bestIndex;


    static Random random = new Random();
    static Node[][] population = new Node[populationSize][Main.NUMOFNODES];

    static void swap(Node[] path, int i, int j) {
        Node temp = path[i];
        path[i] = path[j];
        path[j] = temp;
    }

    static void shuffle(Node[] path) {
        for (int i = 0; i < Main.NUMOFNODES; i++) {
            swap(path, i, random.nextInt(Main.NUMOFNODES));
        }
    }

    static void randomSwap(Node[] path) {
        int firstIndex = random.nextInt(Main.NUMOFNODES - 1) + 1;
        int secondIndex = random.nextInt(Main.NUMOFNODES - 1) + 1;

        Node temp = path[firstIndex];
        path[firstIndex] = path[secondIndex];
        path[secondIndex] = temp;
    }

    static void mutate(Node[][] population) {
        for (Node[] path : population) {
            for (int i = 1; i < Main.NUMOFNODES; i++) {
                if (random.nextDouble() < mutateRate) {
                    randomSwap(path);
                }
            }
        }
    }

    static int getFitness(Node[] path) {
        int pathLength = 0;

        for (int i = 0; i < Main.NUMOFNODES - 1; i++) {
            pathLength += Math.sqrt(
                                    Math.pow(path[i+1].x - path[i].x, 2) + 
                                    Math.pow(path[i+1].y - path[i].y, 2)
                                    );
        }

        return -pathLength;
    }

    static void tournament(Node[][] population) {
        int firstIndex;
        int secondIndex;

        for (int i = 0; i < populationSize / 2; i++) {
            firstIndex = random.nextInt(populationSize - i) + i;
            secondIndex = random.nextInt(populationSize - i) + i;
            if (getFitness(population[firstIndex]) > getFitness(population[secondIndex])) {
                population[i] = population[firstIndex].clone();
            }
            else {
                population[i] = population[secondIndex].clone();
            }
        }
    }
    
    static void geneticAlgorithmSolve(Node[] nodes) {
        
        // Initialize population
        for (int i = 0; i < populationSize; i++) {
            population[i] = nodes.clone();
            for (int j = 0; j < Main.NUMOFNODES; j++) {
                shuffle(population[j]);
            }
        }

        for (int n = 0; n < generations; n++) {
            bestCurFitness = Integer.MIN_VALUE;

            tournament(population);
            mutate(population);

            for (int i = 0; i < populationSize; i++) {
                if (getFitness(population[i]) > bestCurFitness) {
                    bestCurFitness = getFitness(population[i]);
                    bestCurIndex = i;
                }
                if (bestCurFitness > bestFitness) {
                    bestFitness = bestCurFitness;
                    bestIndex = bestCurIndex;
                    Main.bestPath = population[bestIndex].clone();
                    // System.out.println(bestIndex + " " + bestCurFitness);
                }
            }
            Main.attemptedPath = population[bestCurIndex].clone();

            System.out.println(n);
            // System.out.println(bestFitness);

        }
    }
}
