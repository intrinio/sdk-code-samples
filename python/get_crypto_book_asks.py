from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
crypto_api = intrinio_sdk.CryptoApi()
 
pair = 'btcusd' # str | Return the order book asks for the given Crypto Currency Pair. (optional)
exchange = 'gemini' # str | Return the order book asks for a Crypto Currency on the given Crypto Exchange. (optional)
currency = 'BTC' # str | Return the order book asks for the given Crypto Currency. (optional)
 
try:
    api_response = crypto_api.get_crypto_book_asks(pair=pair, exchange=exchange, currency=currency)
    asks = api_response.asks

    print("Crypto Currency Pair: %s" % (api_response.pair.name))
    print("Crypto Exchange: %s" % (api_response.exchange.name))
    print("")
    print("-------------------------------------- ASKS -------------------------------------- ")

    for ask in asks:
        print("")
        print("Price: %s" % (ask.price))
        print("Size:  %s" % (ask.size))

except ApiException as e:
    print("Exception when calling CryptoApi->get_crypto_book_asks: %s\n" % e)
