### Javascript SDK Demo App

I tried to do something a little different than a plain old console app, so I created a Node express web server that outputs results through a browser.

### Quickstart

With a terminal in this directory, install required node packages by running `npm install`.  This will install the intrinio-sdk repo.  Then, just run `node app.js`.  A web server will be running on port 3000, which you get to just like a ruby app.  For example, to get information on Walmart:  `localhost:3000/companies/WMT`

The result is just a simple dump of the return object in a HTML table styled with bootstrap to make in pretty:

![](wmt.png?raw=true "Screenshot")

There's also one for Stock Exchanges:  `localhost:3000/stock_exchanges/USCOMP`:

![](uscomp.png?raw=true "Screenshot")