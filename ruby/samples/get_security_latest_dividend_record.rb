# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end
 
security_api = Intrinio::SecurityApi.new
 
identifier = "AAPL" # String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
 
begin
  result = security_api.get_security_latest_dividend_record(identifier)
  security = result.security

  puts "Security Summary"
  puts "-------------------------------------------------"
  puts "Name:       #{security.name}"
  puts "Code:       #{security.code}"
  puts "Company ID: #{security.company_id}"
  puts "Ticker:     #{security.ticker}"
  puts ""
  puts ""
  puts "Latest Dividend Record"
  puts "-------------------------------------------------"
  puts "Announcement date: #{result.announcement_date}"
  puts "Record date:       #{result.record_date}"
  puts "Pay date:          #{result.pay_date}"
  puts "Frequency:         #{result.frequency}"
  puts "Status:            #{result.status}"
  puts "Forward yield:     #{result.forward_yield}"
  puts "Forward rate:      #{result.forward_rate}"

rescue Intrinio::ApiError => e
  puts "Exception when calling SecurityApi->get_security_latest_dividend_record: #{e}"
end
