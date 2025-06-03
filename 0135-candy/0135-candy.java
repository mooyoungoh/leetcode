class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        
        int ans = 0;
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i - 1] < ratings[i]){
                left[i] = left[i - 1] + 1;
            }
        }

        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i + 1] < ratings[i]){
                right[i] = right[i + 1] + 1;
            }
        }        

        for(int i = 0; i < ratings.length; i++){
            ans+= Math.max(left[i], right[i]);
        }
        return ans;
    }
}