package Ex01;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by Administrator on 2017/8/29.
 */
public class PercolationStats {
    private final int n;
    private final int trails;

    private final double[] grades;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        this.n = n;
        this.trails = trials;
        grades = getResults();
    }

    public double mean() {
        return StdStats.mean(grades);
    }

    public double stddev() {
        return StdStats.stddev(grades);
    }

    public double confidenceLo() {
        return StdStats.mean(grades) - 1.96 * StdStats.stddev(grades) / Math.sqrt(trails);
    }

    public double confidenceHi() {
        return StdStats.mean(grades) + 1.96 * StdStats.stddev(grades) / Math.sqrt(trails);
    }

    private double[] getResults() {
        double[] num = new double[trails];
        Percolation percolation;
        for (int i = 0; i < trails; i++) {
            percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                percolation.open(row, col);
            }
            int opensites = percolation.numberOfOpenSites();
            double rate = opensites * 1.0 / (n * n);
            num[i] = rate;
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 20;
        int trail = 10;
        if (args.length == 2) {
            n = Integer.parseInt(args[0]);
            trail = Integer.parseInt(args[1]);
        }
        PercolationStats ps = new PercolationStats(n, trail);
        System.out.println("mean                                    = " + ps.mean());
        System.out.println("stdev                                   = " + ps.stddev());
        System.out.println("95% confidence interval                 = [" + ps.confidenceLo() + "," + ps.confidenceHi() + "]");
    }
}
