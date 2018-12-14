# Load the gem
require 'bundler/setup'
require 'intrinio-sdk'
require 'awesome_print'

# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end

security_api = Intrinio::SecurityApi.new

identifier = "AAPL" # String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)

opts = { 
  start_date: Date.today - 90, # Date | Return prices on or after the date
  end_date: Date.today, # Date | Return prices on or before the date
  frequency: "daily", # String | Return stock prices in the given frequency
  next_page: '' # String | Gets the next page of data from a previous API call
}

begin
  results = security_api.get_security_stock_prices(identifier, opts)
  results.stock_prices.each do |stock_price|
    ap stock_price
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling SecurityApi->get_security_stock_prices: #{e}"
end
