$(() => {
    var changeTextArray=[$("#d_day1"), $("#d_day2")]; 

    var startTimeArray = [
        new Date(Date.UTC(2022, 03, 19, 06, 00, 00)), 
        new Date(Date.UTC(2022, 03, 22, 06, 00, 00))
    ]; 

    var endTimeArray = [
        new Date(Date.UTC(2022, 03, 21, 06, 00, 00)), 
        new Date(Date.UTC(2022, 03, 24, 06, 00, 00))
    ]; 

    var remaintime = (date1, date2) => {
        return Math.ceil((date1.getTime() - date2.getTime())/(1000*60*60*24));
    }

    timeCheck(changeTextArray[0],startTimeArray[0],endTimeArray[0]);
    timeCheck(changeTextArray[1],startTimeArray[1],endTimeArray[1]);

    function timeCheck (changeText,startDate,endDate) {
        
        var nowDate = new Date();
        var transText;

        if(document.documentElement.lang=='en'){
            
            transText=['Sale Start','Sale End','Sale Closed']
        } else if(document.documentElement.lang=='ja'){

            transText=['販売オープン','販売終了','販売終了']
        } else if(document.documentElement.lang=='zt'){

            transText=['開始販賣','販賣結束','販賣結束']
        }

        if(remaintime(startDate,nowDate)>0){

            changeText.text(transText[0]+" D - "+remaintime(startDate,nowDate));
        } else if(remaintime(startDate,nowDate)==0){

            changeText.text(transText[0]+" D - Day");
        } else{
            
            if(remaintime(endDate,nowDate)>0){
                changeText.text(transText[1]+" D - "+remaintime(endDate,nowDate));
            }else{
                changeText.text(transText[2]+"closed");
            }
        }
    }
});