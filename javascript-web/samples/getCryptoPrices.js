var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var cryptoAPI = new intrinioSDK.CryptoApi();
 
var timeframe = "h1"; // String | The time interval for the prices.
 
var opts = { 
  'pair': "btcusd", // String | Return prices for the given Crypto Currency Pair.
  'exchange': "gemini", // String | Return prices for a Crypto Currency on the given Crypto Exchange.
  'currency': "BTC", // String | Return prices for the given Crypto Currency.
  'timezone': "UTC", // String | Return price date/times in this timezone, also interpret start/end date/time parameters in this timezone.
  'startDate': "2018-01-01", // String | Return Crypto Prices on or after this date.
  'startTime': "14:20:00", // String | Return Crypto Prices at or after this time (24-hour).
  'endDate': "2019-01-01", // String | Return Crypto Prices on or before this date.
  'endTime': "21:01:21", // String | Return Crypto Prices at or before this time (24-hour).
  'pageSize': 100 // Number | An integer greater than or equal to 1 for specifying the number of results on each page.
};
 
cryptoAPI.getCryptoPrices(timeframe, opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(data, undefined, 2));
  
  var prices = data.prices;
  var pair_name = data.pair.name;
  var exchange_name = data.exchange.name;

  console.log(prices.length + ' prices found for ' + pair_name + ' on ' + exchange_name +'!');
  console.log('------------------------------------------------------');

  prices.forEach(function(price) {
    console.log('Time:   ' + price.time);
    console.log('Open:   ' + price.open);
    console.log('High:   ' + price.high);
    console.log('Low:    ' + price.low);
    console.log('Close:  ' + price.close);
    console.log('Volume: ' + price.volume);
    console.log();
  });
}, function(error) {
  console.error(error);
});
