class Solution {
    ArrayList<Integer> ans = new ArrayList<>();
    boolean[] seen = new boolean[1000];

    public int[] findEvenNumbers(int[] digits) {
        helper(digits, new boolean[digits.length], 0, 0);

        Collections.sort(ans);

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);

        return res;
    }
    void helper(int[] digits, boolean[] used, int count, int num) {
        if (count == 3) {
            if (num >= 100 && num % 2 == 0 && !seen[num]) {
                seen[num] = true;
                ans.add(num);
            }
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                helper(digits, used, count + 1, num * 10 + digits[i]);
                used[i] = false;
            }
        }
    }
}