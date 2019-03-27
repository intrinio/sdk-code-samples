using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetOptionsPricesExample
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var optionsApi = new OptionsApi();
      string identifier = "AAPL190318C00300510";  // string | The Intrinio ID or code of the options contract to request prices for.
      string startDate = null;  // string | Return option contract prices on or after this date. (optional) 
      string endDate = null;  // string | Return option contract prices on or before this date. (optional) 
      decimal? pageSize = 100;  // decimal? | The number of results to return (optional)  (default to 100)
      string nextPage = null;  // string | Gets the next page of data from a previous API call (optional) 

      try
      {
        ApiResponseOptionPrices result = optionsApi.GetOptionsPrices(identifier, startDate, endDate, pageSize, nextPage);

        List<OptionPrice> prices = result.Prices;
        Option option = result.Option;

        Console.WriteLine("*** OPTION ***");
        Console.WriteLine("ID:         " + option.Id);
        Console.WriteLine("Code:       " + option.Code);
        Console.WriteLine("Ticker:     " + option.Ticker);
        Console.WriteLine("Expiration: " + option.Expiration);
        Console.WriteLine("Strike:     " + option.Strike);
        Console.WriteLine("Type:       " + option.Type);

        Console.WriteLine();
        Console.WriteLine(prices.Count + " options prices for " + identifier + "!");
        Console.WriteLine("-----------------------------------------------------------------------------------------------------");
        Console.WriteLine();

        prices.ForEach(delegate (OptionPrice price)
        {
          Console.WriteLine();
          Console.WriteLine("Date:                      " + price.Date);
          Console.WriteLine("Close:                     " + price.Close);
          Console.WriteLine("Close bid:                 " + price.CloseBid);
          Console.WriteLine("Close ask:                 " + price.CloseAsk);
          Console.WriteLine("Volume:                    " + price.Volume);
          Console.WriteLine("Volume bid:                " + price.VolumeBid);
          Console.WriteLine("Volume ask:                " + price.VolumeAsk);
          Console.WriteLine("Trades:                    " + price.Trades);
          Console.WriteLine("Open interest:             " + price.OpenInterest);
          Console.WriteLine("Open interest change:      " + price.OpenInterestChange);
          Console.WriteLine("Next day open interest:    " + price.NextDayOpenInterest);
          Console.WriteLine("Implied volatility:        " + price.ImpliedVolatility);
          Console.WriteLine("Implied volatility change: " + price.ImpliedVolatilityChange);
          Console.WriteLine("Delta:                     " + price.Delta);
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling OptionsApi.GetOptionsPrices: " + e.Message );
      }
    }
  }
}
