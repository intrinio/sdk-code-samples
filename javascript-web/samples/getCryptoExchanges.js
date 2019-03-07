var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var cryptoAPI = new intrinioSDK.CryptoApi();
 
var opts = { 
  'pair': "btcusd" // String | Returns Crypto Currencies traded on the given Crypto Exchange.
};
 
cryptoAPI.getCryptoExchanges(opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(data, undefined, 2));
  
  var exchanges = data.exchanges;
  
  console.log(exchanges.length + ' exchanges found!');

  console.log('------------------------------------------------------------');

  exchanges.forEach(function(exchange) {
    console.log('Name:                 ' + exchange.name);
    console.log('Code:                 ' + exchange.code);
    console.log('Book depth available: ' + exchange.book_depth_available);
    console.log('History available:    ' + exchange.history_available);
    console.log('Snapshot available:   ' + exchange.snapshot_available);
    console.log('Trades available:     ' + exchange.trades_available);

    console.log('Pairs: ');
    exchange.pairs.forEach(function(pair) {
      console.log('  - ' + pair);
    });

    console.log();
  });
}, function(error) {
  console.error(error);
});
