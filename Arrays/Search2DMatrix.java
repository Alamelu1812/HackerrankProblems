/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        
        int r = 0, c = matrix[0].length -1;
        while(r<matrix.length && c>=0){
            if(matrix[r][c] < target)
                r++;
            else if(matrix[r][c] > target)
                c--;
            else
                return true;
        }
        return false;
    }
}
