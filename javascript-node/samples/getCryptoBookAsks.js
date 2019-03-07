var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var cryptoAPI = new intrinioSDK.CryptoApi();
 
var opts = { 
  'pair': "btcusd", // String | Return the order book asks for the given Crypto Currency Pair.
  'exchange': "gemini", // String | Return the order book asks for a Crypto Currency on the given Crypto Exchange.
  'currency': "BTC" // String | Return the order book asks for the given Crypto Currency.
};
 
cryptoAPI.getCryptoBookAsks(opts).then(function(data) {
  var asks = data.asks;
  var pair_name = data.pair.name;
  var exchange_name = data.exchange.name;

  console.log('Crypto Currency Pair: ' + pair_name);
  console.log('Crypto Exchange:      ' + exchange_name);
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
