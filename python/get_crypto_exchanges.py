from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
crypto_api = intrinio_sdk.CryptoApi()

pair = 'btcusd' # str | Returns Crypto Currencies traded on the given Crypto Exchange. (optional)
 
try:
    api_response = crypto_api.get_crypto_exchanges(pair=pair)
    exchanges = api_response.exchanges

    if pair:
        print("%s exchanges found for %s!" % (len(exchanges), pair))
    else:
        print("%s exchanges found!" % (len(exchanges)))

    print("------------------------------------------------------------")

    for exchange in exchanges:
        print("Name:                 %s" % (exchange.name))
        print("Code:                 %s" % (exchange.code))
        print("Book depth available: %s" % (exchange.book_depth_available))
        print("History available:    %s" % (exchange.history_available))
        print("Snapshot available:   %s" % (exchange.snapshot_available))
        print("Trades available:     %s" % (exchange.trades_available))
        print("")

except ApiException as e:
    print("Exception when calling CryptoApi->get_crypto_exchanges: %s\n" % e)
