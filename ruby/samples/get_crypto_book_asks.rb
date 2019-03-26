# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
crypto_api = Intrinio::CryptoApi.new
 
opts = { 
  pair: "btcusd", # String | Return the order book asks for the given Crypto Currency Pair.
  exchange: "gemini", # String | Return the order book asks for a Crypto Currency on the given Crypto Exchange.
  currency: "BTC" # String | Return the order book asks for the given Crypto Currency.
}
 
begin
  result = crypto_api.get_crypto_book_asks(opts)
  asks = result.asks
  puts "Crypto Currency Pair: #{result.pair.name}"
  puts "Crypto Exchange: #{result.exchange.name}"
  puts ""
  puts "ASKS"
  puts "-------------------------------------------------------------------------------------------"

  asks.each do |ask|
    puts ""
    puts "Price: #{ask.price}"
    puts "Size:  #{ask.size}"
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling CryptoApi->get_crypto_book_asks: #{e}"
end
