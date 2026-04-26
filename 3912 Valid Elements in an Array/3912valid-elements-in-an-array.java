class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        if(n==1) {
            res.add(nums[0]);
            return res;
        }
        int[] lM = new int[n];
        int[] rM = new int[n];

        lM[0] = nums[0];

        for(int i=1; i<n; i++) {
            lM[i] = Math.max(lM[i-1],nums[i]);
        }
        rM[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            rM[i] = Math.max(rM[i+1],nums[i]);
        }
        for(int i=0; i<n; i++) {
            if(i==0||i==n-1) {
                res.add(nums[i]);
            } else if(nums[i]>lM[i-1] || nums[i] > rM[i+1]){
                res.add(nums[i]);
            }
        }
        return res;
    }
}