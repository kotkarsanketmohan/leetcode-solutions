class Solution {
    public char kthCharacter(int k) {
        if (k == 1) {
            return 'a';
        }

        int length = 1;
        while (length < k) {
            length *= 2;
        }

        int half = length / 2;
        if (k <= half) {
            return kthCharacter(k);
        }
        char ch = kthCharacter(k - half);
        
        return (char) (ch + 1);
    }
}