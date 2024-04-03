var express = require('express');
var router = express.Router();
// Require controller modules.
var api_controller = require('../controllers/api');
var Sculptures_controller = require('../controllers/Sculptures');
/// API ROUTE ///
// GET resources base.
router.get('/', api_controller.api);
/// SculpturesROUTES ///
// POST request for creating a Sculptures
router.post('/Sculptures', Sculptures_controller.Sculptures_create_post);
// DELETE request to delete Sculptures
router.delete('/Sculptures/:id', Sculptures_controller.Sculptures_delete);
// PUT request to update Sculptures
router.put('/Sculptures/:id', Sculptures_controller.Sculptures_update_put);
// GET request for one Sculptures
router.get('/Sculptures/:id', Sculptures_controller.Sculptures_detail);
// GET request for list of all Sculpturesitems.
router.get('/Sculptures', Sculptures_controller.Sculptures_list);
module.exports = router;