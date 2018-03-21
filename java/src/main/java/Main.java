import com.intrinio.api.CompanyApi;
import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.ApiKeyAuth;
import com.intrinio.models.CompanySummary;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("HttpHeaderApiKey");
        auth.setApiKey("YOUR_API_KEY");

        CompanyApi companyApi = new CompanyApi();

        try {
            List<CompanySummary> result = companyApi.getAllCompanies(null);
            for (CompanySummary company : result) {
                System.out.println(company.getName());
            }
        } catch (ApiException e) {
            System.err.println("Exception when calling CompanyApi#filterCompanies");
            e.printStackTrace();
        }
    }
}