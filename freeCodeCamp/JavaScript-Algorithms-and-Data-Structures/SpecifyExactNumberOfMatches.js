let timStr = "Timmmmber";
let timRegex = /Tim{4}ber/g; // Change this line
let result = timRegex.test(timStr);
/*
You can specify the lower and upper number of patterns with quantity specifiers using curly brackets. Sometimes you only want a specific number of matches.

To specify a certain number of patterns, just have that one number between the curly brackets.

For example, to match only the word hah with the letter a 3 times, your regex would be /ha{3}h/.

In order, the three test calls would return false, true, and false.
*/