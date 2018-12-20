var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";

var security_api = new intrinioSDK.SecurityApi(); 

var identifier = "AAPL"; // String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
 
security_api.getSecurityLatestDividendRecord(identifier).then(function(data) {
  var security = data.security;

  console.log("Security Summary");
  console.log("-------------------------------------------------");
  console.log("Name:       " + security.name);
  console.log("Code:       " + security.code);
  console.log("Company ID: " + security.company_id);
  console.log("Ticker:     " + security.ticker);
  console.log();
  console.log();
  console.log("Latest Dividend Record");
  console.log("-------------------------------------------------");
  console.log("Announcement date: " + data.announcement_date);
  console.log("Record date:       " + data.record_date);
  console.log("Pay date:          " + data.pay_date);
  console.log("Frequency:         " + data.frequency);
  console.log("Status:            " + data.status);
  console.log("Forward yield:     " + data.forward_yield);
  console.log("Forward rate:      " + data.forward_rate);

}, function(error) {
  console.error(error);
});
