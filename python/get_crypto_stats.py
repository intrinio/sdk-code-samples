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
    currencies = api_response.currencies
    print("%s currency stats found!" % (len(currencies)))

    for currency in currencies:
        print("Name:             %s" % (currency.name))
        print("Code:             %s" % (currency.code))
        print("Symbol:           %s" % (currency.symbol))
        print("Market cap(USD):  %s" % (currency.market_cap_usd))
        print("Available supply: %s" % (currency.available_supply))
        print("Total supply:     %s" % (currency.total_supply))
        print("Max supply:       %s" % (currency.max_supply))
        print("Last updated:     %s" % (currency.last_updated))
        print("")
except ApiException as e:
    print("Exception when calling CryptoApi->get_crypto_stats: %s\n" % e)
