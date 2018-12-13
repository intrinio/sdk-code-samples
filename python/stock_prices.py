from __future__ import print_function
import time
from datetime import datetime, date, timedelta
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint

intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'

security_api = intrinio_sdk.SecurityApi()

identifier = 'AAPL' # str | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
start_date = str(date.today() - timedelta(days = 90)) # date | Get historical data on or after this date (optional)
end_date = str(date.today()) # date | Get historical date on or before this date (optional)
frequency = 'daily' # str | Sort by date `asc` or `desc` (optional)
next_page = '' # str | Gets the next page of data from a previous API call (optional)

try:
    api_response = security_api.get_security_stock_prices(identifier, start_date=start_date, end_date=end_date, frequency=frequency)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling SecurityApi->get_security_historical_data: %s\n" % e)
