package Ex02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/9/29.
 */
public class Solver {
    private SearchNode currentNode;
    private SearchNode twinCurrentNode;
    private Stack<Board> solution;


    private class SearchNode implements Comparable<SearchNode> {
        public Board board;
        public int moves;
        public SearchNode preSearchNode;
        public final int priority;

        public SearchNode(Board initBoard, SearchNode inPreSearchNode) {
            board = initBoard;
            preSearchNode = inPreSearchNode;
            if (preSearchNode == null) moves = 0;
            else moves = preSearchNode.moves + 1;
            priority = moves + board.manhattan();
        }

        @Override
        public int compareTo(SearchNode o) {
            return Integer.compare(this.priority, o.priority);
        }
    }


    //find a solution to the initial board,using A* algorithms
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();
        Board twinInitial = initial.twin();
        currentNode = new SearchNode(initial, null);
        twinCurrentNode = new SearchNode(twinInitial, null);
        MinPQ<SearchNode> pq = new MinPQ<SearchNode>();
        MinPQ<SearchNode> twinPQ = new MinPQ<SearchNode>();
        pq.insert(currentNode);
        twinPQ.insert(twinCurrentNode);
        while (true) {
            currentNode = pq.delMin();
            if (currentNode.board.isGoal()) {
                break;
            }
            putNeighborsIntoPQ(currentNode, pq);
            twinCurrentNode = twinPQ.delMin();
            if (twinCurrentNode.board.isGoal()) {
                break;
            }
            putNeighborsIntoPQ(twinCurrentNode, twinPQ);
        }
    }

    //is the initial board solvable?
    public boolean isSolvable() {
        return currentNode.board.isGoal();
    }

    //min number of moves to solve initial board:-1 if unsolvable
    public int moves() {

        if (isSolvable()) {
            return currentNode.moves;
        } else {
            return -1;
        }
    }

    //sequence of boards in a shortest solution: null if unsolvable
    public Iterable<Board> solution() {
        if (currentNode.board.isGoal()) {
            solution = new Stack<>();
            SearchNode node = currentNode;
            while (node != null) {
                solution.push(node.board);
                node = node.preSearchNode;
            }
            return solution;
        } else {
            return null;
        }
    }

    private void putNeighborsIntoPQ(SearchNode searchNode, MinPQ pq) {
        for (Board board : searchNode.board.neighbors()) {
            if (searchNode.preSearchNode == null || !board.equals(searchNode.preSearchNode.board)) {
                pq.insert(new SearchNode(board, searchNode));
            }
        }
    }

    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
