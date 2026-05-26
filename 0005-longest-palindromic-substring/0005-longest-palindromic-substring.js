/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let ans  ="";

    for(let i = 0; i < s.length; i++){


        let odd = helper(s, i, i);
        if(odd.length > ans.length) ans = odd;
        let even = helper(s, i, i+1);
        if(even.length > ans.length) ans = even;
    }

    return ans;
};

function helper(s, i, j){
    let res = "";

    let left = i;
    let right = j;
    while(left >= 0 && right < s.length && s[left] === s[right]){
        left--;
        right++;
    }

    return s.slice(left+1, right);
}