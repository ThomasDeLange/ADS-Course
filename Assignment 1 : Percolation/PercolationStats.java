import com.company.Percolation;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * The PercolationStats class accepts two command line arguments n & T,
 * and runs a set (T) of Percolation experiments on an n x n grid,
 * collects the results (the percolation threshold of each experiment)
 * and calculates the mean, standard deviation, and upper/lower bound of the
 * 95% confidence interval.
 *
 * @author Thomas de Lange
 *
 */
public class PercolationStats {

    private int n;			// number of columns/rows in n x n grid
    private int T;			// number of times to run stats
    private double[] results;	// stores results of percolation experiments

    /**
     * Runs T percolation experiments on an n x n grid, and collects the
     * results (percolation threshold of each experiment)
     * @param n the number of nodes in a single row/column of an NxN grid
     * @param T the number of percolation experiments to run
     */
    public PercolationStats(int n, int T)
    {
        if(n<=0 || T<=0)
            throw new IllegalArgumentException("n & T must be greater than 0.");

        this.n = n;
        this.T = T;
        results = new double[T];

        for(int i=0;i< T;i++)
        {
            Percolation grid = new Percolation(n);
            int result = 0;
            while(!grid.percolates())
            {
                openRandomBlockedNode(grid);
                result++;
            }
            results[i] = (double) result / (double) (n*n);
        }
    }

    /**
     * Calculates the mean of the results
     * @return the mean of the results
     */
    public double mean()
    {
        return StdStats.mean(results);
    }

    /**
     * Calculate the standard deviation of the results
     * @return the standard deviation of the results
     */
    public double stddev()
    {
        return StdStats.stddev(results);
    }

    /**
     * Calculate the lower bound of the 95% confidence interval
     * @return the lower bound of the 95% confidence interval
     */
    public double confidenceLo()
    {
        return mean()-((1.96*stddev())/Math.sqrt(T));
    }

    /**
     * Calculate the lower bound of the 95% confidence interval
     * @return the upper bound of the 95% confidence interval
     */
    public double confidenceHi()
    {
        return mean()+((1.96*stddev())/Math.sqrt(T));
    }

    // PRIVATE HELPER METHODS

    //	Opens a random node, if the chosen random node is already open
    //	searches until a blocked node is found and opens it.
    //	@param grid the Percolation grid to search
    private void openRandomBlockedNode(Percolation grid)
    {
        boolean isOpen = true;
        int randomRow = 0;
        int randomCol = 0;
        while(isOpen)
        {
            randomRow = StdRandom.uniform(1,n+1);
            randomCol = StdRandom.uniform(1,n+1);

            isOpen = grid.isOpen(randomRow,randomCol);
        }
        grid.open(randomRow,randomCol);
    }

    /**
     * Test client, instantiates PercolationStats based on
     * command line arguments, runs mean(), stddev(),
     * confidenceLo() & confidenceHi().
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        int n = new Integer(args[0]);
        int T = new Integer(args[1]);

        PercolationStats stats = new PercolationStats(n,T);

        System.out.println("mean:\t\t\t\t = " + stats.mean());
        System.out.println("stddev:\t\t\t\t = " + stats.stddev());
        System.out.println("95% confidence interval:\t = " + stats.confidenceLo() + ", " + stats.confidenceHi());
    }

}
