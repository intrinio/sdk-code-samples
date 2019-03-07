var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var cryptoAPI = new intrinioSDK.CryptoApi();
 
var opts = { 
  'exchange': "gemini", // String | Returns stats for Crypto Currencies that trade on the specified Crypto Exchange.
  'currency': "BTC" // String | Returns stats for the specified Crypto Currency.
};
 
cryptoAPI.getCryptoStats(opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(data, undefined, 2));
  
  var currencies = data.currencies;

  console.log(currencies.length + ' currency stats found!');

  currencies.forEach(function(currency) {
    console.log('Name:             ' + currency.name);
    console.log('Code:             ' + currency.code);
    console.log('Symbol:           ' + currency.symbol);
    console.log('Market cap(USD):  ' + currency.market_cap_usd);
    console.log('Available supply: ' + currency.available_supply);
    console.log('Total supply:     ' + currency.total_supply);
    console.log('Max supply:       ' + currency.max_supply);
    console.log('Last updated:     ' + currency.last_updated);
    console.log();
  });
}, function(error) {
  console.error(error);
});
