from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
security_api = intrinio_sdk.SecurityApi()

identifier = 'AAPL' # str | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)

try:
    result = security_api.get_security_price_technicals_macd(identifier)
    indicator = result.indicator
    security = result.security
    technicals = result.technicals

    pprint("Technicals for %s" % security.ticker)
    pprint("%s values for %s returned!" % (len(technicals), indicator.name))
    print("")

    for technical in technicals:
        pprint("DateTime:       %s" % technical.date_time)

        value = technical.value
        pprint("MACD Histogram: %s" % value.macd_histogram)
        pprint("MACD Line:      %s" % value.macd_line)
        pprint("Signal Line:    %s" % value.signal_line)
        pprint("------------------------------------------------------")
except ApiException as e:
    print("Exception when calling SecurityApi->get_security_price_technicals_macd: %s\n" % e)
