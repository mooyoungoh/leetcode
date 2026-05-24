/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    let walker = n;
    let runner = goNext(n);
    while(runner != 1 && walker != runner){
        walker = goNext(walker);
        runner = goNext(goNext(runner));
    }
    return runner === 1;
};

var goNext = function(n){
    let res = 0;

    while (n !== 0) {
        let digit = n % 10;
        res += digit * digit;
        n = Math.floor(n / 10);
    }

    return res;
};