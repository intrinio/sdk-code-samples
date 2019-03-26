from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
crypto_api = intrinio_sdk.CryptoApi()
exchange = 'gemini' # str | Returns stats for Crypto Currencies that trade on the specified Crypto Exchange. (optional)

currency = 'BTC' # str | Returns stats for the specified Crypto Currency. (optional)

try:
    api_response = crypto_api.get_crypto_stats(exchange=exchange, currency=currency)
    stats = api_response.stats
    print("%s stats found!" % (len(stats)))

    for stat in stats:
        print("Name:             %s" % (stat.name))
        print("Code:             %s" % (stat.code))
        print("Symbol:           %s" % (stat.symbol))
        print("Market cap(USD):  %s" % (stat.market_cap_usd))
        print("Available supply: %s" % (stat.available_supply))
        print("Total supply:     %s" % (stat.total_supply))
        print("Max supply:       %s" % (stat.max_supply))
        print("Last updated:     %s" % (stat.last_updated))
        print("")
except ApiException as e:
    print("Exception when calling CryptoApi->get_crypto_stats: %s\n" % e)
