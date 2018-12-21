var express = require('express');
var intrinio = require('intrinio');
const util = require('util')

var app = express();
var apiKey = process.env.INTRINIO_API_KEY

console.log(apiKey)

intrinio.ApiClient.instance.authentications['ApiKeyAuth'].apiKey = apiKey;
// intrinio.ApiClient.instance.authentications['HttpHeaderApiKey'].apiKey = "";

app.get("/", function(req, res) {
  res.send("<center><h1>Merry Christmas, ya filthy animals</h1></center>")
  }, function(error) {
    console.error(error);
  });

app.get("/notes", function(req, res) {
  var api = new intrinio.FilingApi();
  api.getAllNotes().then(function(data) {
    res.send(data.filing_notes)
  }, function(error) {
    console.error(error);
  });
})

// One note text
app.get("/notes/:identifier", function(req, res) {
  var api = new intrinio.FilingApi();

  api.getNote(req.params.identifier).then(function(data) {
		res.send(data)
  }, function(error) {
		res.send(error)
  });
})
//
// One note html
app.get("/notes/:identifier/html", function(req, res) {
  var api = new intrinio.FilingApi();

  api.getNoteHtml(req.params.identifier).then(function(data) {
		res.send(data)
  }, function(error) {
		res.send(error)
  });
})

app.listen(3000, function() {
  console.log("Intrinio App listening on port 3000");
})

