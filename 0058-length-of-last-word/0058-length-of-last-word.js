/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    let sa = s.trim().split(" ");

    return sa[sa.length-1].length;
};