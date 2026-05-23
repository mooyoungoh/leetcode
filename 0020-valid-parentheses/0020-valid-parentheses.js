/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let stk = new Stack();
    for(let i = 0; i < s.length; i++){
        if(s[i] === ')'){
            if(stk.pop() != '(') return false;
        }else if(s[i] === ']'){
            if(stk.pop() != '[') return false;
        }else if(s[i] === '}'){
            if(stk.pop() != '{') return false;
        }else{
            stk.push(s[i]);
        }
    }
    return stk.isEmpty();
};