# Load the gem
require 'intrinio-sdk'

# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end

municipality_api = Intrinio::MunicipalityApi.new

opts = { 
  next_page: nil # String | Gets the next page of data from a previous API call
}

begin
  result = municipality_api.get_all_municipalities(opts)
  municipalities = result.municipalities

  puts "#{municipalities.size} municipalities found!"

  municipalities.each.with_index(1) do |municipality, index|
    puts ""
    puts "#{index}.  #{municipality.government_name}"
    puts "-------------------------------------------------------------------------"
    puts "ID:              #{municipality.id}"
    puts "Census ID:       #{municipality.census_id}"
    puts "Government type: #{municipality.government_type}"
    puts "Area type:       #{municipality.area_type}"
    puts "Area name:       #{municipality.area_name}"
    puts "Location:        #{municipality.city}, #{municipality.state} #{municipality.zip}"
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling MunicipalityApi->get_all_municipalities: #{e}"
end
