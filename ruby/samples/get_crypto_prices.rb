# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR API KEY'
end
 
crypto_api = Intrinio::CryptoApi.new
 
timeframe = "h1" # String | The time interval for the prices.
 
opts = { 
  pair: "btcusd", # String | Return prices for the given Crypto Currency Pair.
  exchange: "gemini", # String | Return prices for a Crypto Currency on the given Crypto Exchange.
  currency: "BTC", # String | Return prices for the given Crypto Currency.
  timezone: "UTC", # String | Return price date/times in this timezone, also interpret start/end date/time parameters in this timezone.
  start_date: "2018-01-01", # String | Return Crypto Prices on or after this date.
  start_time: "14:20:00", # String | Return Crypto Prices at or after this time (24-hour).
  end_date: "2019-01-01", # String | Return Crypto Prices on or before this date.
  end_time: "21:01:21", # String | Return Crypto Prices at or before this time (24-hour).
  page_size: 100 # Integer | An integer greater than or equal to 1 for specifying the number of results on each page.
}
 
begin
  result = crypto_api.get_crypto_prices(timeframe, opts)
  prices = result.prices
  puts "#{prices.size} prices found for #{result.pair.name} on #{result.exchange.name}!"
  puts "------------------------------------------------------"
  prices.each do |price|
    puts "Time:   #{price.time}"
    puts "Open:   #{price.open}"
    puts "High:   #{price.high}"
    puts "Low:    #{price.low}"
    puts "Close:  #{price.close}"
    puts "Volume: #{price.volume}"
    puts ""
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling CryptoApi->get_crypto_prices: #{e}"
end
