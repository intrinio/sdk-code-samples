using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetCryptoStats
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var cryptoApi = new CryptoApi();
      var exchange = "gemini";  // string | Returns stats for Crypto Currencies that trade on the specified Crypto Exchange. (optional) 
      var currency = "BTC";  // string | Returns stats for the specified Crypto Currency. (optional) 

      try
      {
        ApiResponseCryptoStats result = cryptoApi.GetCryptoStats(exchange, currency);
        List<CryptoStat> stats = result.Stats;
        Console.WriteLine(stats.Count + " stats found!");
        Console.WriteLine();

        stats.ForEach(delegate (CryptoStat stat)
        {
          Console.WriteLine("Name:             " + stat.Name);
          Console.WriteLine("Code:             " + stat.Code);
          Console.WriteLine("Symbol:           " + stat.Symbol);
          Console.WriteLine("Market cap(USD):  " + stat.MarketCapUsd);
          Console.WriteLine("Available supply: " + stat.AvailableSupply);
          Console.WriteLine("Total supply:     " + stat.TotalSupply);
          Console.WriteLine("Max supply:       " + stat.MaxSupply);
          Console.WriteLine("Last updated:     " + stat.LastUpdated);
          Console.WriteLine();
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling CryptoApi.GetCryptoStats: " + e.Message);
      }
    }
  }
}
