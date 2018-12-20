from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
security_api = intrinio_sdk.SecurityApi()
 
identifier = 'AAPL' # str | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
 
try:
    api_response = security_api.get_security_latest_earnings_record(identifier)
    security = api_response.security

    print("Security Summary")
    print("-------------------------------------------------")
    print("Name:       %s" % (security.name))
    print("Code:       %s" % (security.code))
    print("Company ID: %s" % (security.company_id))
    print("Ticker:     %s" % (security.ticker))
    print("")
    print("")
    print("Latest Earnings Record")
    print("-------------------------------------------------")
    print("Quarter:                   %s" % (api_response.quarter))
    print("Q1 date:                   %s" % (api_response.q1_date))
    print("Q2 date:                   %s" % (api_response.q2_date))
    print("Q3 date:                   %s" % (api_response.q3_date))
    print("Q4 date:                   %s" % (api_response.q4_date))
    print("Type:                      %s" % (api_response.type))
    print("Next earnings date:        %s" % (api_response.next_earnings_date))
    print("Next earnings quarter:     %s" % (api_response.next_earnings_quarter))
    print("Next earnings fiscal year: %s" % (api_response.next_earnings_fiscal_year))

except ApiException as e:
    print("Exception when calling SecurityApi->get_security_latest_earnings_record: %s\n" % e)
