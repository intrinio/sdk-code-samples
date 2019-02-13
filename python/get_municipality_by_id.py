from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint
 
intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
 
municipality_api = intrinio_sdk.MunicipalityApi()
 
identifier = 'geV70X' # str | An Intrinio ID of a Municipality
 
try:
    municipality = municipality_api.get_municipality_by_id(identifier)
    print(municipality.government_name)
    print("-------------------------------------------------")
    print("ID:                    %s" % (municipality.id))
    print("Census ID:             %s" % (municipality.census_id))
    print("Government type:       %s" % (municipality.government_type))
    print("Area type:             %s" % (municipality.area_type))
    print("Area name:             %s" % (municipality.area_name))
    print("Web site:              %s" % (municipality.web_site))
    print("Population:            %s" % (municipality.population))
    print("Population as of year: %s" % (municipality.population_as_of_year))
    print("Enrollment:            %s" % (municipality.enrollment))
    print("Enrollment as of year: %s" % (municipality.enrollment_as_of_year))
    print("Latitude:              %s" % (municipality.latitude)) 
    print("Longitude:             %s" % (municipality.longitude)) 
    print("Location:              %s" % (municipality.address1))
    if municipality.address2 is not None:
        print("                       %s" % (municipality.address2))
    print("                       %s, %s, %s" % (municipality.city, municipality.state, municipality.zip))
except ApiException as e:
    print("Exception when calling MunicipalityApi->get_municipality_by_id: %s\n" % e)
