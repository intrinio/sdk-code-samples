# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
crypto_api = Intrinio::CryptoApi.new
 
opts = { 
  exchange: "gemini", # String | Returns stats for Crypto Currencies that trade on the specified Crypto Exchange.
  currency: "BTC" # String | Returns stats for the specified Crypto Currency.
}
 
begin
  result = crypto_api.get_crypto_stats(opts)
  currencies = result.currencies
  puts "#{currencies.size} currency stats found!"
  currencies.each do |currency|
    puts "Name:             #{currency.name}"
    puts "Code:             #{currency.code}"
    puts "Symbol:           #{currency.symbol}"
    puts "Market cap(USD):  #{currency.market_cap_usd}"
    puts "Available supply: #{currency.available_supply}"
    puts "Total supply:     #{currency.total_supply}"
    puts "Max supply:       #{currency.max_supply}"
    puts "Last updated:     #{currency.last_updated}"
    puts ""
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling CryptoApi->get_crypto_stats: #{e}"
end
