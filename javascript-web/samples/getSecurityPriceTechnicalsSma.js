var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var securityAPI = new intrinioSDK.SecurityApi();
 
var identifier = "AAPL"; // String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
 
var opts = {
  'pageSize': 25 // Number | The number of results to return
};

securityAPI.getSecurityPriceTechnicalsSma(identifier, opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(data, undefined, 2));
  var indicator = data.indicator;
  var security = data.security;
  var technicals = data.technicals;

  console.log('Technicals for ' + security.ticker);
  console.log(technicals.length + ' values for ' + indicator.name + ' returned!');
  console.log();

  technicals.forEach(function(technical){
    console.log("DateTime: " + technical.date_time);
    console.log("SMA:      " + technical.sma);
    console.log("--------------------------------------------------------------------------------");
  });
  
}, function(error) {
  console.error(error);
});
