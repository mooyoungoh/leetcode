class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) sb[i] = new StringBuilder();
        int idx = 0, k = 0;
        for(char c : s.toCharArray()){
            sb[idx].append(c);
            if(idx==0) k=1;
            if(idx==numRows-1) k=-1;
            idx+=k;
        }
        return String.join("", sb);
    }
}