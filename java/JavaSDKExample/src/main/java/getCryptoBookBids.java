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

    String pair = "btcusd"; // String | Return the order book bids for the given Crypto Currency Pair.
    String exchange = "gemini"; // String | Return the order book bids for a Crypto Currency on the given Crypto Exchange.
    String currency = "BTC"; // String | Return the order book bids for the given Crypto Currency.

    try {
      ApiResponseCryptoBookBids result = cryptoApi.getCryptoBookBids(pair, exchange, currency);
      List<CryptoBid> crypto_bids = result.getBids();

      CryptoPairSummary crypto_pair = result.getPair();
      System.out.println("Crypto Currency Pair: " + crypto_pair.getName());

      CryptoExchangeSummary crypto_exchange = result.getExchange();
      System.out.println("Crypto Exchange: " + crypto_exchange.getName());

      System.out.println();
      System.out.println("----------------- BIDS -----------------");

      for (CryptoBid bid : crypto_bids) {
        System.out.println();
        System.out.println("Price: " + bid.getPrice());
        System.out.println("Size:  " + bid.getSize());
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoBookBids");
      e.printStackTrace();
    }
  }
}
