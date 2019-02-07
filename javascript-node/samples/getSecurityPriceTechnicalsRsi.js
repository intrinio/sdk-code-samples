var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var securityAPI = new intrinioSDK.SecurityApi();
 
var identifier = "AAPL"; // String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
 
var opts = {};

securityAPI.getSecurityPriceTechnicalsRsi(identifier, opts).then(function(data) {
  var indicator = data.indicator;
  var security = data.security;
  var technicals = data.technicals;

  console.log('Technicals for ' + security.ticker);
  console.log(technicals.length + ' values for ' + indicator.name + ' returned!');
  console.log();

  technicals.forEach(function(technical){
    console.log("DateTime: " + technical.date_time);
    console.log("RSI:      " + technical.value);
    console.log("--------------------------------------------------------------------------------");
  });
  
}, function(error) {
  console.error(error);
});
