import edu.princeton.cs.algs4.DijkstraUndirectedSP;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Edge;

public class CatGame {
    private CatGraph graph;
    private int N;
    private boolean[] marked;
    private int catTile;
    private boolean catEscaped;
    private boolean catTrapped;
    private int July4th;

    public CatGame(int n) // n by n graph
    {
        N = n;
        marked = new boolean[n*n];
        graph = new CatGraph(n);
        July4th = n*n;
    }

    public void markTile(int row, int col)
    {
        marked[coordToGraph(row,col)] = true;
        DijkstraUndirectedSP catNext = new DijkstraUndirectedSP(graph, coordToGraph(row,col));
        int[] catNextCoord = graphToCoord(catNext.pathTo(July4th).iterator().next().other(catTile));
        catTile = coordToGraph(catNextCoord[0], catNextCoord[1]);
    }
    public boolean marked(int row, int col)
    {
        if(marked[coordToGraph(row, col)])
            return true;
        else
            return false;
    }
    private int coordToGraph(int row, int col)
    {
        return row*N + col;
    }
    private int[] graphToCoord(int v)
    {
        int[] coord = new int[2];
        coord[0] = v/N;
        coord[1] = v%N;
        return coord;
    }
    public int[] getCatTile()
    {
        return graphToCoord(catTile);
    }
    public boolean catHasEscaped()
    {
        if(catTile == July4th)
            return true;
        else
            return false;
    }
    public boolean catIsTrapped()
    {            
        DijkstraUndirectedSP catNext = new DijkstraUndirectedSP(graph, catTile);
        if(!catNext.hasPathTo(July4th))
            return true;
        else
            return false;
    }
}
