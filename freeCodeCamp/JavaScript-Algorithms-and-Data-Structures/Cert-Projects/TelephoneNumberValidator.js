function telephoneCheck(str) {
  let closePar = str.match(/\)/g);
  let openPar = str.match(/\(/g);
  let isCloseParAtStart = str.indexOf('(') === 0;
  let isOpenParAtEnd = str.indexOf(')') === (str.length-1);
  if(isCloseParAtStart && isOpenParAtEnd){
    return false;
  }

  if(closePar && openPar){
    str = str.replace('(','').replace(')','');
  }

  return /^1{0,1}\s?[0-9]{3}[-. ]?[0-9]{3}[-. ]?[0-9]{4}$/.test(str);
}
let number = "1 (555)555-5555";
let isValidNumber = telephoneCheck(number);
console.log(isValidNumber);
/*
Return true if the passed string looks like a valid US phone number.

The user may fill out the form field any way they choose as long as it has the format of a valid US number. The following are examples of valid formats for US numbers (refer to the tests below for other variants):

555-555-5555
(555)555-5555
(555) 555-5555
555 555 5555
5555555555
1 555 555 5555

For this challenge you will be presented with a string such as 800-692-7753 or 8oo-six427676;laskdjf. Your job is to validate or reject the US phone number based on any combination of the formats provided above. The area code is required. If the country code is provided, you must confirm that the country code is 1. Return true if the string is a valid US phone number; otherwise return false.
*/
