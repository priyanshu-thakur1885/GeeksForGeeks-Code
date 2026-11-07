import java.util.*;

class Solution {
    static ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        ArrayList<Integer> dist = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            dist.add((int) 1e8);
        }

        dist.set(src, 0);

        // Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {

            for (int[] edge : edges) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist.get(u) != (int) 1e8 &&
                    dist.get(u) + wt < dist.get(v)) {

                    dist.set(v, dist.get(u) + wt);
                }
            }
        }

        // Check for negative weight cycle
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist.get(u) != (int) 1e8 &&
                dist.get(u) + wt < dist.get(v)) {

                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(-1);
                return ans;
            }
        }

        return dist;
    }
}