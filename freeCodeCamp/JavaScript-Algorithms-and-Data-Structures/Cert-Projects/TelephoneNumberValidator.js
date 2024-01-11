function telephoneCheck(str) {
  return /^1*\s*([0-9]{3})-*\s*[0-9]{3}-*\s*[0-9]{4}$/.test(str);
}
let number = "1 (2555) 456 4582";
let isValidNumber = telephoneCheck(number);
console.log(isValidNumber);


  
  