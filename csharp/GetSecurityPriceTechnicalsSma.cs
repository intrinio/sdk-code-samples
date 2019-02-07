using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetSecurityPriceTechnicalsSmaExample
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var securityApi = new SecurityApi();
      var identifier = "AAPL";  // string | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
      var period = 20;  // int? | The number of observations, per period, to calculate Simple Moving Average (optional)  (default to 20)
      String priceKey = null;  // string | The Stock Price field to use when calculating Simple Moving Average (optional)  (default to close)
      var startDate = "2018-01-01";  // string | Return technical indicator values on or after the date (optional) 
      String startTime = null;  // string | Return prices at or after this time (24-hour) (optional) 
      var endDate = "2018-12-31";  // string | Return technical indicator values on or before the date (optional) 
      String endTime = null;  // string | Return prices at or before this time (24-hour) (optional) 
      var timezone = "America/New_York";  // string | Returns technical indicators in this timezone (optional)  (default to UTC)
      var pageSize = 100;  // int? | The number of results to return (optional)  (default to 100)
      String nextPage = null;  // string | gets the next page of data from an already-executed API call (optional) 

      try
      {
        ApiResponseSecurityTechnicalsSingleValue result = securityApi.GetSecurityPriceTechnicalsSma(identifier, period, priceKey, startDate, startTime, endDate, endTime, timezone, pageSize, nextPage);
        Indicator indicator = result.Indicator;
        SecuritySummary security = result.Security;
        List<Technical> technicals = result.Technicals;

        Console.WriteLine("Technicals for " + security.Ticker);
        Console.WriteLine(technicals.Count + " values for " + indicator.Name + " returned!");
        Console.WriteLine();

        technicals.ForEach(delegate (Technical technical)
        {
          Console.WriteLine("DateTime: " + technical.DateTime);
          Console.WriteLine("SMA:      " + technical.Value);
          Console.WriteLine("---------------------------------------------------");
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling SecurityApi.GetSecurityPriceTechnicalsSma: " + e.Message);
      }
    }
  }
}
