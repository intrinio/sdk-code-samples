using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetCryptoCurrencies
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var cryptoApi = new CryptoApi();
      var exchange = "gemini";  // string | Returns Crypto Currencies traded on the given Crypto Exchange. (optional) 

      try
      {
        ApiResponseCryptoCurrencies result = cryptoApi.GetCryptoCurrencies(exchange);
        List<CryptoCurrency> currencies = result.Currencies;

        Console.WriteLine(currencies.Count + " currencies found!");
        Console.WriteLine();

        currencies.ForEach(delegate (CryptoCurrency currency)
        {
          Console.WriteLine("Name:             " + currency.Name);
          Console.WriteLine("Code:             " + currency.Code);
          Console.WriteLine("Symbol:           " + currency.Symbol);
          Console.WriteLine("First price date: " + currency.FirstPriceDate);
          Console.WriteLine("Last price date:  " + currency.LastPriceDate);
          Console.WriteLine();
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling CryptoApi.GetCryptoCurrencies: " + e.Message);
      }
    }
  }
}
