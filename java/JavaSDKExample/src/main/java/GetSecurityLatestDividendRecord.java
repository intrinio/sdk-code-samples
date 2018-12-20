package com.intrinio.javasdkexample;

import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.SecurityApi;
import com.intrinio.models.DividendRecord;
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
            DividendRecord result = securityApi.getSecurityLatestDividendRecord(identifier);
            SecuritySummary security = result.getSecurity();

            System.out.println("Security Summary");
            System.out.println("-------------------------------------------------");
            System.out.println("Name:       " + security.getName());
            System.out.println("Code:       " + security.getCode());
            System.out.println("Company ID: " + security.getCompanyId());
            System.out.println("Ticker:     " + security.getTicker());
            System.out.println();
            System.out.println();
            System.out.println("Latest Dividend Record");
            System.out.println("-------------------------------------------------");
            System.out.println("Announcement date: " + result.getAnnouncementDate());
            System.out.println("Record date:       " + result.getRecordDate());
            System.out.println("Pay date:          " + result.getPayDate());
            System.out.println("Frequency:         " + result.getFrequency());
            System.out.println("Status:            " + result.getStatus());
            System.out.println("Forward yield:     " + result.getForwardYield());
            System.out.println("Forward rate:      " + result.getForwardRate());

        } catch (ApiException e) {
            System.err.println("Exception when calling SecurityApi#getSecurityLatestDividendRecord");
            e.printStackTrace();
        }
    }
}
