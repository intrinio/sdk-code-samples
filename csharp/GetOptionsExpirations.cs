using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetOptionsExpirationsExample
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var optionsApi = new OptionsApi();
      string symbol = "AAPL";  // string | The option symbol, corresponding to the underlying security.
      string after = null;  // string | Return option contract expiration dates after this date. (optional) 
      string before = null;  // string | Return option contract expiration dates before this date. (optional) 

      try
      {
        ApiResponseOptionsExpirations result = optionsApi.GetOptionsExpirations(symbol, after, before);
        List<string> expirations = result.Expirations;

        Console.WriteLine(expirations.Count + " option expirations found for " + symbol + "!");
        Console.WriteLine();

        expirations.ForEach(delegate (string expiration)
        {
          Console.WriteLine(expiration);
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling OptionsApi.GetOptionsExpirations: " + e.Message );
      }
    }
  }
}
