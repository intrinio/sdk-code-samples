# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end
 
forex_api = Intrinio::ForexApi.new
 
begin
  result = forex_api.get_forex_pairs
  pairs = result.pairs
  
  puts "Listing #{pairs.size} Forex Currency Pairs"
  puts ""
  pairs.each do |pair|
    puts "Code:           #{pair.code}"
    puts "Base currency:  #{pair.base_currency}"
    puts "Quote currency: #{pair.quote_currency}"
    puts "--------------------------------------------------------------------------"
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling ForexApi->get_forex_pairs: #{e}"
end
