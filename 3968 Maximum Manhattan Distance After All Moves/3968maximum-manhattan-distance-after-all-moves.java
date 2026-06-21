class Solution {
    public int maxDistance(String moves) {
        int dx = 0, dy = 0, q = 0;
        for(char ch: moves.toCharArray()) {
            if(ch=='R') dx++;
            else if(ch=='L') dx--;
            else if(ch=='U') dy++;
            else if(ch=='D') dy--;
            else if (ch=='_') q++;
        }
        return Math.abs(dx) + Math.abs(dy) + q;
    }
}