

function checkCashRegister(price, cash, cid) {
    let change;
    let totalInRegister = 0;
    let round = (num, decimalPlaces = 0)=>{
      num = Math.round(num + "e" + decimalPlaces);
      return Number(num + "e" + -decimalPlaces);
    }
    
    for(let index = 0;index < cid.length;index++){
      totalInRegister += round(cid[index][1],2);
      console.log('Adding '+cid[index][0]+' '+ 'makes the total to be: '+ totalInRegister);
    }
  
    console.log(totalInRegister);
    return change;
  }
  
  
  
  checkCashRegister(19.5, 20,  [["PENNY", 1.01],
    ["NICKEL", 2.05],
    ["DIME", 3.1],
    ["QUARTER", 4.25],
    ["ONE", 90],
    ["FIVE", 55],
    ["TEN", 20],
    ["TWENTY", 60],
    ["ONE HUNDRED", 100]]);