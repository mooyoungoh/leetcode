class Solution {
    public int compress(char[] chars) {
        int i = 0; // read;
        int index = 0; // write;

        while(i < chars.length){
            char cur = chars[i];
            int count = 0;
            while(i < chars.length && cur == chars[i]){
                i++;
                count++;
            }
            chars[index++] = cur;
            if(count > 1){
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }            
            }
        }
        return index;
    }
}