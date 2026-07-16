class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] position = new int[26];
        for (int i = 0; i < t.length(); i++) {
            position[t.charAt(i) - 'a'] = i;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Math.abs(i - position[s.charAt(i) - 'a']);
        }
        return sum;
    }
}