// Only change code below this line
let chewieRegex = /Aa*/; // Change this line
// Only change code above this line
let result = chewieQuote.match(chewieRegex);
console.log(result);
/*
The last challenge used the plus + sign to look for characters that occur one or more times. There's also an option that matches characters that occur zero or more times.

The character to do this is the asterisk or star: *.

let soccerWord = "gooooooooal!";
let gPhrase = "gut feeling";
let oPhrase = "over the moon";
//let goRegex = /go*/;
//soccerWord.match(goRegex);
//gPhrase.match(goRegex);
//oPhrase.match(goRegex);
//*/