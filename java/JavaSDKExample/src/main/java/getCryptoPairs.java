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

    try {
      ApiResponseCryptoPairs result = cryptoApi.getCryptoPairs(exchange, currency);
      List<CryptoPair> pairs = result.getCurrencyPairs();

      System.out.println(pairs.size() + " pairs found!");
      System.out.println();

      System.out.println("----------------------------------------------------");
      for (CryptoPair pair : pairs) {
        System.out.println("Name:                 " + pair.getName());
        System.out.println("Code:                 " + pair.getCode());
        System.out.println("First price date:     " + pair.getFirstPriceDate());
        System.out.println("Last price date:      " + pair.getLastPriceDate());
        System.out.println("Book depth available: " + pair.isisBookDepthAvailable());
        System.out.println("History available:    " + pair.isisHistoryAvailable());
        System.out.println("Snapshot available:   " + pair.isisSnapshotAvailable());
        System.out.println("Trades available:     " + pair.isisTradesAvailable());

        List<String> currencies = pair.getCurrencies();
        System.out.println("Currencies:");
        for (String crypto_currency : currencies) {
          System.out.println("  - " + crypto_currency);
        }

        List<String> exchanges = pair.getExchanges();
        System.out.println("Exchanges:");
        for (String crypto_exchange : exchanges) {
          System.out.println("  - " + crypto_exchange);
        }

        System.out.println();
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoPairs");
      e.printStackTrace();
    }
  }
}
