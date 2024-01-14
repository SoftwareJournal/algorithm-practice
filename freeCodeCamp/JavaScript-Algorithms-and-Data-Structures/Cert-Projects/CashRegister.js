

function checkCashRegister(price, cash, cid) {
    let change = {
      status:'',
      change: []
    };
    let changeAmount = cash - price;
    let totalInRegister = 0.00;
    let round = (num, decimalPlaces = 0)=>{
      //num = Math.round(num + "e" + decimalPlaces);
      //return Number(num + "e" + -decimalPlaces);
      //console.log(Number.parseFloat(num).toFixed(2));
      return parseFloat(Number.parseFloat(num).toFixed(decimalPlaces));
    }
    
    let convertToDecimal = (num)=>{
      return num/100;
    }

    //Get TotalInRegister
    for(let index = 0;index < cid.length;index++){
      let currencyUnit = round(cid[index][1],2);
      totalInRegister = totalInRegister+currencyUnit;
    }

    //#6 Check for scenario where the changeAmount is more than totalInRegister
    if(changeAmount === totalInRegister){
      change.status = 'CLOSED';
      change.change = [...cid];
      return change;
    }
  
  
    //#4 Check for scenario where the changeAmount is more than totalInRegister 
    if(changeAmount > totalInRegister){
      change.status = 'INSUFFICIENT_FUNDS';
      return change;
    }
    
    console.log(4.25%.25);
    console.log(100%100);
    console.log(parseFloat(1.01%.01).toFixed(0) == '0');
    console.log(parseFloat(55%.25).toFixed(0) == '0');
    console.log(parseFloat(20%10).toFixed(0) == '0');

    //Split the number by the decimal
    let changeAmountArr = parseFloat(changeAmount).toFixed(2).split('.');
    changeAmountArr[1] = '.'+changeAmountArr[1];
    console.log(changeAmountArr);
    for(let index = cid.length-1;index > 0;index--){
      if(parseFloat(changeAmountArr[0]).toFixed(0) === '0' && parseFloat(changeAmountArr[1]).toFixed(0) === '0'){
        change.status = 'OPEN';
        break;
      }
      //Big bills first
      if(cid[index][0] === "QUARTER"){
        cid[index][1] = cid[index][1] - changeAmountArr;
        change.change.push([cid[index][0],Number(parseFloat(changeAmountArr[1]).toFixed(1))]);
        console.log(change);
        changeAmountArr[1] = 0;
      } 
    }

    if(changeAmountArr[0] != 0 && changeAmountArr[1] != 0){
      change.status = 'INSUFFICIENT_FUNDS';
      return change;
    }
    //console.log(changeAmount);  
    //console.log(totalInRegister);  
    console.log(change);
    return change;
  }

  checkCashRegister(19.5, 20,   [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]]);