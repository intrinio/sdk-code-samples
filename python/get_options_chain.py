from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
options_api = intrinio_sdk.OptionsApi()
 
symbol = 'AAPL' # str | The option symbol, corresponding to the underlying security.
expiration = '2019-03-18' # str | The expiration date of the options contract
 
try:
    api_response = options_api.get_options_chain(symbol, expiration)
    chains = api_response.chains

    print("%s option chains found for %s!" % (len(chains), symbol))

    for chain in chains:
        option = chain.option
        price = chain.price

        print("")
        print("----------------------------------------------------------")
        print("OPTION")
        print("ID:         %s" % (option.id))
        print("Code:       %s" % (option.code))
        print("Ticker:     %s" % (option.ticker))
        print("Expiration: %s" % (option.expiration))
        print("Strike:     %s" % (option.strike))
        print("Type:       %s" % (option.type))

        print("")
        print("PRICE")
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
    print("Exception when calling OptionsApi->get_options_chain: %s\n" % e)
