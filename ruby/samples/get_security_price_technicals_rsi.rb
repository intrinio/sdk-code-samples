# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end

security_api = Intrinio::SecurityApi.new

identifier = "AAPL" # String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)

opts = {
  start_date: Date.parse("2019-01-01"), # Date | Return technical indicator values on or after the date
  end_date: Date.parse("2019-01-31"), # Date | Return technical indicator values on or before the date
  timezone: "America/New_York", # String | Returns technical indicators in this timezone
}
 
begin
  result = security_api.get_security_price_technicals_rsi(identifier, opts)
  technicals = result.technicals  
  indicator = result.indicator
  security = result.security

  puts "Technicals for #{security.ticker}"
  puts "#{technicals.size} values for #{indicator.name} returned!"
  puts ""

  technicals.each do |t|
    puts "DateTime: #{t.date_time}"
    puts "RSI:      #{t.rsi}"
    puts "----------------------------------------------------------------"
  end

rescue Intrinio::ApiError => e
  puts "Exception when calling SecurityApi->get_security_price_technicals_rsi: #{e}"
end
