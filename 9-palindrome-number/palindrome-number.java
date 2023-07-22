class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int xx = x;
        int tmp = 0;
        while(x > 0){
            int remain = x % 10;
            tmp = tmp * 10 + remain;
            x = x / 10;
        }

        return tmp == xx;
    }
}