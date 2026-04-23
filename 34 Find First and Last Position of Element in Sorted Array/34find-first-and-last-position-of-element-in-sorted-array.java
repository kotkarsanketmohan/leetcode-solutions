class Solution {

    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);

        if (lb == nums.length || nums[lb] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{lb, ub - 1};
    }

    private int lowerBound(int[] a, int target) {
        int st = 0, end = a.length;

        while (st < end) {
            int mid = st + (end - st) / 2;

            if (a[mid] < target) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }
        return st;
    }

    private int upperBound(int[] a, int target) {
        int st = 0, end = a.length;

        while (st < end) {
            int mid = st + (end - st) / 2;

            if (a[mid] <= target) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }
        return st;
    }
}