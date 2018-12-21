# pip uninstall intrinio-sdk
# pip install -e ~/intrinio/intrinio-sdks/python-sdk --user
from __future__ import print_function
import time
import intrinio_sdk
from intrinio_sdk.rest import ApiException
from pprint import pprint

intrinio_sdk.ApiClient().configuration.api_key['api_key'] = 'YOUR_API_KEY'
filing_notes_api = intrinio_sdk.FilingApi()

class IntrinioApp:

    # Calls the `get_all_notes` endpoint and follows up to 10 pages worth of data,
    # repeatedly calling the endpoint with the next_page value provided in api_response.
    # Will stopp looping when `next_page` is not sent back as part of the response.
    # This method does not count the total number of items, because it will pretty much
    # always be 1000 (10 pages x 100 rows per page)
    def getAllNotes(self):
        try:
            # Get the first 10 pages of all notes by repeatedly calling get_all_notes with the 
            # next_page value returned from each call.
            print("Calling 'get_all_notes")
            print("---------------------------")

            print("Getting the first page of all notes (no 'next_page' parameter passed)")
            api_response = filing_notes_api.get_all_notes()
            print("There are {0} notes with next_page {1}".format(len(api_response.filing_notes), api_response.next_page))

            all_notes = api_response.filing_notes
            page_count = 1
            while page_count < 10 and api_response.next_page is not None:
                page_count += 1
                print("Getting page {0} of all notes use next_page value of #{1}".format(page_count, api_response.next_page))
                api_response = filing_notes_api.get_all_notes(next_page = api_response.next_page)
                all_notes += api_response.filing_notes
                print("There are {0} notes in page {1} with next_page value of {2}".format(len(api_response.filing_notes), page_count, api_response.next_page))

        except ApiException as e:
            print("Exception when calling FilingNotesApi->get_all_notes: %s\n" % e)

        return all_notes

    # Search for notes with text in `query` and return the notes in a list.
    # this endpoint _does not_ have `next_page` fun funtionality, but
    # it does offer page sizes up to 1000 rows.  In the section at the end of this file, I pass
    # a page_size of 25, but if you modify that to 1001, you can see that the error is properly caught
    # and the generated SDK properly validates the size of the message with the error
    # ValueError: Invalid value for parameter `page_size` when calling `search_notes`, must be a value less than or equal to `1000`
    def searchNotes(self, query, page_size):
        try:
            print("Calling 'search_notes")
            print("---------------------")

            print("Getting notes with term '{0}'".format(query))
            api_response = filing_notes_api.search_notes(query, page_size = page_size)
            print("There are {0} notes when searching for the term '{1}'".format(len(api_response.filing_notes), query))
            return api_response.filing_notes

        except ApiException as e:
            print("Exception when calling FilingNotesApi->get_all_notes: %s\n" % e)

    # This calls the `filter_notes` endpoint with with company and filing dates (there are others filters that are not
    # demonstrated here as described in the API documentation)
    # In this case, I'm following `next_page` to repeatedly call the endoint and count the number of items in total
    # that are retreieved.
    def filterNotes(self, company, filing_start_date, filing_end_date):
        try:
            # Search for notes with text in `query`
            print("Calling 'filter_notes' to get up to 5 pages of notes")
            print("---------------------")

            print("Getting the first page of filtered notes (no 'next_page' parameter passed)")
            api_response = filing_notes_api.filter_notes(company=company, filing_start_date = filing_start_date, filing_end_date = filing_end_date)
            print("There are {0} notes on the first page when filter for the given conditions".format(len(api_response.filing_notes)))
            print("The next_page token is {0}".format(api_response.next_page))

            page_count = 1
            note_count = len(api_response.filing_notes)
            print("Page count is {0}.  api_response.next_page length is {1}".format(page_count, len(api_response.next_page)))
            while (page_count < 10 and api_response.next_page is not None):
                page_count += 1
                print("Getting page {0} of filtered notes using next_page value of #{1}".format(page_count, api_response.next_page))
                api_response = filing_notes_api.filter_notes(company = company, filing_start_date = filing_start_date, filing_end_date = filing_end_date, next_page = api_response.next_page)
                note_count += len(api_response.filing_notes)
                print("There are {0} notes in page {1} with next_page value of {2}".format(len(api_response.filing_notes), page_count, api_response.next_page))

            print("Total notes across #{0} pages is {1}".format(page_count, note_count))

        except ApiException as e:
            print("Exception when calling FilingNotesApi->get_all_notes: %s\n" % e)



intrinio = IntrinioApp()
pprint(intrinio.getAllNotes())
print()

intrinio.searchNotes("inflation", page_size=25)
print()

intrinio.filterNotes(company = "AAPL", filing_start_date = "2018-01-01", filing_end_date = "2018-12-31")
print()
