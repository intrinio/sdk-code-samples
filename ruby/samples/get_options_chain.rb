# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end

options_api = Intrinio::OptionsApi.new
 
symbol = "AAPL" # String | The option symbol, corresponding to the underlying security.
 
expiration = "2019-03-18" # String | The expiration date of the options contract
 
opts = { 
  type: nil, # String | The option contract type.
  strike: nil, # Float | The strike price of the option contract. This will return options contracts with strike price equal to this price.
  strike_greater_than: nil, # Float | The strike price of the option contract. This will return options contracts with strike prices greater than this price.
  strike_less_than: nil, # Float | The strike price of the option contract. This will return options contracts with strike prices less than this price.
  moneyness: nil, # String | The moneyness of the options contracts to return. 'all' will return all options contracts. 'in_the_money' will return options contracts that are in the money (call options with strike prices below the current price, put options with strike prices above the current price). 'out_of_they_money' will return options contracts that are out of the money (call options with strike prices above the current price, put options with strike prices below the current 
  page_size: 100 # Float | The number of results to return
}
 
begin
  result = options_api.get_options_chain(symbol, expiration, opts)
  chains = result.chains

  puts "#{chains.size} option chains found for #{symbol}!"

  chains.each do |chain|
    option = chain.option
    price = chain.price

    puts ""
    puts "------------------------------------------------------------------------------------------------"
    puts "OPTION"
    puts "ID:         #{option.id}"
    puts "Code:       #{option.code}"
    puts "Ticker:     #{option.ticker}"
    puts "Expiration: #{option.expiration}"
    puts "Strike:     #{option.strike}"
    puts "Type:       #{option.type}"

    puts ""
    puts "PRICE"
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
  puts "Exception when calling OptionsApi->get_options_chain: #{e}"
end
