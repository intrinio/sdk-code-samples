# Load the gem
require 'intrinio-sdk'

# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end

options_api = Intrinio::OptionsApi.new

identifier = "AAPL190318C00300510" # String | The Intrinio ID or code of the options contract to request prices for.

opts = { 
  start_date: nil, # String | Return option contract prices on or after this date.
  end_date: nil, # String | Return option contract prices on or before this date.
  page_size: 100, # Float | The number of results to return
  next_page: nil # String | Gets the next page of data from a previous API call
}

begin
  result = options_api.get_options_prices(identifier, opts)
  option = result.option
  prices = result.prices

  puts "*** OPTION ***"
  puts "ID:         #{option.id}"
  puts "Code:       #{option.code}"
  puts "Ticker:     #{option.ticker}"
  puts "Expiration: #{option.expiration}"
  puts "Strike:     #{option.strike}"
  puts "Type:       #{option.type}"

  puts ""
  puts "#{prices.size} prices found for #{identifier}"
  puts "--------------------------------------------------------------------------------"

  prices.each do |price|
    puts ""
    puts "Date:                      #{price.date}"
    puts "Close:                     #{price.close}"
    puts "Close bid:                 #{price.close_bid}"
    puts "Close ask:                 #{price.close_ask}"
    puts "Volume:                    #{price.volume}"
    puts "Volume bid:                #{price.volume_bid}"
    puts "Volume ask:                #{price.volume_ask}"
    puts "Trades:                    #{price.trades}"
    puts "Open interest:             #{price.open_interest}"
    puts "Open interest change:      #{price.open_interest_change}"
    puts "Next day open interest:    #{price.next_day_open_interest}"
    puts "Implied volatility:        #{price.implied_volatility}"
    puts "Implied volatility change: #{price.implied_volatility_change}"
    puts "Delta:                     #{price.delta}"
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling OptionsApi->get_options_prices: #{e}"
end
