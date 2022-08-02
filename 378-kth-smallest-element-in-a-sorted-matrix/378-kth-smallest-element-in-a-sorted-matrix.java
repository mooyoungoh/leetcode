class Solution {
  public int kthSmallest(int[][] matrix, int k) {
         
        int m = matrix.length, n = matrix[0].length; // For general, the matrix need not be a square
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }
        return maxHeap.peek();  
  }
}
      /*
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
*/