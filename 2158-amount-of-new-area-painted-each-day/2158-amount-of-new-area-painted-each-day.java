class Solution {
    public int[] amountPainted(int[][] paint) {
        int[] answer = new int[paint.length];
        int[] arr = new int[50001];
        for (int i = 0; i < paint.length; i++) {
            int count = 0;
            int index = paint[i][0];
            while (paint[i][1] > index) {
                if (arr[index] == 0) {
                    arr[index] = paint[i][1];
                    count++;
                    index++;
                } else {
                    index = arr[index];
                }
            }
            answer[i] = count;
        }
        return answer;
        
    }
}