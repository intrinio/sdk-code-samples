using System;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
    public class GetSecurityStockPricesExample
    {
        public static void Main()
        {
            Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

            var securityApi = new SecurityApi();
            var identifier = "AAPL";  // string | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
            var startDate = "2019-01-01";  // DateTime? | Return prices on or after the date (optional) 
            var endDate = "2019-02-01";  // DateTime? | Return prices on or before the date (optional) 
            var frequency = "daily";  // string | Return stock prices in the given frequency (optional)  (default to daily)
            var pageSize = 100;  // decimal? | The number of results to return (optional)  (default to 100)
            var nextPage = "";  // string | Gets the next page of data from a previous API call (optional) 

            try
            {
                ApiResponseSecurityStockPrices result = securityApi.GetSecurityStockPrices(identifier, DateTime.Parse(startDate), DateTime.Parse(endDate), frequency, pageSize, nextPage);

                result.StockPrices.ForEach((StockPriceSummary stockPriceSummary) => Console.WriteLine(stockPriceSummary));
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SecurityApi.GetSecurityStockPrices: " + e.Message);
            }
        }
    }
}
