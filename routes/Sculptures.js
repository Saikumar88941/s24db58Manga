var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('Sculptures', { title: 'Search results of the Sculptures'});
});

module.exports = router;