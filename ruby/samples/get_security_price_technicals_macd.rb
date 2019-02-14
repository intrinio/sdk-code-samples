# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end

security_api = Intrinio::SecurityApi.new

identifier = "AAPL" # String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)

opts = {}

begin
  result = security_api.get_security_price_technicals_macd(identifier, opts)
  technicals = result.technicals  
  indicator = result.indicator
  security = result.security

  puts "Technicals for #{security.ticker}"
  puts "#{technicals.size} values for #{indicator.name} returned!"
  puts ""

  technicals.each do |t|
    puts "DateTime:       #{t.date_time}"
    puts "MACD Histogram: #{t.macd_histogram}"
    puts "MACD Line:      #{t.macd_line}"
    puts "Signal Line:    #{t.signal_line}"
    puts "----------------------------------------------------------------"
  end

rescue Intrinio::ApiError => e
  puts "Exception when calling SecurityApi->get_security_price_technicals_macd: #{e}"
end
