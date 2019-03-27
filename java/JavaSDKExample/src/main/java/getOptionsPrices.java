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

    String identifier = "AAPL190318C00300510"; // String | The Intrinio ID or code of the options contract to request prices for.
    String startDate = null; // String | Return option contract prices on or after this date.
    String endDate = null; // String | Return option contract prices on or before this date.
    BigDecimal pageSize = null; // BigDecimal | The number of results to return
    String nextPage = null; // String | Gets the next page of data from a previous API call

    try {
      ApiResponseOptionPrices result = optionsApi.getOptionsPrices(identifier, startDate, endDate, pageSize, nextPage);

      List<OptionPrice> prices = result.getPrices();
      Option option = result.getOption();

      System.out.println("*** OPTION ***");
      System.out.println("ID:         " + option.getId());
      System.out.println("Code:       " + option.getCode());
      System.out.println("Ticker:     " + option.getTicker());
      System.out.println("Expiration: " + option.getExpiration());
      System.out.println("Strike:     " + option.getStrike());
      System.out.println("Type:       " + option.getType());

      System.out.println();
      System.out.println(prices.size() + " option prices found for " + identifier + "!");
      System.out.println("------------------------------------------------------------------------------------------------");
      System.out.println();

      for (OptionPrice price : prices) {
        System.out.println();
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
      System.err.println("Exception when calling OptionsApi#getOptionsPrices");
      e.printStackTrace();
    }
  }
}
