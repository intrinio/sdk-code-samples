var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var cryptoAPI = new intrinioSDK.CryptoApi();
var opts = { 
  'levels': 50, // Number | The number of prices/levels to return on each side. For example, the max of 50 levels will return up to 50 bid prices and 50 ask prices.
  'pair': "btcusd", // String | Return the order book summary for the given Crypto Currency Pair.
  'exchange': "gemini", // String | Return the order book summary for a Crypto Currency on the given Crypto Exchange.
  'currency': "BTC" // String | Return the order book summary for the given Crypto Currency.
};
 
cryptoAPI.getCryptoBookSummary(opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(data, undefined, 2));
  
  var bids = data.bids;
  var asks = data.asks;
  var pair_name = data.pair.name;
  var exchange_name = data.exchange.name;

  console.log('Crypto Currency Pair: ' + pair_name);
  console.log('Crypto Exchange:      ' + exchange_name);

  console.log();
  console.log('---------------------------- BIDS ----------------------------');

  bids.forEach(function(bid) {
    console.log();
    console.log('Price: ' + bid.price);
    console.log('Size:  ' + bid.size);
  });

  console.log();
  console.log('---------------------------- ASKS ----------------------------');

  asks.forEach(function(ask) {
    console.log();
    console.log('Price: ' + ask.price);
    console.log('Size:  ' + ask.size);
  });
}, function(error) {
  console.error(error);
});
