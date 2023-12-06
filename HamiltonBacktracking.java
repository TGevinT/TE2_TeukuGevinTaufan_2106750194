/* Java program for solution of Hamiltonian Path problem
   using backtracking */
class HamiltonBacktracking {
    int V;
    int path[];

    /*
     * A utility function to check if the vertex v can be
     * added at index 'pos' in the Hamiltonian Path
     * constructed so far (stored in 'path[]')
     */
    boolean isSafe(int v, int graph[][], int path[], int pos) {
        /*
         * Check if this vertex is an adjacent vertex of
         * the previously added vertex.
         */
        if (graph[path[pos - 1]][v] == 0)
            return false;

        /*
         * Check if the vertex has already been included.
         * This step can be optimized by creating an array
         * of size V
         */
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }

    /*
     * A recursive utility function to solve Hamiltonian
     * path problem
     */
    boolean hamPathUtil(int graph[][], int path[], int pos) {
        /*
         * base case: If all vertices are included in
         * Hamiltonian Path
         */
        if (pos == V)
            return true;

        // Try different vertices as a next candidate in
        // Hamiltonian Path.
        for (int v = 1; v < V; v++) {
            /*
             * Check if this vertex can be added to Hamiltonian
             * Path
             */
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                /* recur to construct the rest of the path */
                if (hamPathUtil(graph, path, pos + 1) == true)
                    return true;

                /*
                 * If adding vertex v doesn't lead to a solution,
                 * then remove it
                 */
                path[pos] = -1;
            }
        }

