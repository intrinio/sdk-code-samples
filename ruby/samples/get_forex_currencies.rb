# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end
 
forex_api = Intrinio::ForexApi.new
 
begin
  result = forex_api.get_forex_currencies
  currencies = result.currencies
  
  puts "Listing #{currencies.size} Forex Currencies"
  puts ""
  currencies.each do |currency|
    puts "Code:    #{currency.code}"
    puts "Name:    #{currency.name}"
    puts "Country: #{currency.country}"
    puts "--------------------------------------------------------------------------"
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling ForexApi->get_forex_currencies: #{e}"
end
