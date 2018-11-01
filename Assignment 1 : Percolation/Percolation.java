import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/*
 * The Percolation class builds an n x n topGrid of WeightedQuickUnionUF objects
 * All nodes are blocked at the initialization
 * They will be opened if they connect to the virtual top node
 * A virtual top and bottom node is added to check if they connect
 * And to go against backwashing

 * @author Thomas de Lange
 */

public class Percolation {

    private WeightedQuickUnionUF topGrid;
    private WeightedQuickUnionUF bottomGrid;
    private int n; //Number of nodes
    private  boolean[] open; //true == open, false == blocked
    private int virtualTop;
    private int virtualBottom;

    /*
     * @param n the number of nodes in a single row/column
	 * @throws IllegalArgumentException if n <= 0
	 *
	 * */

    Percolation(int n) throws IllegalArgumentException{
        if(n<=0) throw new IllegalArgumentException("n cannot be less than or equal to 0.");
        this.n = n;
        topGrid = new WeightedQuickUnionUF(n*n + 2);
        bottomGrid = new WeightedQuickUnionUF(n*n + 2);
        open = new boolean[n*n];
        virtualTop = xyTo1D(n,n);
        virtualBottom = xyTo1D(n,n);

    }
    public void open(int row, int col){
        if (isOpen(row, col))
            return;
        validateIndices(row, col);
        open[xyTo1D(row, col)] = true;
        connectWithSurroundingOpenSites(row,col);
    }

    public boolean isOpen(int row, int col)
    {
        validateIndices(row,col);
        return open[xyTo1D(row,col)] == true;
    }

    public boolean isFull(int row, int col)
    {
        validateIndices(row,col);
        return bottomGrid.connected(xyTo1D(row,col), virtualTop);
    }

    public boolean percolates()
    {
        return topGrid.connected(virtualTop, virtualBottom);
    }

    //Private methods

    private int xyTo1D(int row, int col){
        validateIndices(row, col);
        return ((n*(row-1)+col)-1);

    }

    private void validateIndices(int row, int col) throws IndexOutOfBoundsException
    {
        if(!isValid(row,col))
            throw new IndexOutOfBoundsException("Invalid indices provided.");
    }

    private boolean isValid(int row, int col)
    {
        // convert row & col to from 1-indexed row/col to array index values
        row -= 1;
        col -= 1;
        return row>=0 && col>=0 && row<n && col<n;
    }
    private void connectWithSurroundingOpenSites(int row, int col) {
        int index = xyTo1D(row, col);

        if (row == 1) {
            // connecting node to virtualTop if it is in first row
            // in topGrid & bottomGrid UF objects
            topGrid.union(virtualTop, index);
            bottomGrid.union(virtualTop, index);
        }
        if (row == n) {
            // connecting index node to virtualBottom if it is in last row
            // ONLY for topGrid UF object
            // Not connecting for bottomGrid UF object to prevent backwash
            topGrid.union(virtualBottom, index);
        }
        if (isValid(row, col - 1) && isOpen(row, col - 1)) {
            // connecting index node to it's left node if open (for topGrid & bottomGrid)
            topGrid.union(xyTo1D(row, col - 1), index);
            bottomGrid.union(xyTo1D(row, col - 1), index);
        }
        if (isValid(row, col + 1) && isOpen(row, col + 1)) {
            // connecting index node to right node if open (for topGrid & bottomGrid)
            topGrid.union(xyTo1D(row, col + 1), index);
            bottomGrid.union(xyTo1D(row, col + 1), index);
        }
        if (isValid(row - 1, col) && isOpen(row - 1, col)) {
            // connecting index node to top node if open (for topGrid & bottomGrid)
            topGrid.union(xyTo1D(row - 1, col), index);
            bottomGrid.union(xyTo1D(row - 1, col), index);
        }
        if (isValid(row + 1, col) && isOpen(row + 1, col)) {
            // connecting index node to bottom node if open (for topGrid & bottomGrid)
            topGrid.union(xyTo1D(row + 1, col), index);
            bottomGrid.union(xyTo1D(row + 1, col), index);
        }
    }

}
