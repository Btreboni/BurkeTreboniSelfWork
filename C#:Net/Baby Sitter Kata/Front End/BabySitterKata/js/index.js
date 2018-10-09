let wageRow = $('#wage-row');

$(document).ready(function(){
    runProgram();
});

function runProgram(){
    hideBoxTwo();
    hideBoxThree();
    onClickStartWageCalculatorButton();
}

function onClickStartWageCalculatorButton(){
    $("#start-wage-calculator-button").click(function(){
        hideBoxOne();
        showBoxTwo();
    });
}

function returnTime(time){
    return time;
}

function onFireWageCalculatorButton() {
    let startValue = Number(returnTime($('#start-time-value').val()));
    let downTimeValue = Number(returnTime($('#down-time-value').val()));
    let endTimeValue = Number(returnTime($('#end-time-value').val()));
    
    let validateHours = startValue > downTimeValue || startValue > endTimeValue || downTimeValue > endTimeValue;
    let areHoursNullOrEmpty = startValue === 0 || endTimeValue === 0 || downTimeValue === 0;

    if(validateHours){
        return alert("Sorry, an error occured. Please make sure that your hourly time-line is correct");
    }

    if(areHoursNullOrEmpty){
        return alert("Sorry, an error occured. Please make sure that all your start, down, and end times all have values.");
    }

    wageRow.empty();

    $.ajax({
        type: 'POST',
        //ATTENTION DEVELOPERS!
        //url : '**YourURLAddressGoesHere**/api/calculate/wages'
        url: 'https://localhost:5001/api/calculate/wages',
        dataType: 'json',
        contentType: 'application/json',
        processData: false, 
        data: JSON.stringify({
            "startTime": startValue,
            "downTime": downTimeValue,
            "endTime": endTimeValue
        }),

        success: function(data, textStatus, jQxhr){
            hideBoxTwo();
            showBoxThree();
            let wageToShow = '<h1>' + data + '</h1>'
            wageRow.append(wageToShow);
        },

        error: function(jQxhr, textStatus, errorThrown){
            console.log(errorThrown);
        }
    });
}

function onFireReCalculateButton(){
    hideBoxThree();
    clearValues();
    showBoxTwo();
}

function hideBoxOne(){
    $("#box-one").hide();
}

function showBoxTwo(){
    $("#box-two").show();
}

function hideBoxTwo(){
    $("#box-two").hide();
}

function showBoxThree(){
    $('#box-three').show();
}

function hideBoxThree(){
    $('#box-three').hide();
}

function clearValues(){
    clearStartValue();
    clearDownTimeValue();
    clearEndTimeValue();
}

function clearStartValue(){
    $('#start-time-value').val('');
}

function clearDownTimeValue(){
    $('#down-time-value').val('');
}

function clearEndTimeValue(){
    $('#end-time-value').val('');
}