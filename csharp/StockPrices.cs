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
            var startDate = DateTime.Now.AddDays(-90);  // DateTime? | Return prices on or after the date (optional) 
            var endDate = DateTime.Now;  // DateTime? | Return prices on or before the date (optional) 
            var frequency = "daily";  // string | Return stock prices in the given frequency (optional)  (default to daily)
            var nextPage = "";  // string | Gets the next page of data from a previous API call (optional) 

            try
            {
                ApiResponseSecurityStockPrices results = securityApi.GetSecurityStockPrices(identifier, startDate, endDate, frequency, nextPage);
                Debug.WriteLine(results.Security);

                foreach(StockPriceSummary stockPriceSummary in results.StockPrices)
                {
                    Debug.WriteLine(stockPriceSummary);
                }
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SecurityApi.GetSecurityStockPrices: " + e.Message);
            }
        }
    }
}
