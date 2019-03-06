using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetCryptoBookAsks
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var cryptoApi = new CryptoApi();
      var pair = "btcusd";  // string | Return the order book asks for the given Crypto Currency Pair. (optional) 
      var exchange = "gemini";  // string | Return the order book asks for a Crypto Currency on the given Crypto Exchange. (optional) 
      var currency = "BTC";  // string | Return the order book asks for the given Crypto Currency. (optional) 

      try
      {
        ApiResponseCryptoBookAsks result = cryptoApi.GetCryptoBookAsks(pair, exchange, currency);
        List<CryptoAsk> crypto_asks = result.Asks;

        CryptoPairSummary crypto_pair = result.Pair;
        Console.WriteLine("Crypto Currency Pair: " + crypto_pair.Name);

        CryptoExchangeSummary crypto_exchange = result.Exchange;
        Console.WriteLine("Crypto Exchange: " + crypto_exchange.Name);

        Console.WriteLine();
        Console.WriteLine("----------------- ASKS -----------------");

        crypto_asks.ForEach(delegate (CryptoAsk ask)
        {
          Console.WriteLine();
          Console.WriteLine("Price: " + ask.Price);
          Console.WriteLine("Size:  " + ask.Size);
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling CryptoApi.GetCryptoBookAsks: " + e.Message);
      }
    }
  }
}
