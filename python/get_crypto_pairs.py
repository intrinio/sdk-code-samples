from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
crypto_api = intrinio_sdk.CryptoApi()

exchange = 'gemini' # str | Return pairs traded on the given Crypto Exchange. (optional)
currency = 'BTC' # str | Return pairs with one side being the given Crypto Currency. (optional)
 
try:
    api_response = crypto_api.get_crypto_pairs(exchange=exchange, currency=currency)
    pairs = api_response.currency_pairs

    print("%s pairs found!" % (len(pairs)))

    print("------------------------------------------------------------")
    for pair in pairs:
        print("Name:                 %s" % (pair.name))
        print("Code:                 %s" % (pair.code))
        print("First price date:     %s" % (pair.first_price_date))
        print("Last price date:      %s" % (pair.last_price_date))
        print("Book depth available: %s" % (pair.book_depth_available))
        print("History available:    %s" % (pair.history_available))
        print("Snapshot available:   %s" % (pair.snapshot_available))
        print("Trades available:     %s" % (pair.trades_available))

        print("Currencies: ")
        for currency in pair.currencies:
            print("  - %s" % (currency))

        print("Exchanges: ")
        for exchange in pair.exchanges:
            print("  - %s" % (exchange))

        print("")
except ApiException as e:
    print("Exception when calling CryptoApi->get_crypto_pairs: %s\n" % e)
