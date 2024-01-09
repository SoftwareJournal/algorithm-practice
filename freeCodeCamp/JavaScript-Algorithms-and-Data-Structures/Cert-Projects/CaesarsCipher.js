function rot13(str) {
    let alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    let alphLen = alphabet.length;
    let alphArr = alphabet.split('');
    
    let newStrArr = [];
    let oldStrArr = str.split('');
    for(let index = 0;index < oldStrArr.length;index++){
      if(oldStrArr[index]===' '){
       newStrArr.push(' ');
       continue;
      }
      if(alphArr.indexOf(oldStrArr[index])===-1){
        newStrArr.push(oldStrArr[index]);
        continue;
      }
      let positionOfLetter = alphArr.indexOf(oldStrArr[index]);
      //console.log(positionOfLetter);
      let shifter = 13;
      while(shifter > -1){
        if(positionOfLetter < 0){
          positionOfLetter = alphLen-1;
        }
  
        if(shifter === 0){
          newStrArr.push(alphArr[positionOfLetter]);
        }
        shifter--;
        positionOfLetter--;
      }
    }
    console.log(newStrArr.join(''))
    return newStrArr.join('');
  }
  
  rot13("SERR CVMMN!");