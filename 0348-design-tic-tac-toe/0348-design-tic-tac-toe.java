class TicTacToe {

    int[] rows, cols;
    int d1, d2, n;
    
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        d1 = 0;
        d2 = 0;
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int val = (player == 1) ? 1 : -1;
        int target = (player == 1) ? n : -n;
        
        if(row == col){
            d1 += val;
            if(d1 == target) return player;
        }
        
        if(row + col + 1 == n){
            d2 += val;
            if(d2 == target) return player;
        }
        
        rows[row] += val;
        cols[col] += val;
        
        if(rows[row] == target || cols[col] == target) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */