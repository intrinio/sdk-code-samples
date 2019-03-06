using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetCryptoPairs
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var cryptoApi = new CryptoApi();
      var exchange = "gemini";  // string | Return pairs traded on the given Crypto Exchange. (optional) 
      var currency = "BTC";  // string | Return pairs with one side being the given Crypto Currency. (optional) 

      try
      {
        ApiResponseCryptoPairs result = cryptoApi.GetCryptoPairs(exchange, currency);
        List<CryptoPair> pairs = result.CurrencyPairs;

        Console.WriteLine(pairs.Count + " pairs found!");
        Console.WriteLine();

        Console.WriteLine("----------------------------------------------------");
        pairs.ForEach(delegate (CryptoPair pair)
        {
          Console.WriteLine("Name:                 " + pair.Name);
          Console.WriteLine("Code:                 " + pair.Code);
          Console.WriteLine("First price date:     " + pair.FirstPriceDate);
          Console.WriteLine("Last price date:      " + pair.LastPriceDate);
          Console.WriteLine("Book depth available: " + pair.BookDepthAvailable);
          Console.WriteLine("History available:    " + pair.HistoryAvailable);
          Console.WriteLine("Snapshot available:   " + pair.SnapshotAvailable);
          Console.WriteLine("Trades available:     " + pair.TradesAvailable);

          List<String> currencies = pair.Currencies;
          Console.WriteLine("Currencies:");
          currencies.ForEach(delegate (String crypto_currency)
          {
            Console.WriteLine("  - " + crypto_currency);
          });

          List<String> exchanges = pair.Exchanges;
          Console.WriteLine("Exchanges:");
          exchanges.ForEach(delegate (String crypto_exchange)
          {
            Console.WriteLine("  - " + crypto_exchange);
          });

          Console.WriteLine();
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling CryptoApi.GetCryptoPairs: " + e.Message);
      }
    }
  }
}
