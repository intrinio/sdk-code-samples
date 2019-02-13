package com.intrinio.javasdkexample;

import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.MunicipalityApi;
import com.intrinio.models.Municipality;

public class App
{
  public static void main( String[] args )
  {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    auth.setApiKey("YOUR API KEY");

    MunicipalityApi municipalityApi = new MunicipalityApi();

    String identifier = "geV70X"; // String | An Intrinio ID of a Municipality

    try {
      Municipality municipality = municipalityApi.getMunicipalityById(identifier);

      System.out.println(municipality.getGovernmentName());
      System.out.println("-------------------------------------------------");
      System.out.println("ID:                    " + municipality.getId());
      System.out.println("Government type:       " + municipality.getGovernmentType());
      System.out.println("Area type:             " + municipality.getAreaType());
      System.out.println("Area name:             " + municipality.getAreaName());
      System.out.println("Web site:              " + municipality.getWebSite());
      System.out.println("Population:            " + municipality.getPopulation());
      System.out.println("Population as of year: " + municipality.getPopulationAsOfYear());
      System.out.println("Enrollment:            " + municipality.getEnrollment());
      System.out.println("Enrollment as of year: " + municipality.getEnrollmentAsOfYear());
      System.out.println("Latitude:              " + municipality.getLatitude());
      System.out.println("Longitude:             " + municipality.getLongitude());
      System.out.println("Location:              " + municipality.getAddress1());
      System.out.println("                       " + municipality.getAddress2());
      System.out.println("                       " + municipality.getCity() + ", " + municipality.getState() + " " + municipality.getZip());
    } catch (ApiException e) {
      System.err.println("Exception when calling MunicipalityApi#getMunicipalityById");
      e.printStackTrace();
    }
  }
}
