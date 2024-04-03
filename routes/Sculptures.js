var express = require('express');
const Sculptures_controllers= require('../controllers/Sculptures');
var router = express.Router();
/* GET costumes */
router.get('/', Sculptures_controllers.Sculptures_view_all_Page );
module.exports = router;