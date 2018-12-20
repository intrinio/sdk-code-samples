# Load the gem
require 'intrinio-sdk'
 
# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end
 
security_api = Intrinio::SecurityApi.new
 
identifier = "AAPL" # String | A Security identifier (Ticker, FIGI, ISIN, CUSIP, Intrinio ID)
 
begin
  result = security_api.get_security_latest_earnings_record(identifier)
  security = result.security

  puts "Security Summary"
  puts "-------------------------------------------------"
  puts "Name:       #{security.name}"
  puts "Code:       #{security.code}"
  puts "Company ID: #{security.company_id}"
  puts "Ticker:     #{security.ticker}"
  puts ""
  puts ""
  puts "Latest Earnings Record"
  puts "-------------------------------------------------"
  puts "Quarter:                   #{result.quarter}"
  puts "Q1 date:                   #{result.q1_date}"
  puts "Q2 date:                   #{result.q2_date}"
  puts "Q3 date:                   #{result.q3_date}"
  puts "Q4 date:                   #{result.q4_date}"
  puts "Type:                      #{result.type}"
  puts "Next earnings date:        #{result.next_earnings_date}"
  puts "Next earnings quarter:     #{result.next_earnings_quarter}"
  puts "Next earnings fiscal year: #{result.next_earnings_fiscal_year}"

rescue Intrinio::ApiError => e
  puts "Exception when calling SecurityApi->get_security_latest_earnings_record: #{e}"
end
