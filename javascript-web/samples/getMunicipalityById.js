var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var municipalityAPI = new intrinioSDK.MunicipalityApi();

var identifier = "geV70X"; // String | An Intrinio ID of a Municipality
 
municipalityAPI.getMunicipalityById(identifier).then(function(municipality) {
  $('#apiResult').html(JSON.stringify(municipality, undefined, 2));

  console.log(municipality);
  console.log("" + municipality.government_name);
  console.log("-------------------------------------------------------------------------");
  console.log("ID:                    " + municipality.id);
  console.log("Census ID:             " + municipality.census_id);
  console.log("Government type:       " + municipality.government_type);
  console.log("Area type:             " + municipality.area_type);
  console.log("Area name:             " + municipality.area_name);
  console.log("Web site:              " + municipality.web_site);
  console.log("Population:            " + municipality.population);
  console.log("Population as of year: " + municipality.population_as_of_year);
  console.log("Enrollment:            " + municipality.enrollment);
  console.log("Enrollment as of year: " + municipality.enrollment_as_of_year);
  console.log("Latitude:              " + municipality.latitude); 
  console.log("Longitude:             " + municipality.longitude); 
  console.log("Location:              " + municipality.address1); 
  if (municipality.address2 !== null) { console.log("                       " + municipality.address2); }
  console.log("                       " + municipality.city + ", " + municipality.state + " " + municipality.zip);
}, function(error) {
  console.error(error);
});

 
