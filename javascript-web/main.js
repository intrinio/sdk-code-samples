var intrinio = require('intrinio');
intrinio.ApiClient.instance.authentications['HttpHeaderApiKey'].apiKey = "YOUR_API_KEY";

var company_api = new intrinio.CompanyApi();
var opts = {};

company_api.getAllCompanies(opts).then(function(data) {
  $('#apiResult').html(JSON.stringify(data, undefined, 2));
}, function(error) {
  console.error(error);
  ('#apiResult').html(error);
});