        /*
         * If no vertex can be added to Hamiltonian Path
         * constructed so far, then return false
         */
        return false;
    }

    /*
     * This function solves the Hamiltonian Path problem using
     * Backtracking. It mainly uses hamPathUtil() to solve the
     * problem. It returns false if there is no Hamiltonian Path
     * possible, otherwise return true and prints the path.
     * Please note that there may be more than one solutions,
     * this function prints one of the feasible solutions.
     */
    Boolean hamPath(int graph[][], int N) {
        V = N;
        path = new int[V];
        for (int i = 0; i < V; i++)
            path[i] = -1;

        /*
         * Let us put vertex 0 as the first vertex in the path.
         * If there is a Hamiltonian Path, then the path can be
         * started from any point of the path as the graph is
         * undirected
         */
        path[0] = 0;
        return hamPathUtil(graph, path, 1);
    }

    // driver program to test above function
    public static void main(String args[]) {
        long startMemory, endMemory;
        long startTime, endTime;
        double memory, time;

        HamiltonBacktracking hamiltonian = new HamiltonBacktracking();

        // waktu menghitung dihabis di awal lebih lama, jadi jalanin sekali
        // hamiltonBacktracking
        System.out.println("Tidak dipakai dikarenakan waktu awal ada inisiasi pada class");
        System.out.println("**********************************************************************");
        int grafawal[][] = {
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }
        };

        int N = grafawal.length;

        System.gc();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println("graph with 16 vertex: " + (hamiltonian.hamPath(grafawal, N) ? "yes" : "no"));
        endTime = System.nanoTime();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memory = (endMemory - startMemory) / 1_048_576.0;
        time = (endTime - startTime) / 1_000_000.0;
        System.out.printf("start Memory: %d%n", startMemory);
        System.out.printf("end Memory: %d%n", endMemory);
        System.out.printf("start time: %d%n", startTime);
        System.out.printf("end time: %d%n", endTime);
        System.out.println("Time(ms): " + String.format("%.4f", time));
        System.out.println("Memory(MB): " + String.format("%.4f", memory));
        System.out.println("**********************************************************************\n");

        int complete16[][] = {
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }
        };

        N = complete16.length;

        System.gc();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println("Complete graph with 16 vertex: " + (hamiltonian.hamPath(complete16, N) ? "yes" : "no"));
        endTime = System.nanoTime();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memory = (endMemory - startMemory) / 1_048_576.0;
        time = (endTime - startTime) / 1_000_000.0;
        System.out.printf("start Memory: %d%n", startMemory);
        System.out.printf("end Memory: %d%n", endMemory);
        System.out.printf("start time: %d%n", startTime);
        System.out.printf("end time: %d%n", endTime);
        System.out.println("Time(ms): " + String.format("%.4f", time));
        System.out.println("Memory(MB): " + String.format("%.4f", memory) + "\n");

        int disconnect16[][] = {
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 }
        };
        System.gc();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println("Disconnect graph with 16 vertex: " + (hamiltonian.hamPath(disconnect16, N) ? "yes" : "no"));
        endTime = System.nanoTime();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memory = (endMemory - startMemory) / 1_048_576.0;
        time = (endTime - startTime) / 1_000_000.0;
        System.out.printf("start Memory: %d%n", startMemory);
        System.out.printf("end Memory: %d%n", endMemory);
        System.out.printf("start time: %d%n", startTime);
        System.out.printf("end time: %d%n", endTime);
        System.out.println("Time(ms): " + String.format("%.4f", time));
        System.out.println("Memory(MB): " + String.format("%.4f", memory) + "\n");

        int random16[][] = {
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
                { 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 },
                { 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1 },
                { 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0 },
                { 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0 }
        };
        System.gc();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println("Random graph with 16 vertex: " + (hamiltonian.hamPath(random16, N) ? "yes" : "no"));
        endTime = System.nanoTime();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memory = (endMemory - startMemory) / 1_048_576.0;
        time = (endTime - startTime) / 1_000_000.0;
        System.out.printf("start Memory: %d%n", startMemory);
        System.out.printf("end Memory: %d%n", endMemory);
        System.out.printf("start time: %d%n", startTime);
        System.out.printf("end time: %d%n", endTime);
        System.out.println("Time(ms): " + String.format("%.4f", time));
        System.out.println("Memory(MB): " + String.format("%.4f", memory) + "\n");

        int complete18[][] = {
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }
        };
        N = complete18.length;

        System.gc();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println("Complete graph with 18 vertex: " + (hamiltonian.hamPath(complete18, N) ? "yes" : "no"));
        endTime = System.nanoTime();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memory = (endMemory - startMemory) / 1_048_576.0;
        time = (endTime - startTime) / 1_000_000.0;
        System.out.printf("start Memory: %d%n", startMemory);
        System.out.printf("end Memory: %d%n", endMemory);
        System.out.printf("start time: %d%n", startTime);
        System.out.printf("end time: %d%n", endTime);
        System.out.println("Time(ms): " + String.format("%.4f", time));
        System.out.println("Memory(MB): " + String.format("%.4f", memory) + "\n");

        int disconnect18[][] = {
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 }
        };
        System.gc();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println("Disconnect graph with 18 vertex: " + (hamiltonian.hamPath(disconnect18, N) ? "yes" : "no"));
        endTime = System.nanoTime();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memory = (endMemory - startMemory) / 1_048_576.0;
        time = (endTime - startTime) / 1_000_000.0;
        System.out.printf("start Memory: %d%n", startMemory);
        System.out.printf("end Memory: %d%n", endMemory);
        System.out.printf("start time: %d%n", startTime);
        System.out.printf("end time: %d%n", endTime);
        System.out.println("Time(ms): " + String.format("%.4f", time));
        System.out.println("Memory(MB): " + String.format("%.4f", memory) + "\n");

        int random18[][] = {
                { 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                { 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 },
                { 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1 },
                { 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1 }
        };
        System.gc();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println("Random graph with 18 vertex: " + (hamiltonian.hamPath(random18, N) ? "yes" : "no"));
        endTime = System.nanoTime();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memory = (endMemory - startMemory) / 1_048_576.0;
        time = (endTime - startTime) / 1_000_000.0;
        System.out.printf("start Memory: %d%n", startMemory);
        System.out.printf("end Memory: %d%n", endMemory);
        System.out.printf("start time: %d%n", startTime);
        System.out.printf("end time: %d%n", endTime);
        System.out.println("Time(ms): " + String.format("%.4f", time));
        System.out.println("Memory(MB): " + String.format("%.4f", memory) + "\n");

        int complete20[][] = {
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }
        };
        N = complete20.length;

        System.gc();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println("Complete graph with 20 vertex: " + (hamiltonian.hamPath(complete20, N) ? "yes" : "no"));
        endTime = System.nanoTime();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memory = (endMemory - startMemory) / 1_048_576.0;
        time = (endTime - startTime) / 1_000_000.0;
        System.out.printf("start Memory: %d%n", startMemory);
        System.out.printf("end Memory: %d%n", endMemory);
        System.out.printf("start time: %d%n", startTime);
        System.out.printf("end time: %d%n", endTime);
        System.out.println("Time(ms): " + String.format("%.4f", time));
        System.out.println("Memory(MB): " + String.format("%.4f", memory) + "\n");

        int disconnect20[][] = {
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }
        };
        System.gc();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println("Disconnect graph with 20 vertex: " + (hamiltonian.hamPath(disconnect20, N) ? "yes" : "no"));
        endTime = System.nanoTime();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memory = (endMemory - startMemory) / 1_048_576.0;
        time = (endTime - startTime) / 1_000_000.0;
        System.out.printf("start Memory: %d%n", startMemory);
        System.out.printf("end Memory: %d%n", endMemory);
        System.out.printf("start time: %d%n", startTime);
        System.out.printf("end time: %d%n", endTime);
        System.out.println("Time(ms): " + String.format("%.4f", time));
        System.out.println("Memory(MB): " + String.format("%.4f", memory) + "\n");

        int random20[][] = {
                { 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
                { 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0 },
                { 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1 },
                { 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0 },
                { 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0 },
                { 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
                { 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1 },
                { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1 },
                { 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0 },
                { 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0 }
        };
        System.gc();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println("Random graph with 20 vertex: " + (hamiltonian.hamPath(random20, N) ? "yes" : "no"));
        endTime = System.nanoTime();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memory = (endMemory - startMemory) / 1_048_576.0;
        time = (endTime - startTime) / 1_000_000.0;
        System.out.printf("start Memory: %d%n", startMemory);
        System.out.printf("end Memory: %d%n", endMemory);
        System.out.printf("start time: %d%n", startTime);
        System.out.printf("end time: %d%n", endTime);
        System.out.println("Time(ms): " + String.format("%.4f", time));
        System.out.println("Memory(MB): " + String.format("%.4f", memory) + "\n");
    }
}
