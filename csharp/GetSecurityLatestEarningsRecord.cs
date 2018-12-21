using System;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
    public class GetSecurityLatestEarningsRecordExample
    {
        static void Main()
        {
            Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

            var securityApi = new SecurityApi();
            var identifier = "AAPL";  // string | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)

            try
            {
                EarningsRecord result = securityApi.GetSecurityLatestEarningsRecord(identifier);
                SecuritySummary security = result.Security;

                Console.WriteLine("Security Summary");
                Console.WriteLine("-------------------------------------------------");
                Console.WriteLine("Name:       " + security.Name);
                Console.WriteLine("Code:       " + security.Code);
                Console.WriteLine("Company ID: " + security.CompanyId);
                Console.WriteLine("Ticker:     " + security.Ticker);
                Console.WriteLine();
                Console.WriteLine();
                Console.WriteLine("Latest Earnings Record");
                Console.WriteLine("-------------------------------------------------");
                Console.WriteLine("Quarter:                   " + result.Quarter);
                Console.WriteLine("Q1 date:                   " + result.Q1Date);
                Console.WriteLine("Q2 date:                   " + result.Q2Date);
                Console.WriteLine("Q3 date:                   " + result.Q3Date);
                Console.WriteLine("Q4 date:                   " + result.Q4Date);
                Console.WriteLine("Type:                      " + result.Type);
                Console.WriteLine("Next earnings date:        " + result.NextEarningsDate);
                Console.WriteLine("Next earnings quarter:     " + result.NextEarningsQuarter);
                Console.WriteLine("Next earnings fiscal year: " + result.NextEarningsFiscalYear);

            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SecurityApi.GetSecurityLatestEarningsRecord: " + e.Message);
            }
        }
    }
}
