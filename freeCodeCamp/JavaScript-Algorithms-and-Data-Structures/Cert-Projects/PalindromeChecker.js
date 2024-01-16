function palindrome(str) {
  let newString = str.replace(/\W/g,'').replace('_','').replace(' ','').toLowerCase();
  let revString = newString.split('').reverse().join('');
  return revString === newString;
}

palindrome('eye');