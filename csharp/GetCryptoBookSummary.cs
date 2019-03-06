using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetCryptoBookSummary
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var cryptoApi = new CryptoApi();
      var levels = 50;  // int? | The number of prices/levels to return on each side. For example, the max of 50 levels will return up to 50 bid prices and 50 ask prices. (optional) 
      var pair = "btcusd";  // string | Return the order book summary for the given Crypto Currency Pair. (optional) 
      var exchange = "gemini";  // string | Return the order book summary for a Crypto Currency on the given Crypto Exchange. (optional) 
      var currency = "BTC";  // string | Return the order book summary for the given Crypto Currency. (optional) 

      try
      {
        ApiResponseCryptoBook result = cryptoApi.GetCryptoBookSummary(levels, pair, exchange, currency);
        List<CryptoBid> crypto_bids = result.Bids;
        List<CryptoAsk> crypto_asks = result.Asks;

        CryptoPairSummary crypto_pair = result.Pair;
        Console.WriteLine("Crypto Currency Pair: " + crypto_pair.Name);

        CryptoExchangeSummary crypto_exchange = result.Exchange;
        Console.WriteLine("Crypto Exchange: " + crypto_exchange.Name);

        Console.WriteLine();
        Console.WriteLine("----------------- BIDS -----------------");

        crypto_bids.ForEach(delegate (CryptoBid bid)
        {
          Console.WriteLine();
          Console.WriteLine("Price: " + bid.Price);
          Console.WriteLine("Size:  " + bid.Size);
        });

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
        Debug.Print("Exception when calling CryptoApi.GetCryptoBookSummary: " + e.Message);
      }
    }
  }
}
