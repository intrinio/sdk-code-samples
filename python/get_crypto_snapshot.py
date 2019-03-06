from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
crypto_api = intrinio_sdk.CryptoApi()

pair = 'btcusd' # str | Return the snapshot for the given Crypto Currency Pair. (optional)
exchange = 'gemini' # str | Return the snapshot for a Crypto Currency on the given Crypto Exchange. (optional)
currency = 'BTC' # str | Return the snapshot for the given Crypto Currency. (optional)
 
try:
    api_response = crypto_api.get_crypto_snapshot(pair=pair, exchange=exchange, currency=currency)
    snapshot = api_response.snapshot
    pair_name = api_response.pair.name
    exchange_name = api_response.exchange.name

    print("Snapshot for %s on %s!" % (pair_name, exchange_name))
    print("------------------------------------------------------")
    print("Last updated:     %s" % (snapshot.last_updated))
    print("Bid:              %s" % (snapshot.bid))
    print("Bid size:         %s" % (snapshot.bid_size))
    print("Ask:              %s" % (snapshot.ask))
    print("Ask size:         %s" % (snapshot.ask_size))
    print("Change:           %s" % (snapshot.change))
    print("Change percent:   %s" % (snapshot.change_percent))
    print("Volume:           %s" % (snapshot.volume))
    print("Open:             %s" % (snapshot.open))
    print("High:             %s" % (snapshot.high))
    print("Low:              %s" % (snapshot.low))
    print("Last trade side:  %s" % (snapshot.last_trade_side))
    print("Last trade time:  %s" % (snapshot.last_trade_time))
    print("Last trade price: %s" % (snapshot.last_trade_price))
    print("Last trade size:  %s" % (snapshot.last_trade_size))
except ApiException as e:
    print("Exception when calling CryptoApi->get_crypto_snapshot: %s\n" % e)
