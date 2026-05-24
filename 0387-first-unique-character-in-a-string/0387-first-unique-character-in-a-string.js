/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let dict = [];
    for(let i = 0; i < s.length; i++){
        dict[s[i]] = (dict[s[i]] || 0) + 1;
    }
    
    for(let i = 0; i < s.length; i++){
        if(dict[s[i]] === 1){
            return i;
        }
    }
    return -1;
};