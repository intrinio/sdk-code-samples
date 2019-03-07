var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var cryptoAPI = new intrinioSDK.CryptoApi();
 
var opts = { 
  'exchange': "gemini", // String | Return pairs traded on the given Crypto Exchange.
  'currency': "BTC" // String | Return pairs with one side being the given Crypto Currency.
};
 
cryptoAPI.getCryptoPairs(opts).then(function(data) {
  var pairs = data.currency_pairs;
  
  console.log(pairs.length + ' pairs found!');

  console.log('------------------------------------------------------------');

  pairs.forEach(function(pair) {
    console.log('Name:                 ' + pair.name);
    console.log('Code:                 ' + pair.code);
    console.log('First price date:     ' + pair.first_price_date);
    console.log('Last price date:      ' + pair.last_price_date);
    console.log('Book depth available: ' + pair.book_depth_available);
    console.log('History available:    ' + pair.history_available);
    console.log('Snapshot available:   ' + pair.snapshot_available);
    console.log('Trades available:     ' + pair.trades_available);

    console.log('Currencies: ');
    pair.currencies.forEach(function(currency) {
      console.log('  - ' + currency);
    });

    console.log('Exchanges: ');
    pair.exchanges.forEach(function(exchange) {
      console.log('  - ' + exchange);
    });

    console.log();
  });
}, function(error) {
  console.error(error);
});
