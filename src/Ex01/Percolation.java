package Ex01;
/**
 * Created by Administrator on 2017/8/28.
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private final int N;
    private final WeightedQuickUnionUF grid;
    private final WeightedQuickUnionUF fullness;
    private final boolean[] open;
    private final int virtualTop;
    private final int virtualBotom;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        N = n;
        this.grid = new WeightedQuickUnionUF(N * N + 2);
        this.fullness = new WeightedQuickUnionUF(N * N + 1);
        this.open = new boolean[N * N];
        this.virtualTop = xyto1D(N, N) + 1;
        this.virtualBotom = xyto1D(N, N) + 2;
    }

    public void open(int row, int col) {
        validate(row, col);
        if (isOpen(row, col)) return;
        open[xyto1D(row, col)] = true;
        connectWithSurroundingOpenSites(row, col);
    }

    public boolean isOpen(int row, int col) {
        return open[xyto1D(row, col)];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);
        return fullness.connected(xyto1D(row, col), virtualTop);
    }

    public boolean percolates() {
        return grid.connected(virtualTop, virtualBotom);
    }

    public int numberOfOpenSites() {
        int num = 0;
        for (int i = 0; i < open.length; i++) {
            if (open[i]) num++;
        }
        return num;
    }

    private int xyto1D(int row, int col) {
        validate(row, col);
        return (row - 1) * N + (col - 1);
    }

    private void validate(int row, int col) {
        if (row < 1 || col < 1 || row > N || col > N) throw new IllegalArgumentException();
    }

    private void connectWithSurroundingOpenSites(int row, int col) {
        validate(row, col);
        int index = xyto1D(row, col);
        if (row == 1) {
            grid.union(virtualTop, index);
            fullness.union(virtualTop, index);
        }
        if (row == N) {
            grid.union(virtualBotom, index);
        }
        if (col > 1 && isOpen(row, col - 1)) {
            fullness.union(xyto1D(row, col - 1), index);
            grid.union(xyto1D(row, col - 1), index);
        }
        if (col < N && isOpen(row, col + 1)) {
            fullness.union(xyto1D(row, col + 1), index);
            grid.union(xyto1D(row, col + 1), index);
        }
        if (row > 1 && isOpen(row - 1, col)) {
            fullness.union(xyto1D(row - 1, col), index);
            grid.union(xyto1D(row - 1, col), index);
        }
        if (row < N && isOpen(row + 1, col)) {
            fullness.union(xyto1D(row + 1, col), index);
            grid.union(xyto1D(row + 1, col), index);
        }
    }

}
