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
    Integer levels = 50; // Integer | The number of prices/levels to return on each side. For example, the max of 50 levels will return up to 50 bid prices and 50 ask prices.
    String pair = "btcusd"; // String | Return the order book summary for the given Crypto Currency Pair.
    String exchange = "gemini"; // String | Return the order book summary for a Crypto Currency on the given Crypto Exchange.
    String currency = "BTC"; // String | Return the order book summary for the given Crypto Currency.

    try {
      ApiResponseCryptoBook result = cryptoApi.getCryptoBookSummary(levels, pair, exchange, currency);
      List<CryptoBid> bids = result.getBids();
      List<CryptoAsk> asks = result.getAsks();

      CryptoPairSummary crypto_pair = result.getPair();
      System.out.println("Crypto Currency Pair: " + crypto_pair.getName());

      CryptoExchangeSummary crypto_exchange = result.getExchange();
      System.out.println("Crypto Exchange: " + crypto_exchange.getName());

      System.out.println();
      System.out.println("----------------- ASKS -----------------");

      for (CryptoAsk ask : asks) {
        System.out.println();
        System.out.println("Price: " + ask.getPrice());
        System.out.println("Size:  " + ask.getSize());
      }

      System.out.println();
      System.out.println("----------------- BIDS -----------------");

      for (CryptoBid bid : bids) {
        System.out.println();
        System.out.println("Price: " + bid.getPrice());
        System.out.println("Size:  " + bid.getSize());
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoBookSummary");
      e.printStackTrace();
    }
  }
}
