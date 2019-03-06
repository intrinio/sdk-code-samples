from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
crypto_api = intrinio_sdk.CryptoApi()
 
pair = 'btcusd' # str | Return the order book bids for the given Crypto Currency Pair. (optional)
exchange = 'gemini' # str | Return the order book bids for a Crypto Currency on the given Crypto Exchange. (optional)
currency = 'BTC' # str | Return the order book bids for the given Crypto Currency. (optional)
 
try:
    api_response = crypto_api.get_crypto_book_bids(pair=pair, exchange=exchange, currency=currency)
    bids = api_response.bids

    print("Crypto Currency Pair: %s" % (api_response.pair.name))
    print("Crypto Exchange: %s" % (api_response.exchange.name))
    print("")
    print("-------------------------------------- BIDS -------------------------------------- ")

    for bid in bids:
        print("")
        print("Price: %s" % (bid.price))
        print("Size:  %s" % (bid.size))

except ApiException as e:
    print("Exception when calling CryptoApi->get_crypto_book_bids: %s\n" % e)
