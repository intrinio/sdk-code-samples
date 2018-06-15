# Load the gem
require 'intrinio-sdk'
require 'awesome_print'

# Setup authorization
Intrinio.configure do |config|
  config.api_key['api-key'] = 'YOUR API KEY'
end

mutual_fund_api = Intrinio::MutualFundApi.new

begin
  cusip = "001413103"
  results = mutual_fund_api.get_mutual_fund_stats(cusip)
  results.each do |stat|
    ap stat
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling MutualFundApi->get_mutual_fund_stats: #{e}"
end
