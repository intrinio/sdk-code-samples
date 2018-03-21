using System;
using System.Collections.Generic;
using System.Diagnostics;
using Intrinio.Api;
using Intrinio.Client;
using Intrinio.Model;

namespace IntrinioSample
{
    class Program
    {
        static void Main(string[] args)
        {
            Configuration.Default.ApiKey.Add("api-key", "YOUR_API_KEY");

            var companyApi = new CompanyApi();

            try
            {
                List<CompanySummary> result = companyApi.GetAllCompanies(null);
                foreach (CompanySummary company in result)
                {
                    Console.WriteLine(company.Name);
                }
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling CompanyApi.FilterCompanies: " + e.Message);
            }
            Console.ReadLine();
        }
    }
}
