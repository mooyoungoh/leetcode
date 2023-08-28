class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int left = 0;
        int top = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++) ans.add(matrix[top][i]);
            for(int i = top + 1; i <= bottom; i++) ans.add(matrix[i][right]);
            if(left < right && top < bottom){
                for(int i = right - 1; i > left; i--) ans.add(matrix[bottom][i]);
                for(int i = bottom; i > top; i--) ans.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}