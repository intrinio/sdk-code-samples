import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.*;
import com.intrinio.api.CryptoApi;
import com.intrinio.models.*;

public class App
{
  public static void main( String[] args )
  {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    auth.setApiKey("YOUR API KEY");

    CryptoApi cryptoApi = new CryptoApi();
    String pair = "btcusd"; // String | Return the snapshot for the given Crypto Currency Pair.
    String exchange = "gemini"; // String | Return the snapshot for a Crypto Currency on the given Crypto Exchange.
    String currency = "BTC"; // String | Return the snapshot for the given Crypto Currency.

    try {
      ApiResponseCryptoSnapshot result = cryptoApi.getCryptoSnapshot(pair, exchange, currency);
      CryptoPairSummary crypto_pair = result.getPair();
      CryptoExchangeSummary crypto_exchange = result.getExchange();
      CryptoSnapshot snapshot = result.getSnapshot();

      System.out.println("Snapshot for " + crypto_pair.getName() + " on " + crypto_exchange.getName() + "!");
      System.out.println();
      System.out.println("Last updated:     " + snapshot.getLastUpdated());
      System.out.println("Bid:              " + snapshot.getBid());
      System.out.println("Bid size:         " + snapshot.getBidSize());
      System.out.println("Ask:              " + snapshot.getAsk());
      System.out.println("Ask size:         " + snapshot.getAskSize());
      System.out.println("Change:           " + snapshot.getChange());
      System.out.println("Change percent:   " + snapshot.getChangePercent());
      System.out.println("Volume:           " + snapshot.getVolume());
      System.out.println("Open:             " + snapshot.getOpen());
      System.out.println("High:             " + snapshot.getHigh());
      System.out.println("Low:              " + snapshot.getLow());
      System.out.println("Last trade side:  " + snapshot.getLastTradeSide());
      System.out.println("Last trade time:  " + snapshot.getLastTradeTime());
      System.out.println("Last trade price: " + snapshot.getLastTradePrice());
      System.out.println("Last trade size:  " + snapshot.getLastTradeSize());
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoSnapshot");
      e.printStackTrace();
    }
  }
}
