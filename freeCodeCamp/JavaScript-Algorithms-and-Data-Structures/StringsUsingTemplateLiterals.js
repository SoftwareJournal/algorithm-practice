const result = {
    success: ["max-length", "no-amd", "prefer-arrow-functions"],
    failure: ["no-var", "var-on-top", "linebreak"],
    skipped: ["no-extra-semi", "no-dup-keys"]
  };
  function makeList(arr) {
    // Only change code below this line
    const failureItems = [];
    const failureArr = result.failure;
    for(let i=0;i<failureArr.length;i++){
      let literalString = `<li class="text-warning">${failureArr[i]}</li>`;
      failureItems.push(literalString); 
    }
    // Only change code above this line
  
    return failureItems;
  }
  
  const failuresList = makeList(result.failure);
  console.log(failuresList)