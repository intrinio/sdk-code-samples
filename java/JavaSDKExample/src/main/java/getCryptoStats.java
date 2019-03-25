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
    String exchange = "gemini"; // String | Returns stats for Crypto Currencies that trade on the specified Crypto Exchange.
    String currency = "BTC"; // String | Returns stats for the specified Crypto Currency.

    try {
      ApiResponseCryptoStats result = cryptoApi.getCryptoStats(exchange, currency);
      List<CryptoStat> stats = result.getStats();
      System.out.println(stats.size() + " stats found!");
      System.out.println();

      for(CryptoStat stat : stats) {
        System.out.println("Name:             " + stat.getName());
        System.out.println("Code:             " + stat.getCode());
        System.out.println("Symbol:           " + stat.getSymbol());
        System.out.println("Market cap(USD):  " + stat.getMarketCapUsd());
        System.out.println("Available supply: " + stat.getAvailableSupply());
        System.out.println("Total supply:     " + stat.getTotalSupply());
        System.out.println("Max supply:       " + stat.getMaxSupply());
        System.out.println("Last updated:     " + stat.getLastUpdated());
        System.out.println();
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoStats");
      e.printStackTrace();
    }
  }
}
