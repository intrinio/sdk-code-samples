# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
crypto_api = Intrinio::CryptoApi.new
 
opts = { 
  exchange: "gemini", # String | Returns stats for Crypto Currencies that trade on the specified Crypto Exchange.
  currency: "BTC" # String | Returns stats for the specified Crypto stat.
}
 
begin
  result = crypto_api.get_crypto_stats(opts)
  stats = result.stats
  puts "#{stats.size} stats found!"
  stats.each do |stat|
    puts "Name:             #{stat.name}"
    puts "Code:             #{stat.code}"
    puts "Symbol:           #{stat.symbol}"
    puts "Market cap(USD):  #{stat.market_cap_usd}"
    puts "Available supply: #{stat.available_supply}"
    puts "Total supply:     #{stat.total_supply}"
    puts "Max supply:       #{stat.max_supply}"
    puts "Last updated:     #{stat.last_updated}"
    puts ""
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling CryptoApi->get_crypto_stats: #{e}"
end
