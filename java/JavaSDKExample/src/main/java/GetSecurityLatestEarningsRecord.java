package com.intrinio.javasdkexample;

import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.SecurityApi;
import com.intrinio.models.EarningsRecord;
import com.intrinio.models.SecuritySummary;

public class App
{
    public static void main( String[] args )
    {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        auth.setApiKey("YOUR API KEY");

        SecurityApi securityApi = new SecurityApi();

        String identifier = "AAPL"; // String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)

        try {
            EarningsRecord result = securityApi.getSecurityLatestEarningsRecord(identifier);
            SecuritySummary security = result.getSecurity();

            System.out.println("Security Summary");
            System.out.println("-------------------------------------------------");
            System.out.println("Name:       " + security.getName());
            System.out.println("Code:       " + security.getCode());
            System.out.println("Company ID: " + security.getCompanyId());
            System.out.println("Ticker:     " + security.getTicker());
            System.out.println();
            System.out.println();
            System.out.println("Latest Earnings Record");
            System.out.println("-------------------------------------------------");
            System.out.println("Quarter:                   " + result.getQuarter());
            System.out.println("Q1 date:                   " + result.getQ1Date());
            System.out.println("Q2 date:                   " + result.getQ2Date());
            System.out.println("Q3 date:                   " + result.getQ3Date());
            System.out.println("Q4 date:                   " + result.getQ4Date());
            System.out.println("Type:                      " + result.getType());
            System.out.println("Next earnings date:        " + result.getNextEarningsDate());
            System.out.println("Next earnings quarter:     " + result.getNextEarningsQuarter());
            System.out.println("Next earnings fiscal year: " + result.getNextEarningsFiscalYear());

        } catch (ApiException e) {
            System.err.println("Exception when calling SecurityApi#getSecurityLatestEarningsRecord");
            e.printStackTrace();
        }
    }
}
