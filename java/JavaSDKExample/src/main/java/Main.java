import com.intrinio.api.CompanyApi;
import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.ApiKeyAuth;
import com.intrinio.api.SecurityApi;
import com.intrinio.models.ApiResponseSecurityStockPrices;
import org.threeten.bp.LocalDate;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        auth.setApiKey("YOUR_API_KEY");

        SecurityApi securityApi = new SecurityApi();

        String identifier = "AAPL"; // String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
        LocalDate startDate = null; // LocalDate | Return prices on or after the date
        LocalDate endDate = null; // LocalDate | Return prices on or before the date
        String frequency = "daily"; // String | Return stock prices in the given frequency
        String nextPage = null; // String | Gets the next page of data from a previous API call

        try {
            ApiResponseSecurityStockPrices result = securityApi.getSecurityStockPrices(identifier, startDate, endDate, frequency, nextPage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SecurityApi#getSecurityStockPrices");
            e.printStackTrace();
        }
    }
}
