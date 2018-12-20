from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
security_api = intrinio_sdk.SecurityApi()
 
identifier = 'AAPL' # str | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)

try:
    api_response = security_api.get_security_latest_dividend_record(identifier)
    security = api_response.security

    print("Security Summary")
    print("-------------------------------------------------")
    print("Name:       %s" % (security.name))
    print("Code:       %s" % (security.code))
    print("Company ID: %s" % (security.company_id))
    print("Ticker:     %s" % (security.ticker))
    print("")
    print("")
    print("Latest Dividend Record")
    print("-------------------------------------------------")
    print("Announcement date: %s" % (api_response.announcement_date))
    print("Record date:       %s" % (api_response.record_date))
    print("Pay date:          %s" % (api_response.pay_date))
    print("Frequency:         %s" % (api_response.frequency))
    print("Status:            %s" % (api_response.status))
    print("Forward yield:     %s" % (api_response.forward_yield))
    print("Forward rate:      %s" % (api_response.forward_rate))

except ApiException as e:
    print("Exception when calling SecurityApi->get_security_latest_dividend_record: %s\n" % e)
