# First, follow the installation instructions at https://github.com/intrinio/ruby-sdk

# Load the gem
require 'intrinio-sdk'

# Setup authorization
Intrinio.configure do |config|
  config.api_key['api-key'] = 'YOUR API KEY'
end

security_api = Intrinio::SecurityApi.new

sectors = [
  'Healthcare',
  'Services',
  'Financial',
]

opts = { 
  logic: Intrinio::SecurityScreenGroup.new(
    operator: "AND",
    clauses: [
      # Employees > 100,000
      Intrinio::SecurityScreenClause.new(
        field: "employees",
        operator: "gt",
        value: 100_000,
      )
    ],
    groups: [
      # In any of the sectors
      Intrinio::SecurityScreenGroup.new(
        operator: "OR",
        clauses: sectors.map {|sector|
          Intrinio::SecurityScreenClause.new(
            field: "sector",
            operator: "eq",
            value: sector,
          )
        },
      ),
      # Not in the state of California
      Intrinio::SecurityScreenGroup.new(
        operator: "NOT",
        clauses: [
          Intrinio::SecurityScreenClause.new(
            field: "state",
            operator: "eq",
            value: "California",
          )
        ],
      ),
    ]
  ),
  order_column: "employees",
  order_direction: "desc",
  primary_only: true,
}

begin
  results = security_api.screen_securities(opts)
  results.each do |result|
    sector = result.data.find{|x| x.tag == "sector"}.text_value
    employees = result.data.find{|x| x.tag == "employees"}.number_value
    puts "#{result.security.name} | Sector: #{sector} | Employees: #{employees}"
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling SecurityApi->screen_securities: #{e}"
end
