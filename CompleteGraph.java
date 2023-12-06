public class CompleteGraph {
    public static void main(String[] args) {
        // Specify the number of vertices in the complete graph
        int numVertices = 16;

        // Create a complete graph adjacency matrix
        int[][] completeGraph = createCompleteGraph(numVertices);

        // Print the complete graph adjacency matrix in the specified format
        printMatrix(completeGraph);
    }

    // Function to create a complete graph adjacency matrix
    private static int[][] createCompleteGraph(int numVertices) {
        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                // Connect every pair of distinct vertices
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