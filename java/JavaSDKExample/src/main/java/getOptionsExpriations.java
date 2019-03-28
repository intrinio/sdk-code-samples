package com.intrinio.javasdkexample;

import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.OptionsApi;
import com.intrinio.models.*;

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
    String after = null; // String | Return option contract expiration dates after this date.
    String before = null; // String | Return option contract expiration dates before this date.

    try {
      ApiResponseOptionsExpirations result = optionsApi.getOptionsExpirations(symbol, after, before);
      List<String> expirations = result.getExpirations();

      System.out.println(expirations.size() + " option expirations found for " + symbol + "!");
      System.out.println();

      for (String expiration : expirations) {
        System.out.println(expiration);
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling OptionsApi#getOptionsExpirations");
      e.printStackTrace();
    }
  }
}
