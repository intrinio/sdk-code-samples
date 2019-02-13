using System;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
  public class GetAllMunicipalitiesExample
  {
    static void Main()
    {
      Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

      var municipalityApi = new MunicipalityApi();
      var nextPage = "";  // string | Gets the next page of data from a previous API call (optional) 

      try
      {
        ApiResponseMunicipalities result = municipalityApi.GetAllMunicipalities(nextPage);
        result.Municipalities.ForEach(delegate (MunicipalitySummary municipality)
        {
          Console.WriteLine();
          Console.WriteLine(municipality.GovernmentName);
          Console.WriteLine("--------------------------------------");
          Console.WriteLine("ID:              " + municipality.Id);
          Console.WriteLine("Census ID:       " + municipality.CensusId);
          Console.WriteLine("Government type: " + municipality.GovernmentType);
          Console.WriteLine("Area type:       " + municipality.AreaType);
          Console.WriteLine("Area name:       " + municipality.AreaName);
          Console.WriteLine("Location:        " + municipality.City + ", " + municipality.State + " " + municipality.Zip);
        });
      }
      catch (Exception e)
      {
        Debug.Print("Exception when calling MunicipalityApi.GetAllMunicipalities: " + e.Message);
      }
    }
  }
}
