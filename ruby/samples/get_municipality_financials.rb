# Load the gem
require 'intrinio-sdk'

# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end

municipality_api = Intrinio::MunicipalityApi.new
 
identifier = "Xn7x4z" # String | An Intrinio ID of a Municipality
 
 
begin
  financials = municipality_api.get_municipality_financials(identifier)
  municipality = financials.municipality

  puts "MUNICIPALITY"
  puts "-------------------------------------------------------------------------"
  puts "Government name: #{municipality.government_name}"
  puts "ID:              #{municipality.id}"
  puts "Census ID:       #{municipality.census_id}"
  puts "Government type: #{municipality.government_type}"
  puts "Area type:       #{municipality.area_type}"
  puts "Area name:       #{municipality.area_name}"
  puts "Location:        #{municipality.city}, #{municipality.state} #{municipality.zip}"
  puts ""
  puts "FINANCIALS"
  puts "-------------------------------------------------------------------------"
  puts "Fiscal year:         #{financials.fiscal_year}"
  puts "Current assets:      #{financials.current_assets}"
  puts "Total assets:        #{financials.total_assets}"
  puts "Current liabilities: #{financials.current_liabilities}"
  puts "Total liabilities:   #{financials.total_liabilities}"
  puts "Total net position:  #{financials.total_net_position}"
  puts "Total expenses:      #{financials.total_expenses}"
  puts "Total revenues:      #{financials.total_revenues}"
  
rescue Intrinio::ApiError => e
  puts "Exception when calling MunicipalityApi->get_municipality_financials: #{e}"
end
