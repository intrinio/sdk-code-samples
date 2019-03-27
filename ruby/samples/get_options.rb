# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
options_api = Intrinio::OptionsApi.new

symbol = "AAPL" # String | The option symbol, corresponding to the underlying security.

opts = { 
  type: "put", # String | The option contract type.
  strike: nil, # Float | The strike price of the option contract. This will return options contracts with strike price equal to this price.
  strike_greater_than: nil, # Float | The strike price of the option contract. This will return options contracts with strike prices greater than this price.
  strike_less_than: nil, # Float | The strike price of the option contract. This will return options contracts with strike prices less than this price.
  expiration: nil, # String | The expiration date of the option contract. This will return options contracts with expiration dates on this date.
  expiration_after: nil, # String | The expiration date of the option contract. This will return options contracts with expiration dates after this date.
  expiration_before: nil, # String | The expiration date of the option contract. This will return options contracts with expiration dates before this date.
  page_size: 100, # Float | The number of results to return
  next_page: nil # String | Gets the next page of data from a previous API call
}

begin
  result = options_api.get_options(symbol, opts)
  options = result.options

  puts "#{options.size} options found for #{symbol}!"

  options.each do |option|
    puts ""
    puts "ID:         #{option.id}"
    puts "Code:       #{option.code}"
    puts "Ticker:     #{option.ticker}"
    puts "Expiration: #{option.expiration}"
    puts "Strike:     #{option.strike}"
    puts "Type:       #{option.type}"
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling OptionsApi->get_options: #{e}"
end
