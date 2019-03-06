using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetCryptoSnapshot
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var cryptoApi = new CryptoApi();
      var pair = "btcusd";  // string | Return the snapshot for the given Crypto Currency Pair. (optional) 
      var exchange = "gemini";  // string | Return the snapshot for a Crypto Currency on the given Crypto Exchange. (optional) 
      var currency = "BTC";  // string | Return the snapshot for the given Crypto Currency. (optional) 

      try
      {
        ApiResponseCryptoSnapshot result = cryptoApi.GetCryptoSnapshot(pair, exchange, currency);
        CryptoPairSummary crypto_pair = result.Pair;
        CryptoExchangeSummary crypto_exchange = result.Exchange;
        CryptoSnapshot snapshot = result.Snapshot;

        Console.WriteLine("Snapshot for " + crypto_pair.Name + " on " + crypto_exchange.Name + "!");
        Console.WriteLine();
        Console.WriteLine("Last updated:     " + snapshot.LastUpdated);
        Console.WriteLine("Bid:              " + snapshot.Bid);
        Console.WriteLine("Bid size:         " + snapshot.BidSize);
        Console.WriteLine("Ask:              " + snapshot.Ask);
        Console.WriteLine("Ask size:         " + snapshot.AskSize);
        Console.WriteLine("Change:           " + snapshot.Change);
        Console.WriteLine("Change percent:   " + snapshot.ChangePercent);
        Console.WriteLine("Volume:           " + snapshot.Volume);
        Console.WriteLine("Open:             " + snapshot.Open);
        Console.WriteLine("High:             " + snapshot.High);
        Console.WriteLine("Low:              " + snapshot.Low);
        Console.WriteLine("Last trade side:  " + snapshot.LastTradeSide);
        Console.WriteLine("Last trade time:  " + snapshot.LastTradeTime);
        Console.WriteLine("Last trade price: " + snapshot.LastTradePrice);
        Console.WriteLine("Last trade size:  " + snapshot.LastTradeSize);
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling CryptoApi.GetCryptoSnapshot: " + e.Message);
      }
    }
  }
}
