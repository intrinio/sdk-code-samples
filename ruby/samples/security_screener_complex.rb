# Load the gem
require 'bundler/setup'
require 'intrinio-sdk'
require 'awesome_print'

# Setup authorization
Intrinio.configure do |config|
  config.api_key['api_key'] = 'YOUR_API_KEY'
end

security_api = Intrinio::SecurityApi.new

sectors = [
  'Healthcare', 
  'Services', 
  'Financial' 
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
    ap result
  end
rescue Intrinio::ApiError => e
  puts "Exception when calling SecurityApi->screen_securities: #{e}"
end
