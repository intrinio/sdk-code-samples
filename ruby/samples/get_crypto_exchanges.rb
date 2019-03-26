# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
crypto_api = Intrinio::CryptoApi.new
 
opts = { 
  pair: "btcusd" # String | Returns Crypto Currencies traded on the given Crypto Exchange.
}
 
begin
  result = crypto_api.get_crypto_exchanges(opts)
  exchanges = result.exchanges
  
  if opts[:pair]
    puts "#{exchanges.size} exchanges found for #{opts[:pair]}!"
  else
    puts "#{exchanges.size} exchanges found!"
  end

  puts "------------------------------------------------------------"
  exchanges.each do |exchange|
    puts "Name:                 #{exchange.name}"
    puts "Code:                 #{exchange.code}"
    puts "Book depth available: #{exchange.book_depth_available}"
    puts "History available:    #{exchange.history_available}"
    puts "Snapshot available:   #{exchange.snapshot_available}"
    puts "Trades available:     #{exchange.trades_available}"
    puts ""
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling CryptoApi->get_crypto_exchanges: #{e}"
end
