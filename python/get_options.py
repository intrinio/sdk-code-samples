from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
options_api = intrinio_sdk.OptionsApi()
 
symbol = 'AAPL' # str | The option symbol, corresponding to the underlying security.
type = 'put' # str | The option contract type. (optional)

try:
    api_response = options_api.get_options(symbol, type=type)
    options = api_response.options

    print("%s options found for %s!" % (len(options), symbol))

    for option in options:
        print("")
        print("ID:         %s" % (option.id))
        print("Code:       %s" % (option.code))
        print("Ticker:     %s" % (option.ticker))
        print("Expiration: %s" % (option.expiration))
        print("Strike:     %s" % (option.strike))
        print("Type:       %s" % (option.type))
except ApiException as e:
    print("Exception when calling OptionsApi->get_options: %s\n" % e)
