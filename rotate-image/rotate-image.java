class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int col = matrix[0].length;
        int row = matrix.length;
        
        int first = 0;
        int last = row - 1;
        while(first < last){
            int[] tmp = matrix[first];
            matrix[first] = matrix[last];
            matrix[last] = tmp;
            first++;    
            last--;
        }

        for(int i = 0; i < row; i++){
            for(int j = i + 1; j < col; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }
}