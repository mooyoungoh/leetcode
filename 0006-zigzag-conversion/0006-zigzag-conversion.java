class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) sb[i] = new StringBuilder();
        int k = 0; int index = 0;
        for(char c : s.toCharArray()){
            sb[index].append(c);
            if(index==0)k=1;
            if(index==numRows-1)k=-1;
            index+=k;
        }
        return String.join("",sb);
    }
}