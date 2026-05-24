/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {    
    let ans = 0;
    nums.sort((a,b) => a - b);
    for(let i = 0; i < nums.length; i++){
        if(ans === nums[i]){
            ans++;
        }
        else{
            return ans;
        }
    }
    return ans;
};