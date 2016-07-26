/**
 * Created by Vaith on 16/7/26.
 */

var express = require('express');
var router = express.Router();

router.post('/', function (req, res, next) {

    if (req.xhr || req.accepts('json,html') === 'json') {
// 如果发生错误,应该发送 { error: 'error description' }
        res.send({success: true});
    } else {
// 如果发生错误,应该重定向到错误页面
        res.redirect(303, '/thankyou');
    }

    console.log("form:" + req.query.form);
    console.log('CSRF:' + req.body._csrf);
    console.log('name:' + req.body.name);
    console.log('email:' + req.body.email);
    /*


     res.redirect(303, '/thankyou');
     */
});

module.exports = router;