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
    Integer period = 20; // Integer | The number of observations, per period, to calculate Bollinger Bands
    Float standardDeviations = 2.0F; // Float | The number of standard deviations to calculate the upper and lower bands of the Bollinger Bands
    String priceKey = "close"; // String | The Stock Price field to use when calculating Bollinger Bands
    String startDate = "2019-01-01"; // String | Return technical indicator values on or after the date
    String startTime = null; // String | Return prices at or after this time (24-hour)
    String endDate = "2019-01-31"; // String | Return technical indicator values on or before the date
    String endTime = null; // String | Return prices at or before this time (24-hour)
    String timezone = "America/New_York"; // String | Returns technical indicators in this timezone
    Integer pageSize = 100; // Integer | The number of results to return
    String nextPage = null; // String | gets the next page of data from an already-executed API call

    try {
      ApiResponseSecurityTechnicalsBb result = securityApi.getSecurityPriceTechnicalsBb(identifier, period, standardDeviations, priceKey, startDate, startTime, endDate, endTime, timezone, pageSize, nextPage);
      SecuritySummary security = result.getSecurity();
      Indicator indicator = result.getIndicator();
      List<BbTechnicals> technicals = result.getTechnicals();

      System.out.println("Technicals for " + security.getTicker());
      System.out.println(technicals.size() + " values for " + indicator.getName() + " returned!");
      System.out.println();

      for (BbTechnicals technical : technicals) {
        System.out.println("DateTime:    " + technical.getDateTime());

        BbTechnicalsValue value = technical.getValue();
        System.out.println("Lower Band:  " + value.getLowerBand());
        System.out.println("Middle Band: " + value.getMiddleBand());
        System.out.println("Upper Band:  " + value.getUpperBand());
        System.out.println("-----------------------------------------------------------------------");
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling SecurityApi#getSecurityPriceTechnicalsBb");
      e.printStackTrace();
    }
  }
}
