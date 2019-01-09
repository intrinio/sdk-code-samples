# Load the gem
require 'intrinio-sdk'

# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end

municipality_api = Intrinio::MunicipalityApi.new
 
identifier = "geV70X" # String | An Intrinio ID of a Municipality
 
begin
  municipality = municipality_api.get_municipality_by_id(identifier)
  
  puts "#{municipality.government_name}"
  puts "-------------------------------------------------------------------------"
  puts "ID:                    #{municipality.id}"
  puts "Census ID:             #{municipality.census_id}"
  puts "Government type:       #{municipality.government_type}"
  puts "Area type:             #{municipality.area_type}"
  puts "Area name:             #{municipality.area_name}"
  puts "Web site:              #{municipality.web_site}"
  puts "Population:            #{municipality.population}"
  puts "Population as of year: #{municipality.population_as_of_year}"
  puts "Enrollment:            #{municipality.enrollment}"
  puts "Enrollment as of year: #{municipality.enrollment_as_of_year}"
  puts "Latitude:              #{municipality.latitude}" 
  puts "Longitude:             #{municipality.longitude}" 
  puts "Location:              #{municipality.address1}" 
  puts "                       #{municipality.address2}" unless municipality.address2.nil?
  puts "                       #{municipality.city}, #{municipality.state} #{municipality.zip}"

rescue Intrinio::ApiError => e
  puts "Exception when calling MunicipalityApi->get_municipality_by_id: #{e}"
end
