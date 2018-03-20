# Load the gem
require 'intrinio-sdk'

# Setup authorization
Intrinio.configure do |config|
  config.api_key['api-key'] = 'YOUR API KEY'
end

company_api = Intrinio::CompanyApi.new

begin
  results = company_api.filter_companies()
  results.each do |company|
    puts company.name
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling CompanyApi->filter_companies: #{e}"
end
