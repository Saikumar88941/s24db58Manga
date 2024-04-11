var express = require('express');
const Sculptures_controller= require('../controllers/Sculptures');
var router = express.Router();
/* GET Sculpturess */
router.get('/', Sculptures_controller.Sculptures_view_all_Page );
/* GET detail Sculptures page */
router.get('/detail', Sculptures_controller.Sculptures_view_one_Page);
/* GET create Sculptures page */
router.get('/create', Sculptures_controller.Sculptures_create_Page);
/* GET create update page */
router.get('/update', Sculptures_controller.Sculptures_update_Page);

/* GET delete Sculptures page */
router.get('/delete', Sculptures_controller.Sculptures_delete_Page);









module.exports = router;