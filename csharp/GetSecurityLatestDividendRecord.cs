using System;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
    public class GetSecurityLatestDividendRecordExample
    {
        static void Main()
        {
            Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

            var securityApi = new SecurityApi();
            var identifier = "AAPL";  // string | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)

            try
            {
                DividendRecord result = securityApi.GetSecurityLatestDividendRecord(identifier);
                SecuritySummary security = result.Security;

                Console.WriteLine("Security Summary");
                Console.WriteLine("-------------------------------------------------");
                Console.WriteLine("Name:       " + security.Name);
                Console.WriteLine("Code:       " + security.Code);
                Console.WriteLine("Company ID: " + security.CompanyId);
                Console.WriteLine("Ticker:     " + security.Ticker);
                Console.WriteLine();
                Console.WriteLine();
                Console.WriteLine("Latest Dividend Record");
                Console.WriteLine("-------------------------------------------------");
                Console.WriteLine("Announcement date: " + result.AnnouncementDate);
                Console.WriteLine("Record date:       " + result.RecordDate);
                Console.WriteLine("Pay date:          " + result.PayDate);
                Console.WriteLine("Frequency:         " + result.Frequency);
                Console.WriteLine("Status:            " + result.Status);
                Console.WriteLine("Forward yield:     " + result.ForwardYield);
                Console.WriteLine("Forward rate:      " + result.ForwardRate);

            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SecurityApi.GetSecurityLatestDividendRecord: " + e.Message);
            }
        }
    }
}
