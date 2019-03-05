# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
crypto_api = Intrinio::CryptoApi.new

opts = { 
  levels: 50, # Integer | The number of prices/levels to return on each side. For example, the max of 50 levels will return up to 50 bid prices and 50 ask prices.
  pair: "btcusd", # String | Return the order book summary for the given Crypto Currency Pair.
  exchange: "gemini", # String | Return the order book summary for a Crypto Currency on the given Crypto Exchange.
  currency: "BTC" # String | Return the order book summary for the given Crypto Currency.
}

begin
  result = crypto_api.get_crypto_book_summary(opts)
  bids = result.bids
  asks = result.asks
  puts "Crypto Currency Pair: #{result.pair.name}"
  puts "Crypto Exchange: #{result.exchange.name}"
  puts ""

  puts "--------------------------------- BIDS ---------------------------------"
  bids.each do |bid|
    puts "Price: #{bid.price}"
    puts "Size:  #{bid.size}"
    puts ""
  end

  puts "--------------------------------- ASKS ---------------------------------"
  asks.each do |ask|
    puts ""
    puts "Price: #{ask.price}"
    puts "Size:  #{ask.size}"
    puts ""
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling CryptoApi->get_crypto_book_summary: #{e}"
end
