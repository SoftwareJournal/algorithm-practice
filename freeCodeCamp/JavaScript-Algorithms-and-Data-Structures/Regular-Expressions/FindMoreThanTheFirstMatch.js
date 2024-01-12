let twinkleStar = "Twinkle, twinkle, little star";
let starRegex = /Twinkle/gi; // Change this line
let result = twinkleStar.match(starRegex); // Change this line
//Note
//You can have multiple flags on your regex like /search/gi
//flags
// g - global
// i - ignore case