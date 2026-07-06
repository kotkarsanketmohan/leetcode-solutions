class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch))
                return false;
                
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i'
                        || ch == 'o' || ch == 'u') {
                    hasVowel = true;
                } else {

                    hasConsonant = true;
                }
            }
        }
        return hasVowel && hasConsonant;
    }
}