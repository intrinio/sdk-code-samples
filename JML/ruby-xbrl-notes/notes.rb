require 'intrinio-sdk'

# NOTE:  As configured, this sample uses a locally-generated ruby SDK.  The commented code is for the github-hosted version
#        which does not currently included XBRL Notes

class IntrinioApp

  puts "Loading IntrinioApp"

  # As configured, this runs against api-v2 running locally.
  # comment out scheme & host to use the production server
  Intrinio.configure do |config|
    config.api_key['api_key'] = ENV['INTRINIO_API_KEY']
    config.scheme = 'http'
    config.host = 'localhost:9292'
  end

  # This will grab the first 3 pages of notes without any filtering (300 in total with 100 per page)
  # and take a sample size of `count`, and retrieve that many notes.  The return is an array
  # of Intrinio::FilingNote instances.  The value of `content` will depend on what was 
  # passed in for `format` (either text or html)
  def self.sample_notes(count, format: 'text')
    notes = get_all_notes(max_pages: 3)
    notes.sample(count).map { |note| self.get_note(note.id, content_format: format ) }
  end

  # This will grab the first 3 pages of notes without any filtering (300 in total with 100 per page)
  # and take a sample size of `count`, and retrieve that many notes.  The return is an array
  # of strings with the HTML stripped out as much as possible.  
  def self.sample_notes_text(count)
    notes = get_all_notes(max_pages: 3)
    notes.sample(count).map { |note| self.get_note_text(note.id) }
  end

  # This will grab the first 3 pages of notes without any filtering (300 in total with 100 per page)
  # and take a sample size of `count`, and retrieve that many notes.  The return is an array
  # of strings with the content exactly as filed in the original XBRL instance document.
  def self.sample_notes_html(count)
    notes = get_all_notes(max_pages: 3)
    notes.sample(count).map { |note| self.get_note_html(note.id) }
  end

  # Performs a full-text search on XBRL notes for the string in `query`.  The search
  # is performed by breaking the query into stemmed words, and comparing ngrams of those 
  # words against each note.  The results are returned with the best match first, lowest match
  # last.  Returns an array of Intrinio::FilingNote instances.
  def self.run_search(query, **options)
    notes, pages = self.all_data(:search_xbrl_notes, query, options)
    puts "Search for #{query} has #{notes.count} notes spanning #{pages} pages" 
    notes
  end


  # Filters notes based on company, filings between start and end dates, and report type.
  # Returns an array of Intrinio::FilingNote instances.
  def self.filter_notes(company: nil, start_date: "2017-01-01", end_date: "2018-12-31", report_type: '10-Q', **options)
    start_date = Date.parse(start_date) if start_date.is_a?(String)
    end_date = Date.parse("2018-12-31") if end_date.is_a?(String)

    # Filter notes and get them all.  `#filter_notes` will use the next_page token to get
    # every page of the results.  Be cafeful, this could be a _large_ dataset.
    default_options = {
      company: company,
      report_type: report_type,
      filing_start_date: start_date,
      filing_end_date: end_date
    }

    options = default_options.merge(options)

    notes, pages = self.all_data(:filter_xbrl_notes, options)
 
    filing_dates = notes.map {|n| n.filing.filing_date}.uniq
    if filing_dates.count > 10
      filing_dates = "#{filing_dates.count} different filing dates"
    else
      filing_dates = filing_dates.map {|d| d.strftime("%Y-%m-%d") }.join(", ")
      filing_dates = "filing dates of #{filing_dates}"
    end

    puts "#{company} has #{notes.count} notes spanning #{pages} pages with #{filing_dates}, using filter between #{start_date} and #{end_date}" 
    notes
  end

  # Creates a reusable API instance that is used for all calls
  def self.filing_notes_api
    @filing_notes_api ||= Intrinio::FilingNotesApi.new
  end


  # Uses the get_all_xbrl_notes and retrieves `max_pages` worth of data, combining them all into a single array
  def self.get_all_notes(max_pages: 100)
    options = { max_pages: max_pages }
    notes, pages = self.all_data(:get_all_xbrl_notes, options)
    puts "Get all notes has #{notes.count} notes spanning #{pages} pages, limited to #{max_pages} pages" 
    notes
  end

  # Direct interface to the `search_xbrl_notes` endpoint
  def self.search_notes(query: , **opts)
    notes = filing_notes_api.search_xbrl_notes(query, opts)
  end

  # Direct interface to the `get_xbrl_note` endpoint
  def self.get_note(id, content_format: "text")
    options = { content_format: content_format }
    note = filing_notes_api.get_xbrl_note(id, options)
  end

  # Direct interface to the `get_xbrl_note_html` endpoint
  def self.get_note_html(id)
    note = filing_notes_api.get_xbrl_note_html(id)
  end

  # Direct interface to the `get_xbrl_note_text` endpoint
  def self.get_note_text(id)
    note = filing_notes_api.get_xbrl_note_text(id)
  end

  # Intelligently handles calls to endpoints that return data across multiple
  # pages using `next_page`.  If :max_pages is specified as a named parameter,
  # only that many pages will be retrieved.  Arguments and options are as-defined
  # in the API documentation.
  # RETURNS: an array of data assembled by merging each page's results into a single array
  # EXAMPLE (gets 10 pages of notes with "risk" filed within the last 90 days)
  #   all_data(:search_xbrl_notes, "risk", max_pages: 10, filing_start_date: Date.today - 90) 
  # EXAMPLE (gets 10 pages of notes for Apple Computer)
  #   all_data(:get_all_xbrl_notes, max_pages: 10, company: 'AAPL') 
  def self.all_data(method, *args, **options)
    max_pages = options.delete(:max_pages) || 100
    
    # Remove options if the value is nil
    options.delete_if { |key,val| val.nil? }

    # create a block we can repeatedly call with next page
    get_page = -> (opts) { filing_notes_api.send(method, *args, opts) }
    data = []

    page_count = 0
    while true && (page_count < max_pages) do
      page = get_page.call(options)
      data_key ||= (page.to_hash.keys - [:next_page]).first
      page_data = page.send(data_key)

      data += page_data
      page_count += 1
      puts "Pages retreived: #{page_count}, page data count: #{page_data.count}, total count: #{data.count}"

      break if page_data.none? || !page.respond_to?(:next_page) || page.next_page.nil?
      options[:next_page] = page.next_page
    end
    [data, page_count]
  end


end
