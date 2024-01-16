

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
    return Number(parseFloat(num).toFixed(decimalPlaces));
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
  
  //console.log('change remaining:',5.25%10);
  //console.log(100%100);
  //console.log(parseFloat(1.01%.01).toFixed(0) == '0');
  //console.log(parseFloat(.59%.25).toFixed(2));
  //console.log(parseFloat(20%10).toFixed(0) == '0');

  //Get the change
  for(let index = cid.length-1;index >= 0;index--){
    let multiplyOfRegister = Number(parseFloat(cid[index][1]/currencyMapping[cid[index][0]]).toFixed(0));
    let multiplyOfChangeAmount = round(Math.floor(changeAmount/currencyMapping[cid[index][0]]),2);
    let remainderChange = round(changeAmount%currencyMapping[cid[index][0]],2);

    console.log('multiply:',currencyMapping[cid[index][0]]);
    console.log('mor:',multiplyOfRegister);
    console.log('moca:',multiplyOfChangeAmount);
    console.log('remainderChange:',parseFloat(remainderChange).toFixed(2));

    changeAmount = round(changeAmount,2);
    if(remainderChange === changeAmount){
      continue;
    }

    if(multiplyOfRegister >= multiplyOfChangeAmount){
      changeAmount = round(multiplyOfChangeAmount*currencyMapping[cid[index][0]],2);
      if(changeAmount != 0){
        change.change.push([cid[index][0],changeAmount]);
      }
      changeAmount = round(remainderChange,2);
    }else{
      let multiplySub = multiplyOfChangeAmount - multiplyOfRegister;
      changeAmount = round(multiplySub*currencyMapping[cid[index][0]],2);
      if(changeAmount != 0){
        change.change.push([cid[index][0],changeAmount]);
      }
    }
      
    
    console.log('changeAmount: ',changeAmount);
    //#2,3
    if(parseFloat(changeAmount).toFixed(2) === '0.00'){
      change.status = 'OPEN';
      break;
    } 
  }

  //#5 Check for scenario when the changeAmount isn't equal to zero 
  if(parseFloat(changeAmount).toFixed(2) != '0.00'){
    change.status = 'INSUFFICIENT_FUNDS';
    change.change = [];
    console.log(change);
    return change;
  }
  //console.log(changeAmount);  
  //console.log(totalInRegister);  
  console.log(change);
  return change;
}

checkCashRegister(19.5, 20,[["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 0.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]]);