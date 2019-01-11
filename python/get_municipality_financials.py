from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'

municipality_api = intrinio_sdk.MunicipalityApi()
 
identifier = 'Xn7x4z' # str | An Intrinio ID of a Municipality
 
try:
    financials = municipality_api.get_municipality_financials(identifier)
    municipality = financials.municipality

    print("MUNICIPALITY")
    print("-------------------------------------------------")
    print("Governamnt name: %s" % (municipality.government_name))
    print("ID:              %s" % (municipality.id))
    print("Census ID:       %s" % (municipality.census_id))
    print("Government type: %s" % (municipality.government_type))
    print("Area type:       %s" % (municipality.area_type))
    print("Area name:       %s" % (municipality.area_name))
    print("Location:        %s, %s %s" % (municipality.city, municipality.state, municipality.zip))
    print("")
    print("FINANCIALS")
    print("-------------------------------------------------")
    print("Fiscal year:         %s" % (financials.fiscal_year))
    print("Current assets:      %s" % (financials.current_assets))
    print("Total assets:        %s" % (financials.total_assets))
    print("Current liabilities: %s" % (financials.current_liabilities))
    print("Total liabilities:   %s" % (financials.total_liabilities))
    print("Total net position:  %s" % (financials.total_net_position))
    print("Total expenses:      %s" % (financials.total_expenses))
    print("Total revenues:      %s" % (financials.total_revenues))
except ApiException as e:
    print("Exception when calling MunicipalityApi->get_municipality_financials: %s\n" % e)
