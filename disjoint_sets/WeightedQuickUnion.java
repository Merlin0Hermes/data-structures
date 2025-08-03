package disjoint_sets;

public class WeightedQuickUnion implements DisjointSets {
    private int[] parent;

    public WeightedQuickUnion(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = -1;
        }
    }

    public int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        return find(parent[x]);
    }

    @Override
    public void connect(int p, int q) {
        int proot = find(p);
        int qroot = find(q);

        int pweight = parent[proot];
        int qweight = parent[qroot];

        if (-pweight < -qweight) {
            parent[qroot] += pweight;
            parent[proot] = qroot;
        }
        else {
            parent[proot] += qweight;
            parent[qroot] = proot;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        WeightedQuickUnion wq = new WeightedQuickUnion(10);
        for (int i = 2; i < 10; ++i) {
            wq.connect(i, 1);
        }
    }
}