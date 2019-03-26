using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetCryptoPrices
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var cryptoApi = new CryptoApi();
      var timeframe = "h1";  // string | The time interval for the prices.
      var pair = "btcusd";  // string | Return prices for the given Crypto Currency Pair. (optional) 
      var exchange = "gemini";  // string | Return prices for a Crypto Currency on the given Crypto Exchange. (optional) 
      var currency = "BTC";  // string | Return prices for the given Crypto Currency. (optional) 
      var timezone = "UTC";  // string | Return price date/times in this timezone, also interpret start/end date/time parameters in this timezone. (optional)  (default to UTC)
      var startDate = "2018-01-01";  // string | Return Crypto Prices on or after this date. (optional) 
      var startTime = "14:20:00";  // string | Return Crypto Prices at or after this time (24-hour). (optional) 
      var endDate = "2019-01-01";  // string | Return Crypto Prices on or before this date. (optional) 
      var endTime = "21:01:21";  // string | Return Crypto Prices at or before this time (24-hour). (optional) 
      var pageSize = 100;  // int? | An integer greater than or equal to 1 for specifying the number of results on each page. (optional)  (default to 100)

      try
      {
        ApiResponseCryptoPrices result = cryptoApi.GetCryptoPrices(timeframe, pair, exchange, currency, timezone, startDate, startTime, endDate, endTime, pageSize);
        List<CryptoPrice> prices = result.Prices;
        CryptoPairSummary crypto_pair = result.Pair;
        CryptoExchangeSummary crypto_exchange = result.Exchange;

        Console.WriteLine(prices.Count + " prices found for " + crypto_pair.Name + " on " + crypto_exchange.Name + "!");
        Console.WriteLine();

        prices.ForEach(delegate (CryptoPrice price)
        {
          Console.WriteLine("Time:   " + price.Time);
          Console.WriteLine("Open:   " + price.Open);
          Console.WriteLine("High:   " + price.High);
          Console.WriteLine("Low:    " + price.Low);
          Console.WriteLine("Close:  " + price.Close);
          Console.WriteLine("Volume: " + price.Volume);
          Console.WriteLine();
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling CryptoApi.GetCryptoPrices: " + e.Message);
      }
    }
  }
}
