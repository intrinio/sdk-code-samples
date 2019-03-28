using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetOptionsExample
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var optionsApi = new OptionsApi();
      string symbol = "AAPL";  // string | The option symbol, corresponding to the underlying security.
      string type = "put";  // string | The option contract type. (optional) 
      decimal? strike = null;  // decimal? | The strike price of the option contract. This will return options contracts with strike price equal to this price. (optional) 
      decimal? strikeGreaterThan = null;  // decimal? | The strike price of the option contract. This will return options contracts with strike prices greater than this price. (optional) 
      decimal? strikeLessThan = null;  // decimal? | The strike price of the option contract. This will return options contracts with strike prices less than this price. (optional) 
      string expiration = null;  // string | The expiration date of the option contract. This will return options contracts with expiration dates on this date. (optional) 
      string expirationAfter = null;  // string | The expiration date of the option contract. This will return options contracts with expiration dates after this date. (optional) 
      string expirationBefore = null;  // string | The expiration date of the option contract. This will return options contracts with expiration dates before this date. (optional) 
      decimal? pageSize = null;  // decimal? | The number of results to return (optional)  (default to 100)
      string nextPage = null;  // string | Gets the next page of data from a previous API call (optional) 

      try
      {
        ApiResponseOptions result = optionsApi.GetOptions(symbol, type, strike, strikeGreaterThan, strikeLessThan, expiration, expirationAfter, expirationBefore, pageSize, nextPage);
        List<Option> options = result.Options;

        Console.WriteLine(options.Count + " options found for " + symbol + "!");

        options.ForEach(delegate (Option option)
        {
          Console.WriteLine();
          Console.WriteLine("ID:         " + option.Id);
          Console.WriteLine("Code:       " + option.Code);
          Console.WriteLine("Ticker:     " + option.Ticker);
          Console.WriteLine("Expiration: " + option.Expiration);
          Console.WriteLine("Strike:     " + option.Strike);
          Console.WriteLine("Type:       " + option.Type);
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling OptionsApi.GetOptions: " + e.Message);
      }
    }
  }
}
