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
        List<CryptoStat> currencies = result.Currencies;
        Console.WriteLine(currencies.Count + " currency stats found!");
        Console.WriteLine();

        currencies.ForEach(delegate (CryptoStat crypto_currency)
        {
          Console.WriteLine("Name:             " + crypto_currency.Name);
          Console.WriteLine("Code:             " + crypto_currency.Code);
          Console.WriteLine("Symbol:           " + crypto_currency.Symbol);
          Console.WriteLine("Market cap(USD):  " + crypto_currency.MarketCapUsd);
          Console.WriteLine("Available supply: " + crypto_currency.AvailableSupply);
          Console.WriteLine("Total supply:     " + crypto_currency.TotalSupply);
          Console.WriteLine("Max supply:       " + crypto_currency.MaxSupply);
          Console.WriteLine("Last updated:     " + crypto_currency.LastUpdated);
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
