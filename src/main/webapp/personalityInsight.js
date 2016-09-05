console.log("Server Starting...............................");

var express = require("express"),
    app = express();

var port = process.env.VCAP_APP_PORT || 8080;

app.use(express.static(__dirname + '/public'));

app.get("/hello", function (request, response) {
    response.writeHead(200, {"Content-Type": "text/plain"})
    response.end("Hello World!\n");
});

app.listen(port);

require("cf-deployment-tracker-client").track();


console.log("Server started...............................");

var watson = require('watson-developer-cloud');
var personality_insights = watson.personality_insights({
  username: '3d7bfcdc-2af9-4c39-9ace-1488364993d9',
  password: 'bz2Vwau0HFID',
  version: 'v2'
});

console.log("Starting personality insight..........................................");
//var params = require('C:\\prakash\\work\\nodejs\\profile.json');

//var params=JSON.parse(JSON.stringify("{contentItems: [ {content: 'Wow, I liked @TheRock before , now I really SEE how special he is. The daughter story was IT for me. So great! #MasterClass', contenttype: 'text/plain', created: 1447639154000, id:'666073008692314113', language: 'en', sourceid: 'Twitter API', userid: '@Oprah' } ] }"));

//console.log(params);
//personality_insights.profile({text: params}, function(error, response) {
personality_insights.profile({
	contentItems:
	[ {content: 'Wow, I liked @TheRock before , now I really SEE how special he is. The daughter story was IT for me. So great! #MasterClass',
		contenttype: 'text/plain',
		created: 1447639154000,
		id:'666073008692314113',
		language: 'en',
		sourceid: 'Twitter API',
		userid: '@Oprah'
	} ]
}, function(error, response) {
  if (error)
    console.log('error:', error);
  else
    console.log(JSON.stringify(response, null, 2));
  }
);