package Ex02;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/29.
 */
public class Board {
    private static final int BLANK = 0;
    private final int[][] blocks;
    private final int dim;

    //construct a board from n-by-n array of blocks,integer between 0 and n*n-1,0 represents blank square
    public Board(int[][] inblocks) {
        int n = inblocks.length;
        blocks = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j] = inblocks[i][j];
            }
        }
        dim = n;
    }

    //board dimension n
    public int dimension() {
        return blocks.length;
    }

    //number of blocks out of place
    public int hamming() {
        int n = 0;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (blocks[i][j] != BLANK && blocks[i][j] != (i * dim + j + 1)) {
                    n++;
                }
            }
        }
        return n;
    }

    //sum of manhattan distance from blocks and goal
    public int manhattan() {
        int sum = 0;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (blocks[i][j] != BLANK && blocks[i][j] != (i * dim + j + 1)) {
                    sum += calManhattan(blocks[i][j], i, j);
                }
            }
        }
        return sum;
    }

    private int calManhattan(int block, int i, int j) {
        int x1 = (block - 1) / dim;
        int y1 = block - 1 - dim * x1;
        return Math.abs(x1 - i) + Math.abs(y1 - j);
    }

    public boolean isGoal() {
        int[][] goal = new int[dim][dim];
        int n = 1;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                goal[i][j] = n;
                n++;
            }
        }
        goal[dim - 1][dim - 1] = 0;
        Board goalBoard = new Board(goal);
        return this.equals(goalBoard);
    }

    //a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        Board twinBoard = new Board(blocks);
        int firstRow = 0;
        int firstCol = 0;
        if (blocks[firstRow][firstCol] == BLANK) {
            firstCol++;
        }
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                if (blocks[row][col] != blocks[firstRow][firstCol] && blocks[row][col] != BLANK) {
                    twinBoard.swap(firstRow, firstCol, row, col);
                    return twinBoard;
                }
            }
        }
        return twinBoard;
    }

    private void swap(int x1, int y1, int x2, int y2) {
        int tmp = blocks[x1][y1];
        blocks[x1][y1] = blocks[x2][y2];
        blocks[x2][y2] = tmp;
    }

    //all neighbor boards
    public Iterable<Board> neighbors() {
        ArrayList<Board> neighbors = new ArrayList<Board>();
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                if (blocks[row][col] == BLANK) {
                    //exchange BLANK with up,down,left,right
                    if (row > 0) {
                        Board boardT = new Board(blocks);
                        boardT.swap(row, col, row - 1, col);
                        neighbors.add(boardT);
                    }
                    if (row < dim - 1) {
                        Board boardB = new Board(blocks);
                        boardB.swap(row, col, row + 1, col);
                        neighbors.add(boardB);
                    }
                    if (col > 0) {
                        Board boardL = new Board(blocks);
                        boardL.swap(row, col, row, col - 1);
                        neighbors.add(boardL);
                    }
                    if (col < dim - 1) {
                        Board boardR = new Board(blocks);
                        boardR.swap(row, col, row, col + 1);
                        neighbors.add(boardR);
                    }
                }
            }
        }
        return neighbors;
    }

    @Override
    public boolean equals(Object y) {

        if (y == null) return false;
        if (y == this) return true;
        if (y.getClass().isInstance(this)) {
            Board yb = (Board) y;
            if (yb.dim != this.dim) {
                return false;
            } else {
                for (int row = 0; row < dim; row++) {
                    for (int col = 0; col < dim; col++) {
                        if (yb.blocks[row][col] != this.blocks[row][col]) {
                            return false;
                        }
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(dim + "\n");
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                sb.append(String.format("%2d ", blocks[row][col]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(2 / 2);
        System.out.println(2 % 2);
        int[][] test = {{0, 1}, {2, 3}};
        Board b = new Board(test);
        System.out.println(b.toString());
        System.out.println(b.manhattan());
    }

}
