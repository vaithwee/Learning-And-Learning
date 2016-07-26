/**
 * Created by Vaith on 16/7/26.
 */

var express = require('express');
var router = express.Router();
var formidable = require('formidable');

router.get('/vacation-photo', function (req, res) {
    var now = new Date();
    res.render('vacation-photo', {year: now.getFullYear(), month: now.getMonth()});
});

router.post('/vacation-photo/:year/:mouth', function (req, res) {
    var form = new formidable.IncomingForm();
    form.parse(req, function (err, fields, files) {
        if (err) {
            return res.redirect(303, '/error');
        }
        console.log('received fields:');
        console.log(fields);
        console.log('received files:');
        console.log(files);
        res.redirect(303, '/thankyou');
    });
});

module.exports = router;