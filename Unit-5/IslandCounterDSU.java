import java.util.*;

public class IslandCounterDSU {
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static int numIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        DSU dsu = new DSU(m * n);

        int[][] dirs = {{0,1}, {1,0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dirs) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni < m && nj < n && grid[ni][nj] == 1) {
                            dsu.union(i * n + j, ni * n + nj);
                        }
                    }
                }
            }
        }

        Set<Integer> uniqueIslands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    uniqueIslands.add(dsu.find(i * n + j));
                }
            }
        }
        return uniqueIslands.size();
    }                         

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };
        System.out.println("Number of islands (DSU): " + numIslands(grid));
    }
}