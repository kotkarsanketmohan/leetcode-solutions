class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        int[] sorted = score.clone();
        Arrays.sort(sorted);

        HashMap<Integer,Integer> rank = new HashMap<>();
        int position = 1;

        for(int i = n - 1; i >= 0; i--) {
            rank.put(sorted[i], position++);
        }
        String[] ans = new String[n];

        for(int i = 0; i < n; i++) {

            int r = rank.get(score[i]);

            if(r == 1) {
                ans[i] = "Gold Medal";
            }
            else if(r == 2) {
                ans[i] = "Silver Medal";
            }
            else if(r == 3) {
                ans[i] = "Bronze Medal";
            }
            else {
                ans[i] = String.valueOf(r);
            }
        }
        return ans;
    }
}