import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.SecurityApi;
import com.intrinio.models.DividendRecord;

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
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SecurityApi#getSecurityLatestDividendRecord");
            e.printStackTrace();
        }
    }
}
