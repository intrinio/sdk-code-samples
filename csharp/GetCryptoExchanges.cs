using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetCryptoExchanges
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var cryptoApi = new CryptoApi();
      var pair = "btcusd";  // string | Returns Crypto Currencies traded on the given Crypto Exchange. (optional) 

      try
      {
        ApiResponseCryptoExchanges result = cryptoApi.GetCryptoExchanges(pair);
        List<CryptoExchange> exchanges = result.Exchanges;

        Console.WriteLine(exchanges.Count + " exchanges found!");
        Console.WriteLine();

        exchanges.ForEach(delegate (CryptoExchange exchange)
        {
          Console.WriteLine("Name:                 " + exchange.Name);
          Console.WriteLine("Code:                 " + exchange.Code);
          Console.WriteLine("Book depth available: " + exchange.BookDepthAvailable);
          Console.WriteLine("History available:    " + exchange.HistoryAvailable);
          Console.WriteLine("Trades available:     " + exchange.TradesAvailable);

          List<String> pairs = exchange.Pairs;
          Console.WriteLine("Pairs:");
          pairs.ForEach(delegate (String crypto_pair)
          {
            Console.WriteLine("  - " + crypto_pair);
          });

          Console.WriteLine();
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling CryptoApi.GetCryptoExchanges: " + e.Message);
      }
    }
  }
}
