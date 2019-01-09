package com.intrinio.javasdkexample;

import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.MunicipalityApi;
import com.intrinio.models.MunicipalityFinancial;
import com.intrinio.models.MunicipalitySummary;

public class App
{
  public static void main( String[] args )
  {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    auth.setApiKey("YOUR API KEY");

    MunicipalityApi municipalityApi = new MunicipalityApi();

    String identifier = "Xn7x4z"; // String | An Intrinio ID of a Municipality

    try {
      MunicipalityFinancial financials = municipalityApi.getMunicipalityFinancials(identifier);
      MunicipalitySummary municipality = financials.getMunicipality();

      System.out.println("MUNICIPALITY");
      System.out.println("-------------------------------------------------");
      System.out.println("Government name: " + municipality.getId());
      System.out.println("ID:              " + municipality.getId());
      System.out.println("Government type: " + municipality.getGovernmentType());
      System.out.println("Area type:       " + municipality.getAreaType());
      System.out.println("Area name:       " + municipality.getAreaName());
      System.out.println("Location:        " + municipality.getCity() + ", " + municipality.getState() + " " + municipality.getZip());
      System.out.println();
      System.out.println("FINANCIALS");
      System.out.println("-------------------------------------------------");
      System.out.println("Fiscal year:         " + financials.getFiscalYear());
      System.out.println("Current assets:      " + financials.getCurrentAssets());
      System.out.println("Total assets:        " + financials.getTotalAssets());
      System.out.println("Current liabilities: " + financials.getCurrentLiabilities());
      System.out.println("Total liabilities:   " + financials.getTotalLiabilities());
      System.out.println("Total net position:  " + financials.getTotalNetPosition());
      System.out.println("Total expenditures:  " + financials.getTotalExpenditures());
      System.out.println("Total revenues:      " + financials.getTotalRevenues());
    } catch (ApiException e) {
      System.err.println("Exception when calling MunicipalityApi#getMunicipalityFinancials");
      e.printStackTrace();
    }
  }
}
