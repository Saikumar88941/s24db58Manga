var express = require('express');
var passport = require('passport');
const Sculptures_controller = require('../controllers/Sculptures');
var router = express.Router();
// A little function to check if we have an authorized user and continue on
// redirect to login.
const secured = (req, res, next) => {
    if (req.user) {
        return next();
    }
    res.redirect("/login");
}


/* GET Sculpturess */
router.get('/', Sculptures_controller.Sculptures_view_all_Page);
/* GET detail Sculptures page */
router.get('/detail', Sculptures_controller.Sculptures_view_one_Page);
/* GET create Sculptures page */
router.get('/create', Sculptures_controller.Sculptures_create_Page);
/* GET create update page */
router.get('/update', secured, Sculptures_controller.Sculptures_update_Page);
router.post('/login', passport.authenticate('local'), function (req, res) {
    res.redirect('/');
});


/* GET delete Sculptures page */
router.get('/delete', Sculptures_controller.Sculptures_delete_Page);









module.exports = router;