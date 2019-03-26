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
    String exchange = "gemini"; // String | Returns Crypto Currencies traded on the given Crypto Exchange.

    try {
      ApiResponseCryptoCurrencies result = cryptoApi.getCryptoCurrencies(exchange);
      List<CryptoCurrency> currencies = result.getCurrencies();

      System.out.println(currencies.size() + " currencies found!");
      System.out.println();

      for (CryptoCurrency currency: currencies) {
        System.out.println("Name:             " + currency.getName());
        System.out.println("Code:             " + currency.getCode());
        System.out.println("Symbol:           " + currency.getSymbol());
        System.out.println("First price date: " + currency.getFirstPriceDate());
        System.out.println("Last price date:  " + currency.getLastPriceDate());
        System.out.println();
      }
    } catch (ApiException e) {
      System.err.println("Exception when calling CryptoApi#getCryptoCurrencies");
      e.printStackTrace();
    }
  }
}
