var intrinio = require('intrinio');
intrinio.ApiClient.instance.authentications['HttpHeaderApiKey'].apiKey = "YOUR API KEY";

var company_api = new intrinio.CompanyApi();
var opts = {};

company_api.getAllCompanies(opts).then(function(data) {
  console.log('API called successfully.');
  data.forEach(function(company) {
    console.log(company.name);
  });
}, function(error) {
  console.error(error);
});
