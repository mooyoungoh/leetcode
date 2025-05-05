class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", 
                          "L", "XL", "X", "IX", "V", "IV", "I"};

        // Corresponding values for each Roman numeral symbol
        int[] values = {1000, 900, 500, 400, 100, 90, 
                        50, 40, 10, 9, 5, 4, 1};
       
        int i = 0;
        while(num > 0){
            while(num >= values[i]){
                num -= values[i];
                sb.append(roman[i]);
            }
            i++;
        }
        return sb.toString();
    }
}