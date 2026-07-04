class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1)
            return word;

        char[] arr = word.toCharArray();
        reverse(arr, 0, index);

        return new String(arr);
    }
    void reverse(char[] arr, int left, int right) {
        if (left >= right)
            return;

        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverse(arr, left + 1, right - 1);
    }
}