using System;
using System.Diagnostics;
using Intrinio.Api;
using Intrinio.Client;
using Intrinio.Model;

namespace Example
{
    public class GetSecurityHistoricalDataExample
    {
        public static void Main()
        {
            Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

            var securityApi = new SecurityApi();
            var identifier = "AAPL"; // string | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
            var tag = "adj_close_price";  // string | An Intrinio data tag ID or code-name
            var startDate = DateTime.Now.AddDays(-90);  // DateTime? | Get historical data on or after this date (optional) 
            var endDate = DateTime.Now;  //DateTime? |Get historical date on or before this date (optional) 
            var type = ""; // string | Filter by type, when applicable (optional)
            var sortOrder = ""; // string | Sort by date `asc` or `desc` (optional)  (default to desc)
            var nextPage = ""; // string | Gets the next page of data from a previous API call (optional) 

            try
            {
                ApiResponseSecurityHistoricalData result = securityApi.GetSecurityHistoricalData(identifier, tag, type, startDate, endDate, sortOrder, nextPage);

                foreach(HistoricalData data in result.HistoricalData) 
                {
                    Console.WriteLine(data.ToString());
                }
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SecurityApi.GetSecurityHistoricalData: " + e.Message );
            }
        }
    }
}
