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

    String pair = "EURUSD"; // String | The Forex Currency Pair code
    String timeframe = "D1"; // String | The time interval for the quotes

    String timezone = null; // String | Returns trading times in this timezone
    String startDate = "2018-01-01"; // String | Return Forex Prices on or after this date
    String startTime = null; // String | Return Forex Prices at or after this time (24-hour)
    String endDate = "2018-12-31"; // String | Return Forex Prices on or before this date
    String endTime = null; // String | Return Forex Prices at or before this time (24-hour)
    Integer pageSize = null; // Integer | The number of results to return
    String nextPage = null; // String | Gets the next page of data from a previous API call

    try {
      ApiResponseForexPrices result = forexApi.getForexPrices(pair, timeframe, timezone, startDate, startTime, endDate, endTime, pageSize, nextPage);
      List<ForexPrice> prices = result.getPrices();

      System.out.println("Listing " + prices.size() + " Forex Currency Prices");
      System.out.println();

      for (ForexPrice price : prices) {
        System.out.println("Occurred at: " + price.getOccurredAt());
        System.out.println("Open bid:    " + price.getOpenBid());
        System.out.println("High bid:    " + price.getHighBid());
        System.out.println("Low bid:     " + price.getLowBid());
        System.out.println("Close bid:   " + price.getCloseBid());
        System.out.println("Open ask:    " + price.getOpenAsk());
        System.out.println("High ask:    " + price.getHighAsk());
        System.out.println("Low ask:     " + price.getLowAsk());
        System.out.println("Close ask:   " + price.getCloseAsk());
        System.out.println("Total ticks: " + price.getTotalTicks());
        System.out.println("-----------------------------------------------------------------------");
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling ForexApi#getForexPrices");
      e.printStackTrace();
    }
  }
}
