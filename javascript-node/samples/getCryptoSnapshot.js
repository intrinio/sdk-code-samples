var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var cryptoAPI = new intrinioSDK.CryptoApi();
 
var opts = { 
  'pair': "btcusd", // String | Return the snapshot for the given Crypto Currency Pair.
  'exchange': "gemini", // String | Return the snapshot for a Crypto Currency on the given Crypto Exchange.
  'currency': "BTC" // String | Return the snapshot for the given Crypto Currency.
};
 
cryptoAPI.getCryptoSnapshot(opts).then(function(data) {
  var snapshot = data.snapshot;
  var pair_name = data.pair.name;
  var exchange_name = data.exchange.name;

  console.log('Snapshot for ' + pair_name + ' on ' + exchange_name + '!');
  console.log('------------------------------------------------------');

  console.log('Last updated:     ' + snapshot.last_updated);
  console.log('Bid:              ' + snapshot.bid);
  console.log('Bid size:         ' + snapshot.bid_size);
  console.log('Ask:              ' + snapshot.ask);
  console.log('Ask size:         ' + snapshot.ask_size);
  console.log('Change:           ' + snapshot.change);
  console.log('Change percent:   ' + snapshot.change_percent);
  console.log('Volume:           ' + snapshot.volume);
  console.log('Open:             ' + snapshot.open);
  console.log('High:             ' + snapshot.high);
  console.log('Low:              ' + snapshot.low);
  console.log('Last trade side:  ' + snapshot.last_trade_side);
  console.log('Last trade time:  ' + snapshot.last_trade_time);
  console.log('Last trade price: ' + snapshot.last_trade_price);
  console.log('Last trade size:  ' + snapshot.last_trade_size);
}, function(error) {
  console.error(error);
});
