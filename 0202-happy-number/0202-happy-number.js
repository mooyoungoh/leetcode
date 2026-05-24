/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    let walker = n;
    let runner = go(n);
    while(walker !== runner && runner !== 1){
        walker = go(walker);
        runner = go(runner);
        if(runner != null) runner = go(runner);
    }
    return runner === 1;
};

var go = function(n){
    let ans = 0;
    while(n != 0){
        let tmp = n % 10;
        ans+= tmp * tmp;
        n = Math.floor(n / 10);
    }
    return ans;
}