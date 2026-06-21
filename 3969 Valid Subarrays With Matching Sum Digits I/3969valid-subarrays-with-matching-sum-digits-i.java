class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        long ans = 0;
        int n = nums.length;
        for(int i = 0; i<n; i++) {
            long sum = 0;
            for(int j = i; j<n; j++) {
                sum += nums[j];
                if(isValid(sum,x)) {
                    ans++;
                }
            }
        }
        return (int) ans;
    }
    private boolean isValid(long sum, int x) {
        if(sum%10 != x) return false;

        long temp = sum;
        while(temp >= 10) {
            temp/=10;
        }
        return temp == x;
    }
}