class Solution {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;
        int peak = 0;
        for(int i=1; i<n; i++) {
            if(nums[i] > nums[peak])
                peak=i;
        }
        long asc = 0,desc = 0;

        for(int i=0; i<=peak; i++) {
            asc+=nums[i];
        }
        for(int i=peak;i<n;i++) {
            desc += nums[i];
        }
        if(asc>desc)
            return 0;
        if(desc>asc)
            return 1;

        return -1;
    }
}