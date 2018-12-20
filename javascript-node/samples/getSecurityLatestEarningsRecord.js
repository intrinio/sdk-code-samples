var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";

var security_api = new intrinioSDK.SecurityApi(); 

var identifier = "AAPL"; // String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
 
security_api.getSecurityLatestEarningsRecord(identifier).then(function(data) {
  var security = data.security;

  console.log("Security Summary");
  console.log("-------------------------------------------------");
  console.log("Name:       " + security.name);
  console.log("Code:       " + security.code);
  console.log("Company ID: " + security.company_id);
  console.log("Ticker:     " + security.ticker);
  console.log();
  console.log();
  console.log("Latest Earnings Record");
  console.log("-------------------------------------------------");
  console.log("Quarter:                   " + data.quarter);
  console.log("Q1 date:                   " + data.q1_date);
  console.log("Q2 date:                   " + data.q2_date);
  console.log("Q3 date:                   " + data.q3_date);
  console.log("Q4 date:                   " + data.q4_date);
  console.log("Type:                      " + data.type);
  console.log("Next earnings date:        " + data.next_earnings_date);
  console.log("Next earnings quarter:     " + data.next_earnings_quarter);
  console.log("Next earnings fiscal year: " + data.next_earnings_fiscal_year);

}, function(error) {
  console.error(error);
});
