class Solution {
    public int peakIndexInMountainArray(int[] a) {
        int st = 0, end = a.length - 1;

        while (st < end) {
            int mid = st + (end - st) / 2;

            if (a[mid] < a[mid + 1]) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }
        return st;
    }
}