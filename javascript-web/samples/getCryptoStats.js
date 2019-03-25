var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var cryptoAPI = new intrinioSDK.CryptoApi();
 
var opts = { 
  'exchange': "gemini", // String | Returns stats for Crypto Currencies that trade on the specified Crypto Exchange.
  'currency': "BTC" // String | Returns stats for the specified Crypto Currency.
};
 
cryptoAPI.getCryptoStats(opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(data, undefined, 2));

  var stats = data.stats;

  console.log(stats.length + ' stats found!');

  stats.forEach(function(stat) {
    console.log('Name:             ' + stat.name);
    console.log('Code:             ' + stat.code);
    console.log('Symbol:           ' + stat.symbol);
    console.log('Market cap(USD):  ' + stat.market_cap_usd);
    console.log('Available supply: ' + stat.available_supply);
    console.log('Total supply:     ' + stat.total_supply);
    console.log('Max supply:       ' + stat.max_supply);
    console.log('Last updated:     ' + stat.last_updated);
    console.log();
  });
}, function(error) {
  console.error(error);
});
