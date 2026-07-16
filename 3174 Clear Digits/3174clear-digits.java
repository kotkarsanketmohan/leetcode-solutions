class Solution {
    public String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                ans.append(ch);
            } else {
                ans.deleteCharAt(ans.length() - 1);
            }
        }
        return ans.toString();
    }
}