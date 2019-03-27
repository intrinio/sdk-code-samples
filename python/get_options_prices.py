from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
options_api = intrinio_sdk.OptionsApi()
 
identifier = 'AAPL190318C00300510' # str | The Intrinio ID or code of the options contract to request prices for.
 
try:
    api_response = options_api.get_options_prices(identifier)
    option = api_response.option
    prices = api_response.prices
    
    print("*** OPTION ***")
    print("ID:         %s" % (option.id))
    print("Code:       %s" % (option.code))
    print("Ticker:     %s" % (option.ticker))
    print("Expiration: %s" % (option.expiration))
    print("Strike:     %s" % (option.strike))
    print("Type:       %s" % (option.type))
    
    print()
    print("%s options prices for %s!" % (len(prices), identifier))
    print("------------------------------------------------------------")

    for price in prices:
        print()
        print("Date:                      %s" % (price.date))
        print("Close:                     %s" % (price.close))
        print("Close bid:                 %s" % (price.close_bid))
        print("Close ask:                 %s" % (price.close_ask))
        print("Volume:                    %s" % (price.volume))
        print("Volume bid:                %s" % (price.volume_bid))
        print("Volume ask:                %s" % (price.volume_ask))
        print("Trades:                    %s" % (price.trades))
        print("Open interest:             %s" % (price.open_interest))
        print("Open interest change:      %s" % (price.open_interest_change))
        print("Next day open interest:    %s" % (price.next_day_open_interest))
        print("Implied volatility:        %s" % (price.implied_volatility))
        print("Implied volatility change: %s" % (price.implied_volatility_change))
        print("Delta:                     %s" % (price.delta))
except ApiException as e:
    print("Exception when calling OptionsApi->get_options_prices: %s\n" % e)
