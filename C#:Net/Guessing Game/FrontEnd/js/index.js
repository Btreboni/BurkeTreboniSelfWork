
let numberToGuess = 0;
let message = $('#message');

$(document).ready(function(){
    runProgram();
});

function runProgram(){
    hideGuessingElements();
    hideCorrect();
    getNumber();
    checkGuess();
}

function getNumber() {
    $('#go-button').click(function(){
        $.ajax({
            type: "GET",
            url: 'https://localhost:5001/api/guess',
    
            success: function(result, jqXHR){
                $("#greetings-elements").hide();
                hideLower();
                hideHigher();
                hideCorrect();
                $("#guessing-elements").show();
                numberToGuess = result.guess;
                console.log(numberToGuess);
                
            }
        })
    })
}

function hideGuessingElements(){
    $("#guessing-elements").hide();
}

function checkGuess(){
    $("#guess-button").click(function(){
        let stringGuessVal = $('#guess-value').val();
        let guessValue = parseInt(stringGuessVal, 10);
        console.log(guessValue);
        
        if(guessValue === numberToGuess){
            hideHigher();
            hideLower();
            showCorrect();
        } 
        if(guessValue > numberToGuess){
            hideLower();
            hideCorrect();
            showHigher();
        } 
        if(guessValue < numberToGuess){
            hideHigher();
            hideCorrect();
            showLower();
        }
    })
}

function showGreeting(){
    $("#greetings-elements").show();
}

function hideGuessingElements(){
    $("#guessing-elements").hide();
}

function hideHigher(){
    $("#higher-message").hide();
}

function showHigher(){
    $("#higher-message").show();
}

function hideLower(){
    $("#lower-message").hide();
}

function showLower(){
    $("#lower-message").show();
}

function hideCorrect(){
    $("#correct-message").hide();
}

function showCorrect(){
    showGreeting();
    $('#greetings').hide();
    hideGuessingElements();
    $("#correct-message").show();
    $('#guess-value').val('');
}