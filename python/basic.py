from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint

intrinio_sdk.ApiClient().configuration.api_key['api-key'] = 'YOUR_API_KEY' 

company_api = intrinio_sdk.CompanyApi()

try:
    api_response = company_api.filter_companies()
    pprint(api_response)
except ApiException as e:
    print("Exception when calling CompanyApi->filter_companies: %s\n" % e)
