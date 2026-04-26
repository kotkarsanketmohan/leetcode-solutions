class Solution {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        char c = (char)(x+'0');
        if(s.charAt(0)==c)
            return false;
        return s.indexOf(c)!=-1;
        
    }
}