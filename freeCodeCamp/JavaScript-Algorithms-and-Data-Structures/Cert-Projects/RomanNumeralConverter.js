function convertToRoman(num) {
    let numArr = num.toString().split('');
    let str = [];
    let place = 1;
    const roman = {
       1000: 'M',
       900: 'CM',
       500: 'D',
       400: 'CD',
       100: 'C',
       90: 'XC',
       50: 'L',
       40: 'XL',
       10: 'X',
       9: 'IX',
       5: 'V',
       4: 'IV',
       1: 'I'
     };
    for(let index = numArr.length-1;index >= 0;index--){
      let number = numArr[index];
      Number(number);
      console.log(number);
      
         number *= Math.pow(10,place-1); 
         if(roman.hasOwnProperty(number)){
           str.unshift(roman[number]);
         }else{
           if(number>5*Math.pow(10,place-1)){
             let multiBase = (number-5*Math.pow(10,place-1))/(1*Math.pow(10,place-1));
             for(let i = multiBase;i>0;i--){
               str.unshift(roman[1*Math.pow(10,place-1)]);
             }
             str.unshift(roman[5*Math.pow(10,place-1)]);
           }else{
             let multiBase = number/(1*Math.pow(10,place-1));
             for(let i = multiBase;i>0;i--){
               str.unshift(roman[1*Math.pow(10,place-1)]);
             }
           }
         }
       /*if(place===1){}else if(place===2){
         number *= 10;
         if(roman.hasOwnProperty(number)){
           str.unshift(roman[number]);
         }else{
           if(number>50){
             let multiBase = (number-50)/10;
             for(let i = multiBase;i>0;i--){
               console.log('hit');
               str.unshift(roman[10]);
             }
             str.unshift(roman[50]);
           }else{
             let multiBase = number/10;
             for(let i = multiBase;i>0;i--){
               console.log('hit');
               str.unshift(roman[10]);
             }
           }
         }
       }else if(place===3){
         number *=100;
         if(roman.hasOwnProperty(number)){
           str.unshift(roman[number]);
         }else{
           if(number>500){
             let multiBase = (number-500)/100;
             for(let i = multiBase;i>0;i--){
               str.unshift(roman[100]);
             }
             str.unshift(roman[500]);
           }else{
             let multiBase = number/100;
             for(let i = multiBase;i>0;i--){
               str.unshift(roman[100]);
             }
           }
         }
       }*/
      place++;
    } 
    console.log(str.join(''));
    return str.join('');
   }
   
   convertToRoman(45);