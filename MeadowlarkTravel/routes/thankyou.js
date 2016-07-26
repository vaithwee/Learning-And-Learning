/**
 * Created by Vaith on 16/7/26.
 */
var express = require('express');
var router = express.Router();

router.get('/', function (req, res, next) {
   res.render('thankyou'); 
});

module.exports = router;