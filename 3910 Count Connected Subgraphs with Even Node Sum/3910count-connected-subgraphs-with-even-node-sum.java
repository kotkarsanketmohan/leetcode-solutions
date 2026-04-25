class Solution {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        boolean[][] g = new boolean[n][n];

        for(int[] e : edges) {
            g[e[0]][e[1]] = true;
            g[e[1]][e[0]] = true;
        }
        int ans = 0;

        for(int mask = 1; mask<(1<<n); mask++) {
            int sum=0, start = -1;

            for(int i=0; i<n;i++) {
                if((mask & (1<<i))!=0) {
                    sum += nums[i];
                    if(start == -1)
                        start=i;
                }
            }
            if(sum%2!=0)
                continue;

            boolean[] vis = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            vis[start] = true;

            int count = 1;

            while(!q.isEmpty()) {
                int u = q.poll();
                for(int v=0; v<n; v++) {
                    if((mask&(1<<v))!=0 && g[u][v] && !vis[v]) {
                        vis[v] = true;
                        q.add(v);
                        count++;
                    }
                }
            }
            int total = Integer.bitCount(mask);
            if(count == total) ans++;
        }
        return ans;
    }
}