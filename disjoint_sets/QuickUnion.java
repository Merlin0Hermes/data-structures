package disjoint_sets;

public class QuickUnion implements DisjointSets {
    private int[] parent;

    public QuickUnion(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    @Override
    public void connect(int p, int q) {
        parent[find(p)] = find(q);

    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}