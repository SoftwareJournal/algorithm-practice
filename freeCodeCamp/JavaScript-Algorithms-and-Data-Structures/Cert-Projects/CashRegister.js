

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
    
    let currencyMapping = {
      'PENNY':0.01,
      'NICKEL':0.05,
      'DIME':0.10,
      'QUARTER':0.25,
      'ONE':1,
      'FIVE':5,
      'TEN':10,
      'TWENTY':20,
      'ONE HUNDRED':100,
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
    console.log(parseFloat(.59%.25).toFixed(2));
    console.log(parseFloat(20%10).toFixed(0) == '0');

    //Split the number by the decimal
    let changeAmountArr = parseFloat(changeAmount).toFixed(2).split('.');
    changeAmountArr[1] = '.'+changeAmountArr[1];
    console.log(changeAmountArr);

    //Get the change
    let difference = 0;
    for(let index = cid.length-1;index > 0;index--){
      //#2,3
      if(parseFloat(changeAmountArr[0]).toFixed(0) === '0' && parseFloat(changeAmountArr[1]).toFixed(0) === '0'){
        change.status = 'OPEN';
        break;
      }

      //Big bills first
      if(cid[index][0] === "ONE HUNDRED"){
        if(parseFloat(changeAmountArr[0]).toFixed(0) === '0'){
          continue;
        }
      }
      if(cid[index][0] === "TWENTY"){
        if(parseFloat(changeAmountArr[0]).toFixed(0) === '0'){
          continue;
        }
      }
      if(cid[index][0] === "TEN"){
        if(parseFloat(changeAmountArr[0]).toFixed(0) === '0'){
          continue;
        }
      }
      if(cid[index][0] === "FIVE"){
        if(parseFloat(changeAmountArr[0]).toFixed(0) === '0'){
          continue;
        }
      }
      if(cid[index][0] === "ONE"){
        if(parseFloat(changeAmountArr[0]).toFixed(0) === '0'){
          continue;
        }
      }
      //Small coins last
      if(cid[index][0] === "QUARTER"){
        let multiplyOfRegister = cid[index][1]/currencyMapping[cid[index][0]];
        let multiplyOfChangeAmout = Number(parseFloat(changeAmountArr[1]/currencyMapping[cid[index][0]]).toFixed(0));
        let remainderChange = changeAmountArr[1]%currencyMapping[cid[index][0]];
        console.log('mor:',multiplyOfRegister);
        console.log('moca:',multiplyOfChangeAmout);
        console.log('remainderChange:',remainderChange);
        if(remainderChange > 0){
          //do nothing
        }
        change.change.push([cid[index][0],Number(parseFloat(changeAmountArr[1]).toFixed(1))]);
        changeAmountArr[1] = 0;
      } 
    }

    //#5 Check for scenario when the changeAmount isn't equal to zero 
    if(parseFloat(changeAmountArr[0]).toFixed(0) != '0' && parseFloat(changeAmountArr[1]).toFixed(0) != '0'){
      change.status = 'INSUFFICIENT_FUNDS';
      change.change = [];
      return change;
    }
    //console.log(changeAmount);  
    //console.log(totalInRegister);  
    console.log(change);
    return change;
  }

  checkCashRegister(19.5, 20,   [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]]);