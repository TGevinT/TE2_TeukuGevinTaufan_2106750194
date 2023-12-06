import java.util.Random;

public class RandomGraph {
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

    public static void printRandomMatrix(int n) {
        int[][] adj = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = random.nextInt(2);
            }
        }

        printMatrix(adj);
    }

    public static void main(String[] args) {
        printRandomMatrix(20);
    }
}

