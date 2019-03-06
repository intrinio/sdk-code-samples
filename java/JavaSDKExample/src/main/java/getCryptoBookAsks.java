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

    String pair = "btcusd"; // String | Return the order book asks for the given Crypto Currency Pair.
    String exchange = "gemini"; // String | Return the order book asks for a Crypto Currency on the given Crypto Exchange.
    String currency = "BTC"; // String | Return the order book asks for the given Crypto Currency.

    try {
      ApiResponseCryptoBookAsks result = cryptoApi.getCryptoBookAsks(pair, exchange, currency);
      List<CryptoAsk> crypto_asks = result.getAsks();

      CryptoPairSummary crypto_pair = result.getPair();
      System.out.println("Crypto Currency Pair: " + crypto_pair.getName());

      CryptoExchangeSummary crypto_exchange = result.getExchange();
      System.out.println("Crypto Exchange: " + crypto_exchange.getName());

      System.out.println();
      System.out.println("----------------- ASKS -----------------");

      for (CryptoAsk ask : crypto_asks) {
        System.out.println();
        System.out.println("Price: " + ask.getPrice());
        System.out.println("Size:  " + ask.getSize());
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoBookAsks";
      e.printStackTrace();
    }
  }
}
