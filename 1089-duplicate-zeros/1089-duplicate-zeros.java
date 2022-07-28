class Solution {
    public void duplicateZeros(int[] arr) {
        int zero = 0;
        for(int i : arr){
            if(i == 0) zero++;
        }
        int n = arr.length;

        for(int i = n -1; i >= 0; i--){
            int cur = i + zero;
            if(cur < n)
                arr[cur] = arr[i];
            if(arr[i] == 0){
                if(cur - 1 < n)
                    arr[cur - 1] = arr[i];
                zero--;
            }
            
        }
        
    }
}