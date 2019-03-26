# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
crypto_api = Intrinio::CryptoApi.new
 
opts = { 
  pair: "btcusd", # String | Return the snapshot for the given Crypto Currency Pair.
  exchange: "gemini", # String | Return the snapshot for a Crypto Currency on the given Crypto Exchange.
  currency: "BTC" # String | Return the snapshot for the given Crypto Currency.
}
 
begin
  result = crypto_api.get_crypto_snapshot(opts)
  snapshot = result.snapshot
  puts "Snapshot for #{result.pair.name} on #{result.exchange.name}!"
  puts "------------------------------------------------------"
  puts "Last updated:     #{snapshot.last_updated}"
  puts "Bid:              #{snapshot.bid}"
  puts "Bid size:         #{snapshot.bid_size}"
  puts "Ask:              #{snapshot.ask}"
  puts "Ask size:         #{snapshot.ask_size}"
  puts "Change:           #{snapshot.change}"
  puts "Change percent:   #{snapshot.change_percent}"
  puts "Volume:           #{snapshot.volume}"
  puts "Open:             #{snapshot.open}"
  puts "High:             #{snapshot.high}"
  puts "Low:              #{snapshot.low}"
  puts "Last trade side:  #{snapshot.last_trade_side}"
  puts "Last trade time:  #{snapshot.last_trade_time}"
  puts "Last trade price: #{snapshot.last_trade_price}"
  puts "Last trade size:  #{snapshot.last_trade_size}"
rescue Intrinio::ApiError => e
  puts "Exception when calling CryptoApi->get_crypto_snapshot: #{e}"
end
