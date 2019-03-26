from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
crypto_api = intrinio_sdk.CryptoApi()

exchange = 'gemini' # str | Returns Crypto Currencies traded on the given Crypto Exchange. (optional)
 
try:
    api_response = crypto_api.get_crypto_currencies(exchange=exchange)
    currencies = api_response.currencies

    if exchange:
        print("%s curriences found for %s!" % (len(currencies), exchange))
    else:
        print("%s curriences found!" % (len(currencies)))

    print("------------------------------------------------------------")

    for currency in currencies:
        print("Name:             %s" % (currency.name))
        print("Code:             %s" % (currency.code))
        print("Symbol:           %s" % (currency.symbol))
        print("First price date: %s" % (currency.first_price_date))
        print("Last price date:  %s" % (currency.last_price_date))
        print("")

except ApiException as e:
    print("Exception when calling CryptoApi->get_crypto_currencies: %s\n" % e)
