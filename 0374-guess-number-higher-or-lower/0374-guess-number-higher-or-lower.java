/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        int lo = 1;
        int hi = n;
        while(true){
            int mid = (hi - lo) / 2 + lo;
            if(guess(mid) == 0){
                return mid;
            }else if(guess(mid) == 1){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        
    }
}