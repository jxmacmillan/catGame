import edu.princeton.cs.algs4.Edge;
public class CatEdge extends Edge{
    private double weight;

    public CatEdge(int v, int w)
        {
            super(v, w, 1.0);
        }

    public void changeWeight(double newWeight) {
        weight = newWeight;
    }

    public double weight() {
        return weight;
    }
    
}
