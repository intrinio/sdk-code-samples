var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var optionsAPI = new intrinioSDK.OptionsApi();
 
var symbol = "AAPL"; // String | The option symbol, corresponding to the underlying security.
 
var opts = { 
  'type': "put", // String | The option contract type.
};
 
optionsAPI.getOptions(symbol, opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(financials, undefined, 2));

  var options = data.options;
  
  console.log(options.length + ' options found for ' + symbol + '!');
  
  options.forEach(function(option) {
    console.log("");
    console.log("ID:         " + option.id);
    console.log("Code:       " + option.code);
    console.log("Ticker:     " + option.ticker);
    console.log("Expiration: " + option.expiration);
    console.log("Strike:     " + option.strike);
    console.log("Type:       " + option.type);
  });
}, function(error) {
  console.error(error);
});
