var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";

var municipalityAPI = new intrinioSDK.MunicipalityApi();

var opts = { 
  'nextPage': null // String | Gets the next page of data from a previous API call
};

municipalityAPI.getAllMunicipalities(opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(data, undefined, 2));

  var municipalities = data.municipalities;

  console.log(municipalities.length + " municipalities found!")

  municipalities.forEach(function(municipality, index) {
    console.log();
    console.log((index + 1) + ".  " + municipality.government_name);
    console.log("-------------------------------------------------------------------------");
    console.log("ID:              " + municipality.id);
    console.log("Census ID:       " + municipality.census_id);
    console.log("Government type: " + municipality.government_type);
    console.log("Area type:       " + municipality.area_type);
    console.log("Area name:       " + municipality.area_name);
    console.log("Location:        " + municipality.city + " " + municipality.state + " " + municipality.zip);
  });
}, function(error) {
  console.error(error);
});
