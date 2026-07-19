class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int sum1 = (coordinate1.charAt(0) - 'a' + 1) + (coordinate1.charAt(1) - '0');
        int sum2 = (coordinate2.charAt(0) - 'a' + 1) + (coordinate2.charAt(1) - '0');
        return (sum1 % 2) == (sum2 % 2);
    }
}