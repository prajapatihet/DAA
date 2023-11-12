public class NQueens {
    private final int N;
    public NQueens(int N) {
        this.N = N;
    }
    public void solveNQ() {
        int[][] board = new int[N][N];
        if (solveNQUtil(board, 0)) {
            printSolution(board);
            return;
        }
        System.out.println("Solution does not exist");

    }
    boolean isSafe(int board[][], int row, int col) {
        int i, j;
// Check this row on left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
// Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
// Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }
    private boolean solveNQUtil(int[][] board, int col) {
        if (col == N)
            return true;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(board, col + 1))
                    return true;
                board[i][col] = 0; // Backtrack
            }
        }
        return false;
    }
    private void printSolution(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int N = 4; // Change N to the desired board size
        NQueens queens = new NQueens(N);
        queens.solveNQ();
    }
}
