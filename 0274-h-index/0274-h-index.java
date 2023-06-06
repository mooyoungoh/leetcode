class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int hIndex = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int numOfPapers = citations.length - i;
            if (citations[i] >= numOfPapers) {
                hIndex = numOfPapers;
            } else {
                break;
            }
        }

        return hIndex;
    }
}