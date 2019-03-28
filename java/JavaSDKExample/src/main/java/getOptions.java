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
    String type = "put"; // String | The option contract type.
    BigDecimal strike = null; // BigDecimal | The strike price of the option contract. This will return options contracts with strike price equal to this price.
    BigDecimal strikeGreaterThan = null; // BigDecimal | The strike price of the option contract. This will return options contracts with strike prices greater than this price.
    BigDecimal strikeLessThan = null; // BigDecimal | The strike price of the option contract. This will return options contracts with strike prices less than this price.
    String expiration = null; // String | The expiration date of the option contract. This will return options contracts with expiration dates on this date.
    String expirationAfter = null; // String | The expiration date of the option contract. This will return options contracts with expiration dates after this date.
    String expirationBefore = null; // String | The expiration date of the option contract. This will return options contracts with expiration dates before this date.
    BigDecimal pageSize = null; // BigDecimal | The number of results to return
    String nextPage = null; // String | Gets the next page of data from a previous API call

    try {
      ApiResponseOptions result = optionsApi.getOptions(symbol, type, strike, strikeGreaterThan, strikeLessThan, expiration, expirationAfter, expirationBefore, pageSize, nextPage);
      List<Option> options = result.getOptions();

      System.out.println(options.size() + " options found for " + symbol + "!");
      System.out.println();

      for (Option option: options) {
        System.out.println();
        System.out.println("ID:         " + option.getId());
        System.out.println("Code:       " + option.getCode());
        System.out.println("Ticker:     " + option.getTicker());
        System.out.println("Expiration: " + option.getExpiration());
        System.out.println("Strike:     " + option.getStrike());
        System.out.println("Type:       " + option.getType());
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling OptionsApi#getOptions");
      e.printStackTrace();
    }
  }
}
