let hello = "   Hello, World!  ";
let wsRegex2 = /(\s*)(\w)(\s*)/; // Change this line
let wsRegex = /^\s+|\s+$/g; // Change this line
let result2 = hello.replace(wsRegex2,"$2"); // Change this line
let result = hello.replace(wsRegex,"");
console.log(result);
console.log(result2);
/*
Sometimes whitespace characters around strings are not wanted but are there. Typical processing of strings is to remove the whitespace at the start and end of it.

Write a regex and use the appropriate string methods to remove whitespace at the beginning and end of strings.

Note: The String.prototype.trim() method would work here, but you'll need to complete this challenge using regular expressions.
*/