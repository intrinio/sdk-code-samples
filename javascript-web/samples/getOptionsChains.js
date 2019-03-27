var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var optionsAPI = new intrinioSDK.OptionsApi();
 
var symbol = "AAPL"; // String | The option symbol, corresponding to the underlying security.
 
var expiration = "2019-03-18"; // String | The expiration date of the options contract
 
var opts = {};
 
optionsAPI.getOptionsChain(symbol, expiration, opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(financials, undefined, 2));
  
  var chains = data.chains;
  
  console.log(chains.length + ' option chains found for ' + symbol + '!');
  
  chains.forEach(function(chain) {
    var option = chain.option;
    var price = chain.price;

    console.log("");
    console.log("--------------------------------------------------------------------------");
    console.log("OPTION");
    console.log("ID:         " + option.id);
    console.log("Code:       " + option.code);
    console.log("Ticker:     " + option.ticker);
    console.log("Expiration: " + option.expiration);
    console.log("Strike:     " + option.strike);
    console.log("Type:       " + option.type);
    
    console.log("");
    console.log("PRICE");
    console.log("Date:                      " + price.date);
    console.log("Close:                     " + price.close);
    console.log("Close bid:                 " + price.close_bid);
    console.log("Close ask:                 " + price.close_ask);
    console.log("Volume:                    " + price.volume);
    console.log("Volume bid:                " + price.volume_bid);
    console.log("Volume ask:                " + price.volume_ask);
    console.log("Trades:                    " + price.trades);
    console.log("Open interest:             " + price.open_interest);
    console.log("Open interest change:      " + price.open_interest_change);
    console.log("Next day open interest:    " + price.next_day_open_interest);
    console.log("Implied volatility:        " + price.implied_volatility);
    console.log("Implied volatility change: " + price.implied_volatility_change);
    console.log("Delta:                     " + price.delta);
  });
}, function(error) {
  console.error(error);
});
