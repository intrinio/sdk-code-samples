var intrinio = require('intrinio-sdk');
const util = require('util')

intrinio.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR_API_KEY";

var security_api = new intrinio.SecurityApi();

var identifier = "AAPL"; // String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)

var opts = { 
  'startDate': new Date("2018-01-01"), // Date | Return prices on or after the date
  'endDate': new Date("2019-01-01"), // Date | Return prices on or before the date
  'frequency': "daily", // String | Return stock prices in the given frequency
  'nextPage': null // String | Gets the next page of data from a previous API call
};

security_api.getSecurityStockPrices(identifier, opts).then(function(data) {
  console.log(util.inspect(data, false, null, true));
}, function(error) {
  console.error(error);
});
