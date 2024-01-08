
// ES6 provides the syntactic sugar to eliminate
// the redundancy of having to write x: x. You can 
// simply write x once, and it will be converted to 
// x: x (or something equivalent) under the hood. 
const createPerson = (name, age, gender) => {
    // Only change code below this line
      return {name,
      age,
      gender}
    // Only change code above this line
};