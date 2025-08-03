package disjoint_sets;

public class WeightedQuickUnion implements DisjointSets {
    private int[] parent;
    private int[] size;

    public WeightedQuickUnion(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = i;
            size[i] = 1;
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
        int proot = find(p);
        int qroot = find(q);

        if (proot == qroot) {
            return;
        }

        if (size[proot] < size[qroot]) {
            size[qroot] += size[proot];
            parent[proot] = qroot;
        }
        else {
            size[proot] += size[qroot];
            parent[qroot] = proot;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        WeightedQuickUnion wq = new WeightedQuickUnion(10);
        wq.connect(1, 4);
        wq.connect(2, 3);
        wq.connect(2, 1);
        wq.connect(2, 9);
    }
}