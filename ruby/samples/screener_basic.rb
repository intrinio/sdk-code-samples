# Load the gem
require 'intrinio-sdk'

# Setup authorization
Intrinio.configure do |config|
  config.api_key['api-key'] = 'YOUR API KEY'
end

security_api = Intrinio::SecurityApi.new

opts = { 
  logic: Intrinio::SecurityScreenGroup.new(
    operator: "AND",
    clauses: [
      # Marketcap >= $50m
      Intrinio::SecurityScreenClause.new(
        field: "marketcap",
        operator: "gte",
        value: 50_000_000,
      ),
      # PE < 3
      Intrinio::SecurityScreenClause.new(
        field: "pricetoearnings",
        operator: "lt",
        value: 3,
      )
    ]
  ),
  order_column: "marketcap",
  order_direction: "desc",
  primary_only: true,
}

begin
  results = security_api.screen_securities(opts)
  results.each do |result|
    marketcap = result.data.find{|x| x.tag == "marketcap"}.number_value
    pe = result.data.find{|x| x.tag == "pricetoearnings"}.number_value
    puts "#{result.security.name} | Marketcap: #{marketcap} | P/E: #{pe}"
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling SecurityApi->screen_securities: #{e}"
end
