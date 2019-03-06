using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetCryptoBookBids
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var cryptoApi = new CryptoApi();
      var pair = "btcusd";  // string | Return the order book bids for the given Crypto Currency Pair. (optional) 
      var exchange = "gemini";  // string | Return the order book bids for a Crypto Currency on the given Crypto Exchange. (optional) 
      var currency = "BTC";  // string | Return the order book bids for the given Crypto Currency. (optional) 

      try
      {
        ApiResponseCryptoBookBids result = cryptoApi.GetCryptoBookBids(pair, exchange, currency);
        List<CryptoBid> crypto_bids = result.Bids;

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
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling CryptoApi.GetCryptoBookBids: " + e.Message);
      }
    }
  }
}
