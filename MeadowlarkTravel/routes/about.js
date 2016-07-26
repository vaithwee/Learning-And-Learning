/**
 * Created by Vaith on 16/7/26.
 */

var express = require('express');
var router = express.Router();
var fortune = require('../lib/fortune');

router.get('/', function (req, res, next) {
    res.render('about', {title: 'Meadowlark Travel', fortune: fortune.getFortune()});
})

module.exports = router;