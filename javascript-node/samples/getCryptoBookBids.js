var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var cryptoAPI = new intrinioSDK.CryptoApi();
 
var opts = { 
  'pair': "btcusd", // String | Return the order book bids for the given Crypto Currency Pair.
  'exchange': "gemini", // String | Return the order book bids for a Crypto Currency on the given Crypto Exchange.
  'currency': "BTC" // String | Return the order book bids for the given Crypto Currency.
};
 
cryptoAPI.getCryptoBookBids(opts).then(function(data) {
  var bids = data.bids;
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
}, function(error) {
  console.error(error);
});
