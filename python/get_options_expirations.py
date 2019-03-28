from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
options_api = intrinio_sdk.OptionsApi()
 
symbol = 'AAPL' # str | The option symbol, corresponding to the underlying security.
 
try:
    api_response = options_api.get_options_expirations(symbol)
    expirations = api_response.expirations

    print("%s options expirations found for %s!" % (len(expirations), symbol))
    print()

    for expiration in expirations:
        print(expiration)
except ApiException as e:
    print("Exception when calling OptionsApi->get_options_expirations: %s\n" % e)
