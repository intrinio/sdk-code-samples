using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetOptionsChainExample
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var optionsApi = new OptionsApi();
      string symbol = "AAPL";  // string | The option symbol, corresponding to the underlying security.
      string expiration = "2019-03-18";  // string | The expiration date of the options contract
      string type = null;  // string | The option contract type. (optional) 
      decimal? strike = null;  // decimal? | The strike price of the option contract. This will return options contracts with strike price equal to this price. (optional) 
      decimal? strikeGreaterThan = null;  // decimal? | The strike price of the option contract. This will return options contracts with strike prices greater than this price. (optional) 
      decimal? strikeLessThan = null;  // decimal? | The strike price of the option contract. This will return options contracts with strike prices less than this price. (optional) 
      string moneyness = null;  // string | The moneyness of the options contracts to return. 'all' will return all options contracts. 'in_the_money' will return options contracts that are in the money (call options with strike prices below the current price, put options with strike prices above the current price). 'out_of_they_money' will return options contracts that are out of the money (call options with strike prices above the current price, put options with strike prices 
      // below the current price). 'near_the_money' will return options contracts that are $0.50 or less away from being in the money. (optional) 
      decimal? pageSize = 100;  // decimal? | The number of results to return (optional)  (default to 100)

      try
      {
        ApiResponseOptionsChain result = optionsApi.GetOptionsChain(symbol, expiration, type, strike, strikeGreaterThan, strikeLessThan, moneyness, pageSize);
        List<OptionChain> chain = result.Chain;
        
        Console.WriteLine(chain.Count + " results found for " + symbol + "!");

        chain.ForEach(delegate (OptionChain chain_link)
        {
          Option option = chain_link.Option;
          OptionPrice price = chain_link.Price;

          Console.WriteLine();
          Console.WriteLine("-----------------------------------------------------------------------------------");
          Console.WriteLine("OPTION");
          Console.WriteLine("ID:         " + option.Id);
          Console.WriteLine("Code:       " + option.Code);
          Console.WriteLine("Ticker:     " + option.Ticker);
          Console.WriteLine("Expiration: " + option.Expiration);
          Console.WriteLine("Strike:     " + option.Strike);
          Console.WriteLine("Type:       " + option.Type);

          Console.WriteLine();
          Console.WriteLine("PRICE");
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
        Debug.Print("Exception when calling OptionsApi.GetOptionsChain: " + e.Message );
      }
    }
  }
}
