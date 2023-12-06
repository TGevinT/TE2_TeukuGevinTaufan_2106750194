public class DisconnectedGraph {
    public static void main(String[] args) {
        // Specify the number of vertices in the disconnected graph
        int numVertices = 20;

        // Create a disconnected graph adjacency matrix
        int[][] disconnectedGraph = createDisconnectedGraph(numVertices);

        // Print the disconnected graph adjacency matrix in the specified format
        printMatrix(disconnectedGraph);
    }

    // Function to create a disconnected graph adjacency matrix
    private static int[][] createDisconnectedGraph(int numVertices) {
        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        // First component
        for (int i = 0; i < numVertices / 2; i++) {
            for (int j = 0; j < numVertices / 2; j++) {
                // Connect every pair of distinct vertices in the first component
                adjacencyMatrix[i][j] = (i != j) ? 1 : 0;
            }
        }

        // Second component
        for (int i = numVertices / 2; i < numVertices; i++) {
            for (int j = numVertices / 2; j < numVertices; j++) {
                // Connect every pair of distinct vertices in the second component
                adjacencyMatrix[i][j] = (i != j) ? 1 : 0;
            }
        }

        return adjacencyMatrix;
    }

    // Function to print a matrix in the specified format
    private static void printMatrix(int[][] matrix) {
        System.out.println("{");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("    {");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("}");
            if (i < matrix.length - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("};");
    }
}

