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

app.get('/hbs', function (req, res) {
   res.render('hbs', {layout : null});
});

app.get('/about', function (req, res) {
    res.render('about', {fortune: fortune.getFortune()});
});


app.get('/headers' ,function (req, res) {
    res.type('text/plain');
    var s = '';
    for (var name in req.headers)
    {
        s += name + ':' + req.header(name) + '\n';
    }
    res.send(s);
});

app.get('/newsletter', function (req, res) {
   res.render('newsletter', { csrf: 'CSRF token goes here' });
});


app.post('/process', function (req, res) {
    console.log('Form (form querystring): ' + req.query.form);
    //console.log('CSRF token (from hidden form field):' + req.body._csrf);
    console.log('Name (from visible form field): ' + req.body.name);
    console.log('Email (from visible form field): ' + req.body.email);
    res.redirect(303, '/thank-you');
});



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

