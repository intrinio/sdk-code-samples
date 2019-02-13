package com.intrinio.javasdkexample;

import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.MunicipalityApi;
import com.intrinio.models.ApiResponseMunicipalities;
import com.intrinio.models.MunicipalitySummary;

import java.util.List;

public class App
{
  public static void main( String[] args )
  {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    auth.setApiKey("YOUR API KEY");

    MunicipalityApi municipalityApi = new MunicipalityApi();

    String nextPage = null; // String | Gets the next page of data from a previous API call

    try {
      ApiResponseMunicipalities result = municipalityApi.getAllMunicipalities(nextPage);
      List <MunicipalitySummary> municipalities = result.getMunicipalities();

      for (MunicipalitySummary municipality : municipalities) {
        System.out.println();
        System.out.println(municipality.getGovernmentName());
        System.out.println("-------------------------------------------------");
        System.out.println("ID:              " + municipality.getId());
        System.out.println("Government type: " + municipality.getGovernmentType());
        System.out.println("Area type:       " + municipality.getAreaType());
        System.out.println("Area name:       " + municipality.getAreaName());
        System.out.println("Location:        " + municipality.getCity() + ", " + municipality.getState() + " " + municipality.getZip());
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling MunicipalityApi#getAllMunicipalities");
      e.printStackTrace();
    }
  }
}
