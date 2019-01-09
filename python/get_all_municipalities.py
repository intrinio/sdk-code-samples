from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
municipality_api = intrinio_sdk.MunicipalityApi()
 
next_page = '' # str | Gets the next page of data from a previous API call (optional)
 
try:
    api_response = municipality_api.get_all_municipalities(next_page=next_page)
    municipalities = api_response.municipalities

    for municipality in municipalities:
        print(municipality.government_name)
        print("-------------------------------------------------")
        print("ID:              %s" % (municipality.id))
        print("Census ID:       %s" % (municipality.census_id))
        print("Government type: %s" % (municipality.government_type))
        print("Area type:       %s" % (municipality.area_type))
        print("Area name:       %s" % (municipality.area_name))
        print("Location:        %s, %s %s" % (municipality.city, municipality.state, municipality.zip))
        print("")
except ApiException as e:
    print("Exception when calling MunicipalityApi->get_all_municipalities: %s\n" % e)
