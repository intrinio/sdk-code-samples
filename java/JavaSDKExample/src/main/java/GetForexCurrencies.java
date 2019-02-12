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
      ApiResponseForexCurrencies result = forexApi.getForexCurrencies();
      List<ForexCurrency> currencies = result.getCurrencies();

      System.out.println("Listing " + currencies.size() + " Forex Currencies");
      System.out.println();

      for (ForexCurrency currency : currencies) {
        System.out.println("Code:    " + currency.getCode());
        System.out.println("Name:    " + currency.getName());
        System.out.println("Country: " + currency.getCountry());
        System.out.println("-----------------------------------------------------------------------");
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling ForexApi#getForexCurrencies");
      e.printStackTrace();
    }
  }
}
