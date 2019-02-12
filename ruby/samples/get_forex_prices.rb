# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end
 
forex_api = Intrinio::ForexApi.new

pair = "EURUSD" # String | The Forex Currency Pair code

timeframe = "D1" # String | The time interval for the quotes

opts = { 
}

begin
  result = forex_api.get_forex_prices(pair, timeframe, opts)
  prices = result.prices
  
  puts "Listing #{prices.size} Forex Prices"
  puts ""
  prices.each do |price|
    puts "Occurred at: #{price.occurred_at}"
    puts "Open bid:    #{price.open_bid}"
    puts "High bid:    #{price.high_bid}"
    puts "Low bid:     #{price.low_bid}"
    puts "Close bid:   #{price.close_bid}"
    puts "Open ask:    #{price.open_ask}"
    puts "High ask:    #{price.high_ask}"
    puts "Low ask:     #{price.low_ask}"
    puts "Close ask:   #{price.close_ask}"
    puts "Total ticks: #{price.total_ticks}"
    puts "--------------------------------------------------------------------------"
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling ForexApi->get_forex_prices: #{e}"
end
