/**
 * Created by Vaith on 16/7/25.
 */
var express = require('express');
var handlebars = require('express3-handlebars').create({defaultLayout:'main'});
var fortune = require('./lib/fortune');

var app = express();
app.engine('handlebars', handlebars.engine);
app.set('view engine','handlebars');

app.set('port', process.env.PORT || 8080);
app.use(express.static('public'));

app.get('/', function (req, res) {
    res.render('home');
});

app.get('/about', function (req, res) {
    res.render('about', {fortune: fortune.getFortune()});
})

//定制404
app.use(function (req, res) {
    res.status(404);
    res.render('404');
});



//定制500界面
app.use(function (err, req, res, next) {
   console.log(err.stack);
    res.status(500);
    res.render('500');
});

app.listen(app.get('port'), function () {
   console.log('Express started on http://localhost:' + app.get('port') + ' ;press Ctrl-C to terminate');
});

