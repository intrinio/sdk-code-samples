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
    String timeframe = "h1"; // String | The time interval for the prices.
    String pair = "btcusd"; // String | Return prices for the given Crypto Currency Pair.
    String exchange = "gemini"; // String | Return prices for a Crypto Currency on the given Crypto Exchange.
    String currency = "BTC"; // String | Return prices for the given Crypto Currency.
    String timezone = "UTC"; // String | Return price date/times in this timezone, also interpret start/end date/time parameters in this timezone.
    String startDate = "2018-01-01"; // String | Return Crypto Prices on or after this date.
    String startTime = "14:20:00"; // String | Return Crypto Prices at or after this time (24-hour).
    String endDate = "2019-01-01"; // String | Return Crypto Prices on or before this date.
    String endTime = "21:01:21"; // String | Return Crypto Prices at or before this time (24-hour).
    Integer pageSize = 100; // Integer | An integer greater than or equal to 1 for specifying the number of results on each page.
    String nextPage = null; // String | Gets the next page of data from a previous API call
     
    try {
      ApiResponseCryptoPrices result = cryptoApi.getCryptoPrices(timeframe, pair, exchange, currency, timezone, startDate, startTime, endDate, endTime, pageSize, nextPage);
      List<CryptoPrice> prices = result.getPrices();
      CryptoPairSummary crypto_pair = result.getPair();
      CryptoExchangeSummary crypto_exchange = result.getExchange();

      System.out.println(prices.size() + " prices found for " + crypto_pair.getName() + " on " + crypto_exchange.getName() + "!");
      System.out.println();

      for (CryptoPrice price : prices) {
        System.out.println();
        System.out.println("Time:   " + price.getTime());
        System.out.println("Open:   " + price.getOpen());
        System.out.println("High:   " + price.getHigh());
        System.out.println("Low:    " + price.getLow());
        System.out.println("Close:  " + price.getClose());
        System.out.println("Volume: " + price.getVolume());
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoPrices");
      e.printStackTrace();
    }
  }
}
