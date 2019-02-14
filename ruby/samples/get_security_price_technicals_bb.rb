# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end

security_api = Intrinio::SecurityApi.new

identifier = "AAPL" # String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)

opts = { 
  period: 20, # Integer | The number of observations, per period, to calculate Bollinger Bands
  standard_deviations: 2.0, # Float | The number of standard deviations to calculate the upper and lower bands of the Bollinger Bands
  start_date: Date.parse("2018-01-01"), # Date | Return technical indicator values on or after the date
  end_date: Date.parse("2018-12-31"), # Date | Return technical indicator values on or before the date
  timezone: "America/New_York", # String | Returns technical indicators in this timezone
  next_page: nil # String | gets the next page of data from an already-executed API call
}

begin
  result = security_api.get_security_price_technicals_bb(identifier, opts)
  technicals = result.technicals  
  indicator = result.indicator
  security = result.security

  puts "Technicals for #{security.ticker}"
  puts "#{technicals.size} values for #{indicator.name} returned!"
  puts ""

  technicals.each do |t|
    puts "DateTime:    #{t.date_time}"
    puts "Lower band:  #{t.lower_band}"
    puts "Middle band: #{t.middle_band}"
    puts "Upper band:  #{t.upper_band}"
    puts "----------------------------------------------------------------"
  end

rescue Intrinio::ApiError => e
  puts "Exception when calling SecurityApi->get_security_price_technicals_bb: #{e}"
end
