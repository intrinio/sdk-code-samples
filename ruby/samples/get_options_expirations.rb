# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
options_api = Intrinio::OptionsApi.new
 
symbol = "AAPL" # String | The option symbol, corresponding to the underlying security.
 
opts = { 
  after: nil, # String | Return option contract expiration dates after this date.
  before: nil # String | Return option contract expiration dates before this date.
}
 
begin
  result = options_api.get_options_expirations(symbol, opts)

  expirations = result.expirations
  
  puts "#{expirations.size} expirations found for #{symbol}!"
  puts ""
  expirations.each { |expiration| puts expiration }
rescue Intrinio::ApiError => e
  puts "Exception when calling OptionsApi->get_options_expirations: #{e}"
end
