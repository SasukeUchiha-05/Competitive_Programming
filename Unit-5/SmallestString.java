import java.util.*;

public class SmallestString {
    static class DSU {
        private int[] parent;
        private int[] rank;

        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        String T = sc.next();
        sc.close();

        int n = A.length();
        DSU dsu = new DSU(26);
        for (int i = 0; i < n; i++) {
            int a = A.charAt(i) - 'a';
            int b = B.charAt(i) - 'a';
            dsu.union(a, b);
        }
        char[] smallest = new char[26];
        for (int i = 0; i < 26; i++) {
            smallest[i] = (char) ('z' + 1);
        }
        for (int c = 0; c < 26; c++) {
            int root = dsu.find(c);
            char ch = (char) (c + 'a');
            if (ch < smallest[root]) {
                smallest[root] = ch;
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch : T.toCharArray()) {
            int idx = ch - 'a';
            int root = dsu.find(idx);
            result.append(smallest[root]);
        }
        System.out.println(result.toString());
    }
}