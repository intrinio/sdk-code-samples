using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetSecurityPriceTechnicalsBbExample
  {
    public static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var securityApi = new SecurityApi();
      var identifier = "AAPL";  // string | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
      var period = 20;  // int? | The number of observations, per period, to calculate Bollinger Bands (optional)  (default to 20)
      float standardDeviations = 2.0f;  // float? | The number of standard deviations to calculate the upper and lower bands of the Bollinger Bands (optional)  (default to 2.0)
      String priceKey = "close";  // string | The Stock Price field to use when calculating Bollinger Bands (optional)  (default to close)
      String startDate = "2019-01-01";  // string | Return technical indicator values on or after the date (optional) 
      String startTime = null;  // string | Return prices at or after this time (24-hour) (optional) 
      String endDate = "2019-01-31";  // string | Return technical indicator values on or before the date (optional) 
      String endTime = null;  // string | Return prices at or before this time (24-hour) (optional) 
      String timezone = "America/New_York";  // string | Returns technical indicators in this timezone (optional)  (default to UTC)
      var pageSize = 100;  // int? | The number of results to return (optional)  (default to 100)
      String nextPage = null;  // string | gets the next page of data from an already-executed API call (optional) 

      try
      {
        ApiResponseSecurityTechnicalsBb result = securityApi.GetSecurityPriceTechnicalsBb(identifier, period, standardDeviations, priceKey, startDate, startTime, endDate, endTime, timezone, pageSize, nextPage);
        Indicator indicator = result.Indicator;
        SecuritySummary security = result.Security;
        List<BbTechnicals> technicals = result.Technicals;

        Console.WriteLine("Technicals for " + security.Ticker);
        Console.WriteLine(technicals.Count + " values for " + indicator.Name + " returned!");
        Console.WriteLine();

        technicals.ForEach(delegate (BbTechnicals technical)
        {
          Console.WriteLine("DateTime:    " + technical.DateTime);

          BbTechnicalsValue value = technical.Value;
          Console.WriteLine("Lower Band:  " + value.LowerBand);
          Console.WriteLine("Middle Band: " + value.MiddleBand);
          Console.WriteLine("Upper Band:  " + value.UpperBand);
          Console.WriteLine("---------------------------------------------------");
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling SecurityApi.GetSecurityPriceTechnicalsBb: " + e.Message);
      }
    }
  }
}
