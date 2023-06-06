class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        boolean init = false;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length-1; i++){
            int tmp = arr[i] - arr[i+1];
            if(!init){
                diff = tmp;
                init = true;
            }
            if(init && tmp != diff){
                return false;
            }
        }
        
        return true;
    }
}