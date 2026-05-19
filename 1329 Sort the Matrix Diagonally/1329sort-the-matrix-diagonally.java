class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int row = 0; row < m; row++) {
            sortDiagonal(mat, row, 0);
        }

        for (int col = 1; col < n; col++) {
            sortDiagonal(mat, 0, col);
        }
        return mat;
    }
    public void sortDiagonal(int[][] mat, int row, int col) {
        List<Integer> list = new ArrayList<>();
        int r = row, c = col;

        while (r < mat.length && c < mat[0].length) {
            list.add(mat[r][c]);
            r++;
            c++;
        }
        Collections.sort(list);

        r = row;
        c = col;
        int i = 0;

        while (r < mat.length && c < mat[0].length) {
            mat[r][c] = list.get(i++);
            r++;
            c++;
        }
    }
}