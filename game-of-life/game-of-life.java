class Solution {

    public int count(int i, int j, int[][] board){
        int[][] dirs = {{0,-1}, {0,1},{1,0}, {1,1}, {1,-1}, {-1,0}, {-1,1}, {-1,-1}};
        int count = 0;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || y < 0 || x > board.length-1 || y > board[0].length-1){
                continue;
            }
            count += board[x][y];
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        int[][] tmp = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int neighbor = count(i, j, board);
                int cur = board[i][j];
                if(cur == 1 && neighbor < 2){
                    tmp[i][j] = 0;
                }else if(cur == 1 && (neighbor == 2 || neighbor == 3)){
                    tmp[i][j] = 1;
                }else if(cur == 1 && neighbor > 3){
                    tmp[i][j] = 0;
                }else if(cur == 0 && neighbor == 3){
                    tmp[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = tmp[i][j];
            }
        }
    }
}