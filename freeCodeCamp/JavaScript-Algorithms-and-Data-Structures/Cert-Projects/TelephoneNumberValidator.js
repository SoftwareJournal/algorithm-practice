function telephoneCheck(str) {
  return /1*\s*([0-9]{3})-*\s*[0-9]{3}-*\s*[0-9]{4}/.test(str);
}
let number = "1 456 789 4444";
let isValidNumber = telephoneCheck(number);
console.log(isValidNumber);
  
  