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
      List<CryptoStat> currencies = result.getCurrencies();
      System.out.println(currencies.size() + " currency stats found!");
      System.out.println();

      for(CryptoStat crypto_currency : currencies) {
        System.out.println("Name:             " + crypto_currency.getName());
        System.out.println("Code:             " + crypto_currency.getCode());
        System.out.println("Symbol:           " + crypto_currency.getSymbol());
        System.out.println("Market cap(USD):  " + crypto_currency.getMarketCapUsd());
        System.out.println("Available supply: " + crypto_currency.getAvailableSupply());
        System.out.println("Total supply:     " + crypto_currency.getTotalSupply());
        System.out.println("Max supply:       " + crypto_currency.getMaxSupply());
        System.out.println("Last updated:     " + crypto_currency.getLastUpdated());
        System.out.println();
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoStats");
      e.printStackTrace();
    }
  }
}
