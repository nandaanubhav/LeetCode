/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function(...args) {
    console.log(typeof args);
    let arguments = 0;
    for(el in args) arguments++;
    return arguments;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */