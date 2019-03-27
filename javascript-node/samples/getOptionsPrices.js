var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var optionsAPI = new intrinioSDK.OptionsApi();
 
var identifier = "AAPL190318C00300510"; // String | The Intrinio ID or code of the options contract to request prices for.
 
var opts = {};
 
optionsAPI.getOptionsPrices(identifier, opts).then(function(data) {
  var option = data.option;
  var prices = data.prices;
  
  console.log("*** OPTION ***");
  console.log("ID:         " + option.id);
  console.log("Code:       " + option.code);
  console.log("Ticker:     " + option.ticker);
  console.log("Expiration: " + option.expiration);
  console.log("Strike:     " + option.strike);
  console.log("Type:       " + option.type);
  
  console.log("");
  console.log(prices.length + ' options prices found for ' + identifier + '!');
  console.log("------------------------------------------------------------");
  
  prices.forEach(function(price) {
    console.log("");
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
