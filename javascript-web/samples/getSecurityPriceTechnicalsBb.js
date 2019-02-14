var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var securityAPI = new intrinioSDK.SecurityApi();
 
var identifier = "AAPL"; // String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
 
var opts = { 
  'startDate': "2019-01-01", // String | Return technical indicator values on or after the date
  'endDate': "2019-01-31", // String | Return technical indicator values on or before the date
  'timezone': "America/New_York", // String | Returns technical indicators in this timezone
};

securityAPI.getSecurityPriceTechnicalsBb(identifier, opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(data, undefined, 2));
  var indicator = data.indicator;
  var security = data.security;
  var technicals = data.technicals;
  
  console.log('Technicals for ' + security.ticker);
  console.log(technicals.length + ' values for ' + indicator.name + ' returned!');
  console.log();

  technicals.forEach(function(technical){
    console.log("DateTime:    " + technical.date_time);
    console.log("Lower Band:  " + technical.lower_band);
    console.log("Middle Band: " + technical.middle_band);
    console.log("Upper Band:  " + technical.upper_band);
    console.log("--------------------------------------------------------------------------------");
  });
  
}, function(error) {
  console.error(error);
});
