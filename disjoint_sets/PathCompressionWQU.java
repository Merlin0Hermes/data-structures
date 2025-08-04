package disjoint_sets;

public class PathCompressionWQU extends WeightedQuickUnion {
    public PathCompressionWQU(int N) {
        super(N);
    }

    @Override
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}