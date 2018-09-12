var productRows = $('#productRows');
var moneyInput = 0;
var purchaseHasBeenMade = false;

$(document).ready(function(){
    runProgram();
});

function runProgram() {
    populateItems();
    moneyInMachine();
    purchase();
    giveChange();
}

function populateItems(){

    var haveValidationErrors = checkAndDisplayValidationErrors($('#add-form').find('input'));
    if(haveValidationErrors){
        return false;
    }

    productRows.empty();


    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/items',
        

        // textStatus and jqXHR are good for troubleshooting
        // you want a status of 200 for textStatus aka processed successfully
        success: function(items, textStatus, jqXHR) {

            // current item in the array
            // Creating a jQuert object and for each it will iterate over
            // the array. Inside of th function, we get the index and the individual
            // item of that array, and will loop until it has gone through the entire
            // array
            $(items).each(function(index, item){
                var id = item.id;
                var name = item.name;
                var price = item.price;
                var quantity = item.quantity;

                // Creating the buttons. Going to loop through and put 1 button every 4 columns. 
                var row = '<div class="col-sm-6 col-md-4">';
                row += '<button type="button" class="btn btn-default product-btn" id="item' + id + '">';
                row += '<p class="item-id" align="left">' + item.id + '</p>';
                row += '<p class="item-name">' + item.name + '</p>';
                row += '<p class="item-price">$' + item.price + '</p>';
                row += '<p class="item-quantity"><span>Quantity Left: </span><span id="item-' 
                + item.id + '-quantity">' + quantity + '</span></p>';
                row += '</button>';
                productRows.append(row);

                // Puts the item number chosen when the mouse clicks into the item-output box
                $('#item' + id).click(function(){
                    clearMyMessages();
                    clearMyItems();
                    $('#item-output').val(item.id);
                    $('#message-output').val('You have selected Item ' + item.id);
                })
            });
            

        },
        //Error message from code-along
        error: function() {
            $('#errorMessages')
                   .append($('<li>')
                   .attr({class: 'list-group-item list-group-item-danger'})
                   .text('Error calling web service.  Please try again later.'));
        }
        
    })
}

function moneyInMachine() {
    //+= assignment operater (moneyInput = moneyInput + $)
    $('#dollar-button').click(function(){
        moneyInput += 1.00;
        updateMoney();
    });

    $('#quarter-button').click(function(){
        moneyInput += .25;
        updateMoney();
    });

    $('#dime-button').click(function(){
        moneyInput += .10;
        updateMoney();
    });

    $('#nickel-button').click(function(){
        moneyInput += .05;
        updateMoney();
    });
}

function purchase() {

    $('#purchase-button').click(function(){
        var itemValue = $('#item-output').val();

        if (itemValue != '') {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/money/' + moneyInput + '/item/' + itemValue,

                success: function(items, textStatus){
                    // No Inventory error
                    if(textStatus == 422) {
                        updateMessage(items.message);
                    } else {
                        // pulling info from the JSON object properties. 
                        updateMessage('Thank you for your purchase!')
                        var coins = '';
                        coins += 'Quarters ' + items.quarters + ' | ';
                        coins += 'Dimes ' + items.dimes + ' | ';
                        coins += 'Nickels ' + items.nickels + ' | ';
                        coins += 'Pennies ' + items.pennies + ' | ';
                        updateChange(coins);
                    }
                    populateItems();
                    //allows change to display
                    purchaseHasBeenMade = true;
                },
                error: function(jqXHR) {
                    // Throws error message if there is an error
                    //JSON string message
                    updateMessage(JSON.parse(jqXHR.responseText).message)
                }
            });
        }
    });
}

function giveChange() {
    $('#change-button').click(function(){
        //Setting up the change button.
        //purchaseHasBeenMade send error message
        if(purchaseHasBeenMade == false){
            $('#message-output').val('Please vend an item to get change!');
        } else {
        clearMyMessages();
        populateItems();
        clearMyMoney();
        clearMyItems();
        clearMyChange();
        }
    });
}

function clearMyMessages() {
    $('#message-output').val('');
}

function clearMyItems() {
    $('#item-output').val('');
}

function clearMyMoney() {
    $('#input-money').val('');
    moneyInput = 0;
}

function clearMyChange(coins) {
    $('#change-return').val('');
}

function updateMessage(message) {
    $('#message-output').val(message);
}

function updateChange(message) {
    $('#change-return').val(message);
}

function updateMoney() {
    $('#input-money').val('CR $' + Math.round(moneyInput * 100) / 100);
}

function checkAndDisplayValidationErrors(input) {
    // clear displayed error message if there are any
    $('#errorMessages').empty();
    // check for HTML5 validation errors and process/display appropriately
    // a place to hold error messages
    var errorMessages = [];

    // loop through each input and check for validation errors
    input.each(function() {
        // Use the HTML5 validation API to find the validation errors
        if(!this.validity.valid)
        {
            var errorField = $('label[for='+this.id+']').text();
            errorMessages.push(errorField + ' ' + this.validationMessage);
        }
    });

    // put any error messages in the errorMessages div
    if (errorMessages.length > 0){
        $.each(errorMessages,function(index,message){
            $('#errorMessages').append($('<li>').attr({class: 'list-group-item list-group-item-danger'}).text(message));
        });
        // return true, indicating that there were errors
        return true;
    } else {
        // return false, indicating that there were no errors
        return false;
    }
}