package com.intrinio.javasdkexample;

import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.SecurityApi;
import com.intrinio.models.*;

import java.util.List;

public class App
{
  public static void main( String[] args )
  {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    auth.setApiKey("YOUR API KEY");

    SecurityApi securityApi = new SecurityApi();

    String identifier = "AAPL"; // String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
    Integer period = null; // Integer | The number of observations, per period, to calculate Relative Strength Index
    String priceKey = null; // String | The Stock Price field to use when calculating Relative Strength Index
    String startDate = null; // String | Return technical indicator values on or after the date
    String startTime = null; // String | Return prices at or after this time (24-hour)
    String endDate = null; // String | Return technical indicator values on or before the date
    String endTime = null; // String | Return prices at or before this time (24-hour)
    String timezone = null; // String | Returns technical indicators in this timezone
    Integer pageSize = null; // Integer | The number of results to return
    String nextPage = null; // String | gets the next page of data from an already-executed API call

    try {
      ApiResponseSecurityTechnicalsSingleValue result = securityApi.getSecurityPriceTechnicalsRsi(identifier, period, priceKey, startDate, startTime, endDate, endTime, timezone, pageSize, nextPage);
      SecuritySummary security = result.getSecurity();
      Indicator indicator = result.getIndicator();
      List<Technical> technicals = result.getTechnicals();

      System.out.println("Technicals for " + security.getTicker());
      System.out.println(technicals.size() + " values for " + indicator.getName() + " returned!");
      System.out.println();

      for (Technical technical : technicals) {
        System.out.println("DateTime: " + technical.getDateTime());
        System.out.println("RSI:      " + technical.getValue());
        System.out.println("-----------------------------------------------------------------------");
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling SecurityApi#getSecurityPriceTechnicalsRsi");
      e.printStackTrace();
    }
  }
}
