from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
security_api = intrinio_sdk.SecurityApi()

identifier = 'AAPL' # str | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
timezone = 'America/New_York' # str | Returns technical indicators in this timezone (optional) (default to UTC)
page_size = 25 # int | The number of results to return (optional) (default to 100)
 
try:
    result = security_api.get_security_price_technicals_rsi(identifier, timezone=timezone, page_size=page_size)
    indicator = result.indicator
    security = result.security
    technicals = result.technicals

    pprint("Technicals for %s" % security.ticker)
    pprint("%s values for %s returned!" % (len(technicals), indicator.name))
    print("")

    for technical in technicals:
        pprint("DateTime: %s" % technical.date_time)
        pprint("RSI:      %s" % technical.rsi)
        pprint("------------------------------------------------------")
except ApiException as e:
    print("Exception when calling SecurityApi->get_security_price_technicals_rsi: %s\n" % e)
