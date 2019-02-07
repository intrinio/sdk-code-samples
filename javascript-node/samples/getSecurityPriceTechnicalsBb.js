var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var securityAPI = new intrinioSDK.SecurityApi();
 
var identifier = "AAPL"; // String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
 
var opts = { 
  'startDate': "2018-01-01", // String | Return technical indicator values on or after the date
  'endDate': "2018-12-31", // String | Return technical indicator values on or before the date
  'timezone': "America/New_York", // String | Returns technical indicators in this timezone
};

securityAPI.getSecurityPriceTechnicalsMacd(identifier, opts).then(function(data) {
  var indicator = data.indicator;
  var security = data.security;
  var technicals = data.technicals;
  
  console.log('Technicals for ' + security.ticker);
  console.log(technicals.length + ' values for ' + indicator.name + ' returned!');
  console.log();

  technicals.forEach(function(technical){
    console.log("DateTime:       " + technical.date_time);
    console.log("MACD Histogram: " + technical.value.macd_histogram);
    console.log("MACD Line:      " + technical.value.macd_line);
    console.log("Signal Line:    " + technical.value.signal_line);
    console.log("--------------------------------------------------------------------------------");
  });
  
}, function(error) {
  console.error(error);
});
