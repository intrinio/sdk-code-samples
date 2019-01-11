var intrinioSDK = require('intrinio-sdk');
intrinioSDK.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = "YOUR API KEY";
 
var municipalityAPI = new intrinioSDK.MunicipalityApi();

var identifier = "Xn7x4z"; // String | An Intrinio ID of a Municipality

municipalityAPI.getMunicipalityFinancials(identifier).then(function(financials) {
  $('#apiResult').html(JSON.stringify(financials, undefined, 2));

  var municipality = financials.municipality;

  console.log("MUNICIPALITY");
  console.log("-------------------------------------------------------------------------");
  console.log("Government name: " + municipality.government_name);
  console.log("ID:              " + municipality.id);
  console.log("Census ID:       " + municipality.census_id);
  console.log("Government type: " + municipality.government_type);
  console.log("Area type:       " + municipality.area_type);
  console.log("Area name:       " + municipality.area_name);
  console.log("Location:        " + municipality.city + ", " + municipality.state + " " + municipality.zip);
  console.log();
  console.log("FINANCIALS");
  console.log("-------------------------------------------------------------------------");
  console.log("Fiscal year:         " + financials.fiscal_year);
  console.log("Current assets:      " + financials.current_assets);
  console.log("Total assets:        " + financials.total_assets);
  console.log("Current liabilities: " + financials.current_liabilities);
  console.log("Total liabilities:   " + financials.total_liabilities);
  console.log("Total net position:  " + financials.total_net_position);
  console.log("Total expenses:      " + financials.total_expenses);
  console.log("Total revenues:      " + financials.total_revenues);
}, function(error) {
  console.error(error);
});
 
