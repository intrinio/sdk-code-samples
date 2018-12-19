require 'intrinio-sdk'
require 'pry'

class IntrinioApp

	puts "Loading IntrinioApp"

  # This is being tested against localhost for now
	Intrinio.configure do |config|
		config.api_key['api_key'] = ENV['INTRINIO_API_KEY']
    config.scheme = 'http'
    config.host = 'localhost:9292'
	end

  def self.xbrl_api
    @xbrl_api ||= Intrinio::XBRLNotesApi.new
  end

  def self.get_all_notes
	  notes = xbrl_api.get_all_xbrl_notes
  end

  def self.search_notes(query: , **opts)
    notes = xbrl_api.search_xbrl_notes(query, opts)
  end

  def self.get_note(id, content_format: "text")
    options = { content_format: content_format }
    note = xbrl_api.get_xbrl_note(id, options)
  end

  def self.get_note_html(id)
    note = xbrl_api.get_xbrl_note_html(id)
  end

  def self.get_note_text(id)
    note = xbrl_api.get_xbrl_note_text(id)
  end

  def self.filter_notes(identifier: , **options)
    valid_options = %i(page_size next_page report_type filing_start_date filing_end_date period_ended_start_date period_ended_end_date)
    invalid_options = options.keys.reject { |key| valid_options.include?(key) }
    raise "Invalid options specified: #{invalid_options}" if invalid_options.any?
    notes = xbrl_api.filter_xbrl_notes(identifier, options)
  end


end
