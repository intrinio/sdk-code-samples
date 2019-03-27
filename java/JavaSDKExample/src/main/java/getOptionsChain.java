package com.intrinio.javasdkexample;

import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.OptionsApi;
import com.intrinio.models.*;

import java.math.BigDecimal;
import java.util.List;

public class App
{
  public static void main( String[] args )
  {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    auth.setApiKey("YOUR API KEY");
     
    OptionsApi optionsApi = new OptionsApi();
     
    String symbol = "AAPL"; // String | The option symbol, corresponding to the underlying security.
    String expiration = "2019-03-18"; // String | The expiration date of the options contract
    String type = null; // String | The option contract type.
    BigDecimal strike = null; // BigDecimal | The strike price of the option contract. This will return options contracts with strike price equal to this price.
    BigDecimal strikeGreaterThan = null; // BigDecimal | The strike price of the option contract. This will return options contracts with strike prices greater than this price.
    BigDecimal strikeLessThan = null; // BigDecimal | The strike price of the option contract. This will return options contracts with strike prices less than this price.
    String moneyness = null; // String | The moneyness of the options contracts to return. 'all' will return all options contracts. 'in_the_money' will return options contracts that are in the money (call options with strike prices below the current price, put options with strike prices above the current price). 'out_of_they_money' will return options contracts that are out of the money (call options with strike prices above the current price, put options with strike prices below the 
    // current price). 'near_the_money' will return options contracts that are $0.50 or less away from being in the money.
    BigDecimal pageSize = null; // BigDecimal | The number of results to return

    try {
      ApiResponseOptionsChain result = optionsApi.getOptionsChain(symbol, expiration, type, strike, strikeGreaterThan, strikeLessThan, moneyness, pageSize);
      List<OptionChain> chains = result.getChains();

      System.out.println(chains.size() + " option chains found for " + symbol + "!");
      System.out.println();

      for (OptionChain chain : chains) {
        Option option = chain.getOption();
        OptionPrice price = chain.getPrice();

        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("OPTION");
        System.out.println("ID:         " + option.getId());
        System.out.println("Code:       " + option.getCode());
        System.out.println("Ticker:     " + option.getTicker());
        System.out.println("Expiration: " + option.getExpiration());
        System.out.println("Strike:     " + option.getStrike());
        System.out.println("Type:       " + option.getType());

        System.out.println("PRICE");
        System.out.println("Date:                      " + price.getDate());
        System.out.println("Close:                     " + price.getClose());
        System.out.println("Close bid:                 " + price.getCloseBid());
        System.out.println("Close ask:                 " + price.getCloseAsk());
        System.out.println("Volume:                    " + price.getVolume());
        System.out.println("Volume bid:                " + price.getVolumeBid());
        System.out.println("Volume ask:                " + price.getVolumeAsk());
        System.out.println("Trades:                    " + price.getTrades());
        System.out.println("Open interest:             " + price.getOpenInterest());
        System.out.println("Open interest change:      " + price.getOpenInterestChange());
        System.out.println("Next day open interest:    " + price.getNextDayOpenInterest());
        System.out.println("Implied volatility:        " + price.getImpliedVolatility());
        System.out.println("Implied volatility change: " + price.getImpliedVolatilityChange());
        System.out.println("Delta:                     " + price.getDelta());
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling OptionsApi#getOptionsChain");
      e.printStackTrace();
    }
  }
}
