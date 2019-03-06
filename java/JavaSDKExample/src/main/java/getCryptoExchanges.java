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
    String pair = "btcusd"; // String | Returns Crypto Currencies traded on the given Crypto Exchange.

    try {
      ApiResponseCryptoExchanges result = cryptoApi.getCryptoExchanges(pair);
      List<CryptoExchange> exchanges = result.getExchanges();

      System.out.println(exchanges.size() + " exchanges found!");
      System.out.println();

      for (CryptoExchange exchange : exchanges) {
        System.out.println("Name:                 " + exchange.getName());
        System.out.println("Code:                 " + exchange.getCode());
        System.out.println("Book depth available: " + exchange.isisBookDepthAvailable());
        System.out.println("History available:    " + exchange.isisHistoryAvailable());
        System.out.println("Trades available:     " + exchange.isisTradesAvailable());

        List<String> pairs = exchange.getPairs();
        System.out.println("Pairs:");
        for (String crypto_pair : pairs) {
          System.out.println("  - " + crypto_pair);
        }

        System.out.println();
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoExchanges");
      e.printStackTrace();
    }
  }
}
