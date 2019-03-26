# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
crypto_api = Intrinio::CryptoApi.new
 
opts = { 
  exchange: "gemini" # String | Returns Crypto Currencies traded on the given Crypto Exchange.
}
 
begin
  result = crypto_api.get_crypto_currencies(opts)
  currencies = result.currencies
  
  if opts[:exchange]
    puts "#{currencies.size} curriences found for #{opts[:exchange]}!"
  else
    puts "#{currencies.size} currencies found!"
  end

  puts "------------------------------------------------------------"
  currencies.each do |currency|
    puts "Name:             #{currency.name}"
    puts "Code:             #{currency.code}"
    puts "Symbol:           #{currency.symbol}"
    puts "First price date: #{currency.first_price_date}"
    puts "Last price date:  #{currency.last_price_date}"
    puts ""
  end

rescue Intrinio::ApiError => e
  puts "Exception when calling CryptoApi->get_crypto_currencies: #{e}"
end
