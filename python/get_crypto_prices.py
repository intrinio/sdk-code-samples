from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
crypto_api = intrinio_sdk.CryptoApi()

timeframe = 'h1' # str | The time interval for the prices.
pair = 'btcusd' # str | Return prices for the given Crypto Currency Pair. (optional)
exchange = 'gemini' # str | Return prices for a Crypto Currency on the given Crypto Exchange. (optional)
currency = 'BTC' # str | Return prices for the given Crypto Currency. (optional)
timezone = 'UTC' # str | Return price date/times in this timezone, also interpret start/end date/time parameters in this timezone. (optional) (default to UTC)
start_date = '2018-01-01' # str | Return Crypto Prices on or after this date. (optional)
start_time = '14:20:00' # str | Return Crypto Prices at or after this time (24-hour). (optional)
end_date = '2019-01-01' # str | Return Crypto Prices on or before this date. (optional)
end_time = '21:01:21' # str | Return Crypto Prices at or before this time (24-hour). (optional)
page_size = 100 # int | An integer greater than or equal to 1 for specifying the number of results on each page. (optional) (default to 100)
 
try:
    api_response = crypto_api.get_crypto_prices(timeframe, pair=pair, exchange=exchange, currency=currency, timezone=timezone, start_date=start_date, start_time=start_time, end_date=end_date, end_time=end_time, page_size=page_size)
    prices = api_response.prices
    pair_name = api_response.pair.name
    exchange_name = api_response.exchange.name

    print("%s prices found for %s on %s" % (len(prices), pair_name, exchange_name))
    print("------------------------------------------------------")

    for price in prices:
        print("Time:   %s" % (price.time))
        print("Open:   %s" % (price.open))
        print("High:   %s" % (price.high))
        print("Low:    %s" % (price.low))
        print("Close:  %s" % (price.close))
        print("Volume: %s" % (price.volume))
        print("")
except ApiException as e:
    print("Exception when calling CryptoApi->get_crypto_prices: %s\n" % e)
