class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            int mid = (i + j) / 2;
            if(arr[mid] < arr[mid + 1]){
                i = mid + 1;
            }else{
                j = mid;
            }
        }
        return i;
    }
}