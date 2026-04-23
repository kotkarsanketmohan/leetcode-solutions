class Solution {
    public int searchInsert(int[] a, int target) {
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
}