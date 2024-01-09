function palindrome(str) {
    let newStr = str.replace(/\W/g, '');
    newStr = newStr.replace('_','').replace(' ','').toLowerCase();
    let revStr = newStr.split('').reverse().join('');
    return newStr === revStr;
}

palindrome("A man, a plan, a canal. Panama");