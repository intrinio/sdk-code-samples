from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
security_api = intrinio_sdk.SecurityApi()

identifier = 'AAPL' # str | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
start_date = '2019-01-01' # str | Return technical indicator values on or after the date (optional)
end_date = '2019-01-31' # str | Return technical indicator values on or before the date (optional)
timezone = 'America/New_York' # str | Returns technical indicators in this timezone (optional) (default to UTC)
 
try:
    result = security_api.get_security_price_technicals_bb(identifier, start_date=start_date, end_date=end_date, timezone=timezone)
    indicator = result.indicator
    security = result.security
    technicals = result.technicals

    pprint("Technicals for %s" % security.ticker)
    pprint("%s values for %s returned!" % (len(technicals), indicator.name))
    print("")

    for technical in technicals:
        pprint("DateTime:    %s" % technical.date_time)
        pprint("Lower Band:  %s" % technical.lower_band)
        pprint("Middle Band: %s" % technical.middle_band)
        pprint("Upper Band:  %s" % technical.upper_band)
        pprint("------------------------------------------------------")
except ApiException as e:
    print("Exception when calling SecurityApi->get_security_price_technicals_bb: %s\n" % e)
