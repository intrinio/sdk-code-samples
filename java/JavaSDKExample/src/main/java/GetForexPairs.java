package com.intrinio.javasdkexample;

import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.ForexApi;
import com.intrinio.models.*;

import java.util.List;

public class App
{
  public static void main( String[] args )
  {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    auth.setApiKey("YOUR API KEY");

    ForexApi forexApi = new ForexApi();

    try {
      ApiResponseForexPairs result = forexApi.getForexPairs();
      List<ForexPair> pairs = result.getPairs();

      System.out.println("Listing " + pairs.size() + " Forex Currency Pairs");
      System.out.println();

      for (ForexPair pair : pairs) {
        System.out.println("Code:           " + pair.getCode());
        System.out.println("Base currency:  " + pair.getBaseCurrency());
        System.out.println("Quote currency: " + pair.getQuoteCurrency());
        System.out.println("-----------------------------------------------------------------------");
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling ForexApi#getForexPairs");
      e.printStackTrace();
    }
  }
}
