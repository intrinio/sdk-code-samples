using System;
using System.Diagnostics;
using Intrinio.SDK.Api;
using Intrinio.SDK.Client;
using Intrinio.SDK.Model;

namespace Example
{
    public class GetAllMunicipalityByIdExample
    {
        static void Main()
        {
            Configuration.Default.AddApiKey("api_key", "YOUR_API_KEY");

            var municipalityApi = new MunicipalityApi();
            var identifier = "geV70X";

            try
            {
                Municipality municipality = municipalityApi.GetMunicipalityById(identifier);

                Console.WriteLine(municipality.GovernmentName);
                Console.WriteLine("--------------------------------------");
                Console.WriteLine("ID:                    " + municipality.Id);
                Console.WriteLine("Census ID:             " + municipality.CensusId);
                Console.WriteLine("Government type:       " + municipality.GovernmentType);
                Console.WriteLine("Area type:             " + municipality.AreaType);
                Console.WriteLine("Area name:             " + municipality.AreaName);
                Console.WriteLine("Web site:              " + municipality.WebSite);
                Console.WriteLine("Population:            " + municipality.Population);
                Console.WriteLine("Population as of year: " + municipality.PopulationAsOfYear);
                Console.WriteLine("Enrollment:            " + municipality.Enrollment);
                Console.WriteLine("Enrollment as of year: " + municipality.EnrollmentAsOfYear);
                Console.WriteLine("Latitude:              " + municipality.Latitude);
                Console.WriteLine("Longitude:             " + municipality.Longitude);
                Console.WriteLine("Location:              " + municipality.Address1);
                Console.WriteLine("                       " + municipality.Address2);
                Console.WriteLine("                       " + municipality.City + ", " + municipality.State + " " + municipality.Zip);

            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling MunicipalityApi.GetMunicipalityById: " + e.Message);
            }
        }
    }
}
