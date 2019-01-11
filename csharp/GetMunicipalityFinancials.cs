using System;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetMunicipalityFinancialsExample 
  {
    static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var municipalityApi = new MunicipalityApi();
      var identifier = "Xn7x4z";

      try
      {
        MunicipalityFinancial financials = municipalityApi.GetMunicipalityFinancials(identifier); ;
        MunicipalitySummary municipality = financials.Municipality;

        Console.WriteLine("MUNICIPALITY");
        Console.WriteLine("--------------------------------------");
        Console.WriteLine("Government name: " + municipality.GovernmentName);
        Console.WriteLine("ID:              " + municipality.Id);
        Console.WriteLine("Census ID:       " + municipality.CensusId);
        Console.WriteLine("Government type: " + municipality.GovernmentType);
        Console.WriteLine("Area type:       " + municipality.AreaType);
        Console.WriteLine("Area name:       " + municipality.AreaName);
        Console.WriteLine("Location:        " + municipality.City + ", " + municipality.State + " " + municipality.Zip);
        Console.WriteLine();
        Console.WriteLine("FINANCIALS");
        Console.WriteLine("--------------------------------------");
        Console.WriteLine("Fiscal year:         " + financials.FiscalYear);
        Console.WriteLine("Current assets:      " + financials.CurrentAssets);
        Console.WriteLine("Total assets:        " + financials.TotalAssets);
        Console.WriteLine("Current liabilities: " + financials.CurrentLiabilities);
        Console.WriteLine("Total liabilities:   " + financials.TotalLiabilities);
        Console.WriteLine("Total net position:  " + financials.TotalNetPosition);
        Console.WriteLine("Total expenses:      " + financials.TotalExpeses);
        Console.WriteLine("Total revenues:      " + financials.TotalRevenues);
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling MunicipalityApi.GetMunicipalityFinancials: " + e.Message);
      }
    }
  }
}
