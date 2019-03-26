import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.CryptoApi;
import com.intrinio.models.*;

import java.util.List;

public class App
{
  public static void main( String[] args )
  {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    auth.setApiKey("YOUR API KEY");

    CryptoApi cryptoApi = new CryptoApi();
    String exchange = "gemini"; // String | Return pairs traded on the given Crypto Exchange.
    String currency = "BTC"; // String | Return pairs with one side being the given Crypto Currency.
    Integer pageSize = 100; // Integer | An integer greater than or equal to 1 for specifying the number of results on each page.
    String nextPage = null; // String | Gets the next page of data from a previous API call
 
    try {
      ApiResponseCryptoPairs result = cryptoApi.getCryptoPairs(exchange, currency, pageSize, nextPage);
      List<CryptoPair> pairs = result.getPairs();

      System.out.println(pairs.size() + " pairs found!");
      System.out.println();

      System.out.println("----------------------------------------------------");
      for (CryptoPair pair : pairs) {
        System.out.println();
        System.out.println("Name:                 " + pair.getName());
        System.out.println("Code:                 " + pair.getCode());
        System.out.println("First price date:     " + pair.getFirstPriceDate());
        System.out.println("Last price date:      " + pair.getLastPriceDate());
        System.out.println("Book depth available: " + pair.isisBookDepthAvailable());
        System.out.println("History available:    " + pair.isisHistoryAvailable());
        System.out.println("Snapshot available:   " + pair.isisSnapshotAvailable());
        System.out.println("Trades available:     " + pair.isisTradesAvailable());
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoPairs");
      e.printStackTrace();
    }
  }
}
