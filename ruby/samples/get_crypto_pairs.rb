# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
crypto_api = Intrinio::CryptoApi.new
 
opts = { 
  exchange: "gemini", # String | Return pairs traded on the given Crypto pair.
  currency: "BTC" # String | Return pairs with one side being the given Crypto Currency.
}
 
begin
  result = crypto_api.get_crypto_pairs(opts)
  pairs = result.currency_pairs
  
  puts "#{pairs.size} pairs found!"

  puts "------------------------------------------------------------"
  pairs.each do |pair|
    puts "Name:                 #{pair.name}"
    puts "Code:                 #{pair.code}"
    puts "First price date:     #{pair.first_price_date}"
    puts "Last price date:      #{pair.last_price_date}"
    puts "Book depth available: #{pair.book_depth_available}"
    puts "History available:    #{pair.history_available}"
    puts "Snapshot available:   #{pair.snapshot_available}"
    puts "Trades available:     #{pair.trades_available}"
    puts "Currencies: "
    pair.currencies.each { |currency| puts "  - #{currency}" }
    puts "Exchanges: "
    pair.exchanges.each { |exchange| puts "  - #{exchange}" }
    puts ""
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling CryptoApi->get_crypto_pairs: #{e}"
end
