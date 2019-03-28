var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var optionsAPI = new intrinioSDK.OptionsApi();
 
var symbol = "AAPL"; // String | The option symbol, corresponding to the underlying security.
 
var opts = {};
 
optionsAPI.getOptionsExpirations(symbol, opts).then(function(data) {
  var expirations = data.expirations;

  console.log(expirations.length + ' options expirations found for ' + symbol + '!');
  console.log("");
  
  expirations.forEach(function(expiration) {
    console.log(expiration);
  });
}, function(error) {
  console.error(error);
});
