var express = require('express');
var cheerio = require('cheerio');
var superagent = require('superagent');

var app = express();


app.get('/', function(req, res, next){
	superagent.get('https://cnodejs.org/').end(function(err, sres){
		if (err) 
		{
			return next(err);
		}
		console.log(sres);
		var $ = cheerio.load(sres.text);
		var items = [];
		$('#topic_list .topic_title').each(function(idx, element){
			var $element = $(element);
			items.push({
				title:$element.attr('title'),
				href:$element.attr('href')
			});
		});
		res.send(items);
	});
});


app.listen(process.env.PORT || 8080, function(){
	console.log('app is listening 8080 port , please visit localhost:8080');
});