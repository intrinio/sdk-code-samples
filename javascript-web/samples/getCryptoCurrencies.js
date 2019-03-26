var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var cryptoAPI = new intrinioSDK.CryptoApi();
 
var opts = { 
  'exchange': "gemini" // String | Returns Crypto Currencies traded on the given Crypto Exchange.
};
 
cryptoAPI.getCryptoCurrencies(opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(data, undefined, 2));
  
  var currencies = data.currencies;
  
  console.log(currencies.length + ' currencies found!');

  console.log('------------------------------------------------------------');

  currencies.forEach(function(currency) {
    console.log('Name:             ' + currency.name);
    console.log('Code:             ' + currency.code);
    console.log('Symbol:           ' + currency.symbol);
    console.log('First price date: ' + currency.first_price_date);
    console.log('Last price date:  ' + currency.last_price_date);
    console.log();
  });
}, function(error) {
  console.error(error);
});
