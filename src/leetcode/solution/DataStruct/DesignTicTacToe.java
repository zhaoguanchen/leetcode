package leetcode.solution.DataStruct;

/**
 * 348. Design Tic-Tac-Toe
 */
public class DesignTicTacToe {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);

    }
}


class TicTacToe {


    private int[] rowArr;

    private int[] colArr;

    private int diagonal;

    private int antiDiagonal;

    private int n;


    public TicTacToe(int n) {
        this.n = n;
        rowArr = new int[n];
        colArr = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        rowArr[row] += add;
        colArr[col] += add;
        if (row == col) {
            diagonal += add;
        }
        if (row == n - col - 1) {
            antiDiagonal += add;
        }


        if (Math.abs(rowArr[row]) == n || Math.abs(colArr[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
            return player;
        }


        return 0;
    }
}