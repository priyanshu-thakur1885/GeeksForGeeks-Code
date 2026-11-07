class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;

        int[] minCost = new int[n];
        boolean[] visited = new boolean[n];

        // Initially, every house has infinite connection cost
        for (int i = 0; i < n; i++) {
            minCost[i] = Integer.MAX_VALUE;
        }

        // Start from house 0
        minCost[0] = 0;

        int totalCost = 0;

        for (int count = 0; count < n; count++) {

            // Find unvisited house with minimum connection cost
            int u = -1;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && (u == -1 || minCost[i] < minCost[u])) {
                    u = i;
                }
            }

            // Add this house to MST
            visited[u] = true;
            totalCost += minCost[u];

            // Update costs of remaining houses
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {

                    int distance =
                        Math.abs(houses[u][0] - houses[v][0]) +
                        Math.abs(houses[u][1] - houses[v][1]);

                    minCost[v] = Math.min(minCost[v], distance);
                }
            }
        }

        return totalCost;
    }
}