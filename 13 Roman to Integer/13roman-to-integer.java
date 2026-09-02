class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = val(s.charAt(i));
            int b = i + 1 < s.length() ? val(s.charAt(i + 1)) : 0;
            ans += a < b ? -a : a;
        }
        return ans;
    }
    int val(char c) {
        return c == 'I' ? 1 : c == 'V' ? 5 : c == 'X' ? 10 :
               c == 'L' ? 50 : c == 'C' ? 100 : c == 'D' ? 500 : 1000;
    }
}